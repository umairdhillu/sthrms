package com.soltechsystem.view.leaves_management;

import com.soltechsystem.view.general.ADFUtil;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;

public class LeaveManagement {
    private RichTable leavesTable;
    private RichPopup leavesPopup;
    private RichPopup loanPopup;
    private RichTable loanTable;
    private RichPopup advSalaryPopup;
    private RichTable advSalaryTable;

    public LeaveManagement() {
    }

    public String newLeave() {
        ADFUtil.callOperation("CreateInsert", null);
        getLeavesPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setLeavesTable(RichTable leavesTable) {
        this.leavesTable = leavesTable;
    }

    public RichTable getLeavesTable() {
        return leavesTable;
    }

    public void setLeavesPopup(RichPopup leavesPopup) {
        this.leavesPopup = leavesPopup;
    }

    public RichPopup getLeavesPopup() {
        return leavesPopup;
    }

    public String saveLeave() {
        getLeavesPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("EmployeeLeavesView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getLeavesTable());
        return null;
    }

    public String cancelLeave() {
        ADFUtil.callOperation("Rollback", null);
        getLeavesPopup().hide();
        return null;
    }

    public String editLeavePopup() {
        getLeavesPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String approveLeave() {
        Row r =  ADFUtil.getViewObject("LeavesApprovals1Iterator").getCurrentRow();
        int employeeID = ((BigDecimal)r.getAttribute("EmployeeId")).intValue();
        int leaveId = ((BigDecimal)r.getAttribute("LeaveId")).intValue();
        
        String action = "HOD_APPROVED";
        String leaveType = r.getAttribute("LeaveTypeName").toString();
        int total = ((BigDecimal)r.getAttribute("NumberOfLeaves")).intValue();
        
        Map params = new HashMap();
        params.put("employeeID",employeeID);
        params.put("leaveID",leaveId);
        params.put("action", action);
        params.put("leaveType",leaveType);
        params.put("total", total);
        
        ADFUtil.callOperation("leaveAction", params);
        
        ADFUtil.getViewObject("LeavesApprovals1Iterator").executeQuery();
        return null;
    }

    public String rejectLeave() {
        Row r =  ADFUtil.getViewObject("LeavesApprovals1Iterator").getCurrentRow();
        int employeeID = (Integer)r.getAttribute("EmployeeId");
        int leaveId = (Integer)r.getAttribute("LeaveId");
        String action = "HOD_REJECT";
        String leaveType = r.getAttribute("LeaveTypeName").toString();
        int total = (Integer)r.getAttribute("NumberOfLeaves");
        
        Map params = new HashMap();
        params.put("employeeID",employeeID);
        params.put("leaveID",leaveId);
        params.put("action", action);
        params.put("leaveType",leaveType);
        params.put("total", total);
        
        ADFUtil.callOperation("leaveAction", params);
        ADFUtil.getViewObject("LeavesApprovals1Iterator").executeQuery();
        return null;
    }

    public String adminView() {
        Row r =  ADFUtil.getViewObject("LeaveNotification1Iterator").getCurrentRow();
        int employeeID = ((BigDecimal)r.getAttribute("EmployeeId")).intValue();
        int leaveId = ((BigDecimal)r.getAttribute("LeaveId")).intValue();
        
        String action = "ADMIN_VIEWED";
        String leaveType = r.getAttribute("LeaveTypeName").toString();
        int total = ((BigDecimal)r.getAttribute("NumberOfLeaves")).intValue();
        
        Map params = new HashMap();
        params.put("employeeID",employeeID);
        params.put("leaveID",leaveId);
        params.put("action", action);
        params.put("leaveType",leaveType);
        params.put("total", total);
        
        ADFUtil.callOperation("leaveAction", params);
        
        ADFUtil.getViewObject("LeaveNotification1Iterator").executeQuery();
        return null;
    }

    public String showLoanPopup() {
        ADFUtil.callOperation("CreateInsert5", null);
        getLoanPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setLoanPopup(RichPopup loanPopup) {
        this.loanPopup = loanPopup;
    }

    public RichPopup getLoanPopup() {
        return loanPopup;
    }

    public String saveLoanExit() {
        getLoanPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("PrlLoanView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(loanTable);
        return null;
    }

    public void setLoanTable(RichTable loanTable) {
        this.loanTable = loanTable;
    }

    public RichTable getLoanTable() {
        return loanTable;
    }

    public String exitLoanPopup() {
        ADFUtil.callOperation("Rollback", null);
        getLoanPopup().hide();
        return null;
    }

    public String editLoan() {
        getLoanPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String showAdvSalaryPopup() {
        ADFUtil.callOperation("CreateInsert6", null);
        getAdvSalaryPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setAdvSalaryPopup(RichPopup advSalaryPopup) {
        this.advSalaryPopup = advSalaryPopup;
    }

    public RichPopup getAdvSalaryPopup() {
        return advSalaryPopup;
    }

    public String editAdvSalary() {
        getAdvSalaryPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveAdvSalaryAndExit() {
        getAdvSalaryPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("PrlAdvanceSalaryView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getAdvSalaryTable());
        return null;
    }

    public void setAdvSalaryTable(RichTable advSalaryTable) {
        this.advSalaryTable = advSalaryTable;
    }

    public RichTable getAdvSalaryTable() {
        return advSalaryTable;
    }

    public String exitAdvSalary() {
        ADFUtil.callOperation("Rollback", null);
        getAdvSalaryPopup().hide();
        return null;
    }

    public String subordinateAtdInAction() {
        Row r = ADFUtil.getViewObject("SubordinateDailyAttendance1Iterator").getCurrentRow();
        int attendanceId = ((BigDecimal)r.getAttribute("AttendanceId")).intValue();
        String action = "IN";
        
        Map params = new HashMap();
        params.put("action",action);
        params.put("atdID",attendanceId);
        
        ADFUtil.callOperation("logSubordinateDailyAtd", params);
        ADFUtil.getViewObject("SubordinateDailyAttendance1Iterator").executeQuery();
        
        
        return null;
    }

    public String subordinateAtdOutAction() {
        Row r = ADFUtil.getViewObject("SubordinateDailyAttendance1Iterator").getCurrentRow();
        int attendanceId = ((BigDecimal)r.getAttribute("AttendanceId")).intValue();
        String action = "OUT";
        
        Map params = new HashMap();
        params.put("action",action);
        params.put("atdID",attendanceId);
        
        ADFUtil.callOperation("logSubordinateDailyAtd", params);
        ADFUtil.getViewObject("SubordinateDailyAttendance1Iterator").executeQuery();
        return null;
    }
}
