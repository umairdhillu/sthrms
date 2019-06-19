package com.soltechsystem.view.hr_backing;

import com.soltechsystem.view.general.ADFUtil;
import com.soltechsystem.view.general.OracleReport;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

import oracle.jbo.domain.Timestamp;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.UploadedFile;

public class EmployeeBacking {
    private RichPopup editEmployeePopup;
    private RichPopup newAddressPopup;
    private RichTable addressTable;
    private RichPopup drivingLicensePopup;
    private RichPopup cnicPopup;
    private RichPopup passportPopup;
    private RichPopup assetAddPopup;
    private RichTable assetTable;
    private RichPopup departmentPopup;
    private RichTable departmentTable;
    private RichPopup jobPopup;
    private RichTable jobTable;
    private RichPopup allowDeductPopup;
    private RichTable allowDeductionTable;
    private RichSelectOneChoice whichStartDate;


    public EmployeeBacking() {
        super();
    }

    public void employeeTableDoubleClickHandler(ClientEvent clientEvent) {
        RichPopup rp = getEditEmployeePopup();
        RichPopup.PopupHints ph = new RichPopup.PopupHints();
        rp.show(ph);
    }

    public void setEditEmployeePopup(RichPopup editEmployeePopup) {
        this.editEmployeePopup = editEmployeePopup;
    }

    public RichPopup getEditEmployeePopup() {
        return editEmployeePopup;
    }

    public String showAddressPopup() {
        ADFUtil.callOperation("CreateInsert1", null);
        getNewAddressPopup().show(new RichPopup.PopupHints());
        //        FacesContext context = FacesContext.getCurrentInstance();
        //        ExtendedRenderKitService erks = Service.getRenderKitService(context, ExtendedRenderKitService.class);
        ////        erks.addScript(context, "AdfPage.PAGE.findComponent('p2').show();");
        //        erks.addScript(context, "alert('hello');");
        //        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        return null;
    }

    public void setNewAddressPopup(RichPopup newAddressPopup) {
        this.newAddressPopup = newAddressPopup;
    }

    public RichPopup getNewAddressPopup() {
        return newAddressPopup;
    }

    public String hideAddressPopup() {
        getNewAddressPopup().hide();
        ADFUtil.callOperation("Commit", null);
        ADFUtil.getViewObject("HrEmployeeAddressView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getAddressTable());

        return null;
    }

    public void setAddressTable(RichTable addressTable) {
        this.addressTable = addressTable;
    }

    public RichTable getAddressTable() {
        return addressTable;
    }


    public String showDrivingLicense() {
        ADFUtil.getViewObject("DrivingLicenseView1Iterator").executeQuery();
        
        getDrivingLicensePopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setDrivingLicensePopup(RichPopup drivingLicensePopup) {
        this.drivingLicensePopup = drivingLicensePopup;
    }

    public RichPopup getDrivingLicensePopup() {
        return drivingLicensePopup;
    }

    public String showCnicPopup() {
        ADFUtil.getViewObject("CnicView1Iterator").executeQuery();
        getCnicPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setCnicPopup(RichPopup cnicPopup) {
        this.cnicPopup = cnicPopup;
    }

    public RichPopup getCnicPopup() {
        return cnicPopup;
    }

    public void setPassportPopup(RichPopup passportPopup) {
        this.passportPopup = passportPopup;
    }

    public RichPopup getPassportPopup() {
        return passportPopup;
    }

    public String showPassportPopup() {
        ADFUtil.getViewObject("PassportView1Iterator").executeQuery();
        getPassportPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void gradeChanged(ValueChangeEvent valueChangeEvent) {
        if (valueChangeEvent.getNewValue() != null) {
            int gradeID = Integer.parseInt(valueChangeEvent.getNewValue().toString());
            Row r = (Row) ADFUtil.evaluateEL("#{bindings.HrEmployeesView1Iterator.currentRow}");
            //int gradeID = Integer.parseInt(r.getAttribute("GradeId").toString());
            int employeeID = Integer.parseInt(r.getAttribute("EmployeeId").toString());
            Map params = new HashMap();

            params.put("employeeID", employeeID);
            params.put("gradeID", valueChangeEvent.getNewValue().toString());

            ADFUtil.callOperation("assignGrade", params);
            ADFUtil.getViewObject("PrlAllowDeductTrxView1Iterator").executeQuery();
        }
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String assignGradeAction() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("assignGrade");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }

    public String showAssetPopup() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert9");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        getAssetAddPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setAssetAddPopup(RichPopup assetAddPopup) {
        this.assetAddPopup = assetAddPopup;
    }

    public RichPopup getAssetAddPopup() {
        return assetAddPopup;
    }

    public void hideAndSaveAsset(ActionEvent actionEvent) {
        getAssetAddPopup().hide();
        ADFUtil.callOperation("Commit", null);
        ADFUtil.getViewObject("HrEmployeeAssetsView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getAssetTable());
    }

    public void setAssetTable(RichTable assetTable) {
        this.assetTable = assetTable;
    }

    public RichTable getAssetTable() {
        return assetTable;
    }

    public String cancelAndContinueAsset() {
        ADFUtil.callOperation("Rollback", null);
        getAssetAddPopup().hide();
        return null;
    }

    public String runEmpCardRpt() {
   
            OracleReport report = new OracleReport("103.62.233.166", "8889", null);
            report.setReportServerParam(OracleReport.RS_PARAM_DESTYPE,
                                        "cache"); // which will be one of the [cashe - file - mail - printer]
            report.setReportServerParam(OracleReport.RS_PARAM_DESFORMAT,
                                        "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            report.setReportServerParam(OracleReport.RS_PARAM_REPORT, "C:\\\\Reports\\\\Card_us.rep");
            report.setReportServerParam("USERID", "sthrms/sthrms786@xe");
            report.setReportParameter("P_COMPANY_ID", "1");
            report.setReportParameter("P_BRANCH_ID", "2");
            String empCode = ADFUtil.evaluateEL("#{bindings.EmployeeCode.inputValue}").toString();
            report.setReportParameter("P_FROM_EMPLOYEE_ID", empCode);
            
            String url = report.getReportServerURL();
            System.out.println(">>"+url);
            report.openUrlInNewWindow(url);
            
            //report.setReportParameter("P_FROM_DATE", null);
            //report.setReportParameter("P_TO_DATE", toDate);
            //report.setReportParameter("P_EMPLOYEE_TYPE_ID",
              //                        getSoc1().getValue() == null ? "" : getSoc1().getValue().toString());
            //report.setReportParameter("P_DEPARTMENT_ID",
              //                        getSoc2().getValue() == null ? "" : getSoc2().getValue().toString());
            //report.setReportParameter("P_DESIGNATION_ID",
              //                        getSoc3().getValue() == null ? "" : getSoc3().getValue().toString());
            //report.setReportParameter("P_PAYMENT_MODE",
              //                        getSoc4().getValue() == null ? "" : getSoc4().getValue().toString());
            //report.setReportParameter("P_ALLOW_DEDUCT_ID",
              //                        getSoc5().getValue() == null ? "" : getSoc4().getValue().toString());
            //report.setReportParameter("P_EMPLOYEE_STATUS",
              //                        getSoc6().getValue() == null ? "" : getSoc4().getValue().toString());
            //report.setReportParameter("P_FROM_EMPLOYEE_ID",
              //                        getIt1().getValue() == null ? "" : getIt1().getValue().toString());
            //report.setReportParameter("P_TO_EMPLOYEE_ID",
              //                        getIt2().getValue() == null ? "" : getIt2().getValue().toString());

        return null;
    }

    public void setDepartmentPopup(RichPopup departmentPopup) {
        this.departmentPopup = departmentPopup;
    }

    public RichPopup getDepartmentPopup() {
        return departmentPopup;
    }

    public String saveAndHideDepartmentPopup() {
        getDepartmentPopup().hide();
        ADFUtil.callOperation("Commit", null);
        ADFUtil.getViewObject("HrDepartmentsView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getDepartmentTable());
        return null;
    }

    public String exitDepartmentPopup() {
        ADFUtil.callOperation("Rollback", null);
        getDepartmentPopup().hide();
        return null;
    }

    public void setDepartmentTable(RichTable departmentTable) {
        this.departmentTable = departmentTable;
    }

    public RichTable getDepartmentTable() {
        return departmentTable;
    }

    public String newDepartments() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        getDepartmentPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String editDepartment() {
        getDepartmentPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveJob() {
        // Add event code here...HrJobsView1Iterator
        getJobPopup().hide();
        ADFUtil.callOperation("Commit", null);
        ADFUtil.getViewObject("HrJobsView1Iterator").executeQuery(); 
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getJobTable());
        return null;
    }

    public String exitJobPopup() {
        ADFUtil.callOperation("Rollback", null);
        getJobPopup().hide();
        return null;
    }

    public void setJobPopup(RichPopup jobPopup) {
        this.jobPopup = jobPopup;
    }

    public RichPopup getJobPopup() {
        return jobPopup;
    }

    public void setJobTable(RichTable jobTable) {
        this.jobTable = jobTable;
    }

    public RichTable getJobTable() {
        return jobTable;
    }

    public String editJob() {
        getJobPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String newJob() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert1");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        getJobPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String newAllowenceDeduction() {
        
        
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert8");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        
        getAllowDeductPopup().show(new RichPopup.PopupHints());
       
        return null;
    }

    public void setAllowDeductPopup(RichPopup allowDeductPopup) {
        this.allowDeductPopup = allowDeductPopup;
    }

    public RichPopup getAllowDeductPopup() {
        return allowDeductPopup;
    }

    public void setAllowDeductionTable(RichTable allowDeductionTable) {
        this.allowDeductionTable = allowDeductionTable;
    }

    public RichTable getAllowDeductionTable() {
        return allowDeductionTable;
    }

    public String saveAllowDeduction() {
        getAllowDeductPopup().hide();
        ADFUtil.callOperation("Commit", null);
        ADFUtil.getViewObject("PrlAllowDeductTrxView1Iterator").executeQuery(); 
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getAllowDeductionTable());
        return null;
    }

    public String cancelAllowDeduction() {
        ADFUtil.callOperation("Rollback", null);
        getAllowDeductPopup().hide();
        return null;
    }

    public void allowDeductTableSelectionListener(SelectionEvent selectionEvent) {
        String el = "#{bindings.PrlAllowDeductTrxView1.collectionModel.makeCurrent}";
        ADFUtil.invokeEL(el, new Class[] { EmployeeBacking.class }, new Object[] { selectionEvent });
        
        Row r = (Row)ADFUtil.evaluateEL("#{bindings.PrlAllowDeductTrxView1Iterator.currentRow}");
        System.out.println(r.getAttribute("TrxId")+" >>>>>>>>>>>>>>>>>>>>>>>");
    }

    

    public String b23_action() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("CreateInsert8");
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        
        getAllowDeductPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String viewAddress() {
        getNewAddressPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String exitAddressPopup() {
        ADFUtil.callOperation("Rollback", null);
        getNewAddressPopup().hide();
        return null;
    }


    public void startDateTypeChanged(ValueChangeEvent valueChangeEvent) {
        System.out.println(ADFUtil.callOperation("getDate", null)+" <><<<<");
        
    }


    public String viewAsset() {
        getAssetAddPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void documentChanged(ValueChangeEvent valueChangeEvent) {
      UploadedFile file = (UploadedFile)   valueChangeEvent.getNewValue();
      Row r = (Row)ADFUtil.evaluateEL("#{bindings.HrEmployeeQualificationView1Iterator.currentRow}");
      String ext = file.getFilename().split("\\.")[1];
      r.setAttribute("Attrib1", ext);
      r.setAttribute("Attrib3", file.getContentType());
      r.setAttribute("Attrib2", "Y");
      
      System.out.println("C:\\work\\startup\\employee_images\\qualification\\"+ADFUtil.evaluateEL("#{bindings.EmployeeId.inputValue}")+"-"+r.getAttribute("QualificationId")+"."+ext);
      copyFile(file,"C:\\work\\startup\\employee_images\\qualification\\"+ADFUtil.evaluateEL("#{bindings.EmployeeId.inputValue}")+"-"+r.getAttribute("QualificationId")+"."+ext);
    }
    
    private void copyFile(UploadedFile file, String path) {
        InputStream is = null;

        FileOutputStream fos = null;
        try {
            is = file.getInputStream();


            fos = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, numBytesRead);
            }
            is.close();
            fos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

  
}
