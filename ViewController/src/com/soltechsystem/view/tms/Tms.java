package com.soltechsystem.view.tms;

import com.soltechsystem.view.general.ADFUtil;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class Tms {
    private RichTable shiftsAll;
    

    public Tms() {
    }

    public String assignShifts() {
        Row r = ADFUtil.getViewObject("ShiftAssignParameterForm1Iterator").getCurrentRow();
        System.out.println(r.getAttribute("EmployeeId")+ " - "+ r.getAttribute("DepartmentId")+"-"+r.getAttribute("ShiftId"));
        
        Map params = new HashMap();
        params.put("employeeID", r.getAttribute("EmployeeId").toString().equals("0")?null:r.getAttribute("EmployeeId").toString());
        params.put("departmentID", r.getAttribute("DepartmentId").toString().equals("0")?null:r.getAttribute("DepartmentId").toString());
        params.put("shiftID", r.getAttribute("ShiftId").toString());
        ADFUtil.callOperation("assignShift", params);
        
        
        ADFUtil.getViewObject("ShiftsAll1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getShiftsAll());
        return null;
    }

    public void setShiftsAll(RichTable shiftsAll) {
        this.shiftsAll = shiftsAll;
    }

    public RichTable getShiftsAll() {
        return shiftsAll;
    }

    public String generateRoster() {
        Row r = ADFUtil.getViewObject("AutoAttendanceParameterForm1Iterator").getCurrentRow();
        System.out.println(r.getAttribute("EmployeeId")+ " - "+ r.getAttribute("DepartmentId"));
        
        Map params = new HashMap();
        params.put("employeeID", r.getAttribute("EmployeeId").toString().equals("0")?null:r.getAttribute("EmployeeId").toString());
        params.put("departmentID", r.getAttribute("DepartmentId").toString().equals("0")?null:r.getAttribute("DepartmentId").toString());
        
        ADFUtil.callOperation("generateRoster", params);
        ADFUtil.showMessage("Roster Generated.");
        return null;
    }


    public String grantLeaves() {
        Row r = ADFUtil.getViewObject("LeaveGrantParameterForm1Iterator").getCurrentRow();
     // System.out.println(r.getAttribute("EmployeeId")+ " - "+ r.getAttribute("DepartmentId"));
        
        Map params = new HashMap();
        params.put("employeeID", r.getAttribute("EmployeeId").toString().equals("0")?null:r.getAttribute("EmployeeId").toString());
        params.put("departmentID", r.getAttribute("DepartmentId").toString().equals("0")?null:r.getAttribute("DepartmentId").toString());
        
        ADFUtil.callOperation("grantLeaves", params);
        
        ADFUtil.getViewObject("LeaveBalances1Iterator").executeQuery();
        
        return null;
    }
}
