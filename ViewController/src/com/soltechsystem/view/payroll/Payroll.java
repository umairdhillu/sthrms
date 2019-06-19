package com.soltechsystem.view.payroll;

import com.soltechsystem.view.general.ADFUtil;
import com.soltechsystem.view.general.OracleReport;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.PartialRichPopup;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Date;

public class Payroll {
    private RichPopup monthlyAdjustPopup;
    private RichTable monthlyAdjustTable;
    private RichPopup overtimePopup;
    private RichTable overtimeTable;
    private RichPopup advSalaryPopup;
    private RichTable advSalaryTable;
    private RichPopup loanPopup;
    private RichTable loanTable;
    private RichPopup leavesPopup;
    private RichTable leavesTable;
    private RichPopup bankPopup;
    private RichTable bankTable;
    private RichSelectOneChoice reportBind;
    private RichInputDate dateFrom;
    private RichInputDate dateTo;
    private RichSelectOneChoice employeeType;
    private RichSelectOneChoice departmentType;
    private RichSelectOneChoice designation;
    private RichSelectOneChoice paymentMode;
    private RichSelectOneChoice allowenceDeduction;
    private RichInputText grossPayFrom;
    private RichInputListOfValues employee;
    private RichPopup payrollConfirmationDialog;

    public Payroll() {
        super();
    }

    public String hideMonthlyAdjustPopup() {
        getMonthlyAdjustPopup().hide();
        ADFUtil.callOperation("Commit", null);
        ADFUtil.getViewObject("PrlSpecialAllowDeductView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getMonthlyAdjustTable());
        return null;
    }

    public void setMonthlyAdjustPopup(RichPopup monthlyAdjustPopup) {
        this.monthlyAdjustPopup = monthlyAdjustPopup;
    }

    public RichPopup getMonthlyAdjustPopup() {
        return monthlyAdjustPopup;
    }

    public void setMonthlyAdjustTable(RichTable monthlyAdjustTable) {
        this.monthlyAdjustTable = monthlyAdjustTable;
    }

    public RichTable getMonthlyAdjustTable() {
        return monthlyAdjustTable;
    }

    public String showMonthlyAdjustPopup() {
        ADFUtil.callOperation("CreateInsert3", null);
        getMonthlyAdjustPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setOvertimePopup(RichPopup overtimePopup) {
        this.overtimePopup = overtimePopup;
    }

    public RichPopup getOvertimePopup() {
        return overtimePopup;
    }

    public String saveOvertimeAndExit() {
        getOvertimePopup().hide();

        ADFUtil.callOperation("CommitHR", null);
        System.out.println("overtime saved");
        ADFUtil.getViewObject("HrEmpOvertimeView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getOvertimeTable());


        return null;
    }

    public String cancelOvertimePopup() {
        ADFUtil.callOperation("Rollback", null);
        getOvertimePopup().hide();
        return null;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String openOvertimePopup() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert7");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }

        getOvertimePopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setOvertimeTable(RichTable overtimeTable) {
        this.overtimeTable = overtimeTable;
    }

    public RichTable getOvertimeTable() {
        return overtimeTable;
    }

    public String generate() {
        
        
        int exists = (Integer)ADFUtil.callOperation("payrollExist", null);
        if (exists==1){
            getPayrollConfirmationDialog().show(new RichPopup.PopupHints());
        }else{
            runPayrollYesOption();
        }
        

        
        
        return null;
    }

    public String runReport() {
        String reportName, dateFromStr, dateToStr, empType, departmentID, desgID, paymentMode, allowDeductID, grossPayFrom, employeeID;
        if (ADFUtil.evaluateEL("#{bindings.reportName.inputValue}") == null) {
            reportName = "";
        } else {
            reportName = (String) ADFUtil.evaluateEL("#{bindings.reportName.inputValue}");
        }

        if (ADFUtil.evaluateEL("#{bindings.DateFrom.inputValue}") == null) {
            dateFromStr = "";
        } else {
            Date dateFrom = (Date) ADFUtil.evaluateEL("#{bindings.DateFrom.inputValue}");
            dateFromStr = new SimpleDateFormat("dd-MM-yyyy").format(dateFrom.getValue());
        }

        if (ADFUtil.evaluateEL("#{bindings.DateTo.inputValue}") == null) {
            dateToStr = "";
        } else {
            Date dateTo = (Date) ADFUtil.evaluateEL("#{bindings.DateTo.inputValue}");

            dateToStr = new SimpleDateFormat("dd-MM-yyyy").format(dateTo.getValue());
        }

        if (ADFUtil.evaluateEL("#{bindings.EmployeeType1.inputValue}").equals("")) {
            empType = "";
        } else {
            empType = ADFUtil.evaluateEL("#{bindings.EmployeeType1.inputValue}").toString();
        }

        if (ADFUtil.evaluateEL("#{bindings.Department1.inputValue}").equals("")) {
            departmentID = "";
        } else {
            departmentID = ADFUtil.evaluateEL("#{bindings.Department1.inputValue}").toString();
        }

        if (ADFUtil.evaluateEL("#{bindings.Designation1.inputValue}").equals("")) {
            desgID = "";
        } else {
            desgID = ADFUtil.evaluateEL("#{bindings.Designation1.inputValue}").toString();
        }
        if (ADFUtil.evaluateEL("#{bindings.PaymentMode.inputValue}").equals("")) {
            paymentMode = "";
        } else {
            paymentMode = ADFUtil.evaluateEL("#{bindings.PaymentMode.inputValue}").toString();
        }

        if (ADFUtil.evaluateEL("#{bindings.AllowenceDeduction.inputValue}").equals("")) {
            allowDeductID = "";
        } else {
            allowDeductID = ADFUtil.evaluateEL("#{bindings.AllowenceDeduction.inputValue}").toString();
        }
        if (ADFUtil.evaluateEL("#{bindings.GrossPayFrom.inputValue}") == null) {
            grossPayFrom = "";
        } else {
            grossPayFrom = ADFUtil.evaluateEL("#{bindings.GrossPayFrom.inputValue}").toString();
        }

        if (ADFUtil.evaluateEL("#{bindings.EmployeeId6.inputValue}") == null) {
            employeeID = "";
        } else {
            employeeID = ADFUtil.evaluateEL("#{bindings.EmployeeId6.inputValue}").toString();
        }

        System.out.println(reportName + " ," + dateFromStr + ", " + dateToStr + " ," + empType + ", " + departmentID +
                           ", " + desgID + " ," + paymentMode + " ," + allowDeductID + ", " + grossPayFrom + "," +
                           employeeID);

        OracleReport report = new OracleReport("103.62.233.166", "8889", null);
        report.setReportServerParam(OracleReport.RS_PARAM_DESTYPE,
                                    "cache"); // which will be one of the [cashe - file - mail - printer]
        report.setReportServerParam(OracleReport.RS_PARAM_DESFORMAT,
                                    "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        report.setReportServerParam(OracleReport.RS_PARAM_REPORT, "C:\\\\Reports\\\\" + reportName);
        report.setReportServerParam("USERID", "sthrms/sthrms786@xe");
        report.setReportParameter("P_COMPANY_ID", "1");
        report.setReportParameter("P_BRANCH_ID", "2");


        report.setReportParameter("P_FROM_DATE", dateFromStr);
        report.setReportParameter("P_TO_DATE", dateToStr);
        report.setReportParameter("P_EMPLOYEE_TYPE_ID", empType);
        report.setReportParameter("P_DEPARTMENT_ID", departmentID);
        report.setReportParameter("P_DESIGNATION_ID", desgID);
        report.setReportParameter("P_PAYMENT_MODE", paymentMode);
        report.setReportParameter("P_ALLOW_DEDUCT_ID", allowDeductID);
        //report.setReportParameter("P_EMPLOYEE_STATUS",
        //                        getSoc6().getValue() == null ? "" : getSoc4().getValue().toString());
        report.setReportParameter("P_FROM_EMPLOYEE_ID", employeeID);
        //report.setReportParameter("P_TO_EMPLOYEE_ID",
        //                        getIt2().getValue() == null ? "" : getIt2().getValue().toString());
        String url = report.getReportServerURL();
        System.out.println(">>" + url);
        report.openUrlInNewWindow(url);


        return null;
    }

    public String editOvertime() {
        getOvertimePopup().show(new RichPopup.PopupHints());
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

    public void setAdvSalaryPopup(RichPopup advSalaryPopup) {
        this.advSalaryPopup = advSalaryPopup;
    }

    public RichPopup getAdvSalaryPopup() {
        return advSalaryPopup;
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

    public String showAdvSalaryPopup() {
        ADFUtil.callOperation("CreateInsert6", null);
        getAdvSalaryPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String editAdvSalary() {
        getAdvSalaryPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String editMonthlyAdjustment() {
        getMonthlyAdjustPopup().show(new RichPopup.PopupHints());
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

    public String cancelAdjustment() {
        ADFUtil.callOperation("Rollback", null);
        getMonthlyAdjustPopup().hide();
        return null;
    }

    public void setLeavesPopup(RichPopup leavesPopup) {
        this.leavesPopup = leavesPopup;
    }

    public RichPopup getLeavesPopup() {
        return leavesPopup;
    }

    public String saveLeaveAndExit() {
        getLoanPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("PrlAdvanceSalaryView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getLeavesTable());
        return null;
    }

    public void setLeavesTable(RichTable leavesTable) {
        this.leavesTable = leavesTable;
    }

    public RichTable getLeavesTable() {
        return leavesTable;
    }

    public String cancelLeavesPopup() {
        ADFUtil.callOperation("Rollback", null);
        getLeavesPopup().hide();
        return null;
    }

    public String showLeavesPopup() {
        ADFUtil.callOperation("CreateInsert4", null);
        getLeavesPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String editLeaves() {
        getLeavesPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String showLoanPopup() {
        ADFUtil.callOperation("CreateInsert5", null);
        getLoanPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setBankPopup(RichPopup bankPopup) {
        this.bankPopup = bankPopup;
    }

    public RichPopup getBankPopup() {
        return bankPopup;
    }

    public String saveBankAndExit() {
        getBankPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("PrlBanksView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getBankTable());

        return null;
    }

    public void setBankTable(RichTable bankTable) {
        this.bankTable = bankTable;
    }

    public RichTable getBankTable() {
        return bankTable;
    }

    public String cancelBankForm() {
        ADFUtil.callOperation("Rollback", null);
        getBankPopup().hide();
        return null;
    }

    public String showBankPopup() {

        ADFUtil.callOperation("CreateInsert11", null);
        getBankPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String editBank() {
        getBankPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setReportBind(RichSelectOneChoice reportBind) {
        this.reportBind = reportBind;
    }

    public RichSelectOneChoice getReportBind() {
        return reportBind;
    }

    public void setDateFrom(RichInputDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public RichInputDate getDateFrom() {
        return dateFrom;
    }

    public void setDateTo(RichInputDate dateTo) {
        this.dateTo = dateTo;
    }

    public RichInputDate getDateTo() {
        return dateTo;
    }

    public void setEmployeeType(RichSelectOneChoice employeeType) {
        this.employeeType = employeeType;
    }

    public RichSelectOneChoice getEmployeeType() {
        return employeeType;
    }

    public void setDepartmentType(RichSelectOneChoice departmentType) {
        this.departmentType = departmentType;
    }

    public RichSelectOneChoice getDepartmentType() {
        return departmentType;
    }

    public void setDesignation(RichSelectOneChoice designation) {
        this.designation = designation;
    }

    public RichSelectOneChoice getDesignation() {
        return designation;
    }

    public void setPaymentMode(RichSelectOneChoice paymentMode) {
        this.paymentMode = paymentMode;
    }

    public RichSelectOneChoice getPaymentMode() {
        return paymentMode;
    }

    public void setAllowenceDeduction(RichSelectOneChoice allowenceDeduction) {
        this.allowenceDeduction = allowenceDeduction;
    }

    public RichSelectOneChoice getAllowenceDeduction() {
        return allowenceDeduction;
    }

    public void setGrossPayFrom(RichInputText grossPayFrom) {
        this.grossPayFrom = grossPayFrom;
    }

    public RichInputText getGrossPayFrom() {
        return grossPayFrom;
    }

    public void setEmployee(RichInputListOfValues employee) {
        this.employee = employee;
    }

    public RichInputListOfValues getEmployee() {
        return employee;
    }

    public String generateSalaryPeriod() {
        ADFUtil.callOperation("generateSalPeriod", null);
        ADFUtil.getViewObject("PrlSalaryPeriodLinesView1Iterator").executeQuery();
        
        return null;
    }

    public String runPayrollYesOption() {
        getPayrollConfirmationDialog().hide();
        Map m = new HashMap();


        if (ADFUtil.evaluateEL("#{bindings.EmployeeType.inputValue}").equals("")) {
            m.put("pEmpType", 0);
        

        } else {
            int empType = Integer.parseInt(ADFUtil.evaluateEL("#{bindings.EmployeeType.inputValue}").toString());
            m.put("pEmpType", empType);
        }

        if (ADFUtil.evaluateEL("#{bindings.Department.inputValue}").equals("")) {
            m.put("pDepartmentID", 0);

        } else {
            m.put("pDepartmentID",
                  Integer.parseInt(ADFUtil.evaluateEL("#{bindings.Department.inputValue}").toString()));
        }

        if (ADFUtil.evaluateEL("#{bindings.Designation.inputValue}").equals("")) {
            m.put("pJobID", 0);

        } else {
            m.put("pJobID", Integer.parseInt(ADFUtil.evaluateEL("#{bindings.Designation.inputValue}").toString()));
        }

        if (ADFUtil.evaluateEL("#{bindings.Employee.inputValue}") != null) {

            m.put("pEmpID", Integer.parseInt(ADFUtil.evaluateEL("#{bindings.Employee.inputValue}").toString()));
        } else {
            m.put("pEmpID", 0);
        }


        m.put("pFrom", null);
        m.put("activeMonthID", 1);


        m.put("pOrgID", 1);
        m.put("branch", 1);
        Object result = ADFUtil.callOperation("generateSalary", m);
        
        ADFUtil.showMessage("Payroll run complete!");
        return null;
    }

    public void setPayrollConfirmationDialog(RichPopup payrollConfirmationDialog) {
        this.payrollConfirmationDialog = payrollConfirmationDialog;
    }

    public RichPopup getPayrollConfirmationDialog() {
        return payrollConfirmationDialog;
    }

    public String runPayrollNoOption() {
        getPayrollConfirmationDialog().hide();
        return null;
    }
}
