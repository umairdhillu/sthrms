package com.soltechsystem.model.hr.am;

import com.soltechsystem.model.hr.LOV.EmployeeGradeListImpl;

import com.soltechsystem.model.hr.am.common.HRAM;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Nov 22 10:21:24 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRAMImpl extends ApplicationModuleImpl implements HRAM {
    /**
     * This is the default constructor (do not remove).
     */
    public HRAMImpl() {
    }

    public void leaveAction(int employeeID, int leaveID, String action, String leaveType, int total) {
        CallableStatement cst = null;
        try {
            cst = getDBTransaction().createCallableStatement("{call sthrms.leaveAction(?,?,?,?,?)}", 0);
            cst.setInt(1, employeeID);
            cst.setInt(2, leaveID);
            cst.setString(3, action);
            cst.setString(4, leaveType);
            cst.setInt(5, total);

            cst.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    
    public int getEmployeeID(int userid){
        PreparedStatement cst = null;
        ResultSet rs = null;
        String query = "select employee_id from sys_users where user_id = ?";
        int empid = -1;
        try{
            cst = getDBTransaction().createPreparedStatement(query, 0);
            cst.setInt(1, userid);
            rs = cst.executeQuery();
            if (rs.next()){
                empid = rs.getInt("employee_id");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            empid = -1;
        }
        System.out.println("employeeid: "+empid);
        return empid;
    }

    public String login(String username, String password) {
        System.out.println(username + " - " + password);
        CallableStatement cst = null;
        try {
            cst = getDBTransaction().createCallableStatement("{call ? := sthrms.sthrms_utils.user_login(?,?)}", 0);
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.setString(2, username);
            cst.setString(3, password);
            cst.executeUpdate();
            System.out.println(cst.getString(1));
            return cst.getString(1);
    
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }


    /**
     * Container's getter for HrJobsView1.
     * @return HrJobsView1
     */
    public ViewObjectImpl getHrJobsView1() {
        return (ViewObjectImpl) findViewObject("HrJobsView1");
    }

    /**
     * Container's getter for HrDepartmentsView1.
     * @return HrDepartmentsView1
     */
    public ViewObjectImpl getHrDepartmentsView1() {
        return (ViewObjectImpl) findViewObject("HrDepartmentsView1");
    }


    /**
     * Container's getter for EmployeeRoll1.
     * @return EmployeeRoll1
     */
    public ViewObjectImpl getEmployeeRoll1() {
        return (ViewObjectImpl) findViewObject("EmployeeRoll1");
    }

    /**
     * Container's getter for EmployeeStatusList1.
     * @return EmployeeStatusList1
     */
    public ViewObjectImpl getEmployeeStatusList1() {
        return (ViewObjectImpl) findViewObject("EmployeeStatusList1");
    }

    /**
     * Container's getter for EmployeeTypeList1.
     * @return EmployeeTypeList1
     */
    public ViewObjectImpl getEmployeeTypeList1() {
        return (ViewObjectImpl) findViewObject("EmployeeTypeList1");
    }

    /**
     * Container's getter for EmployeeList1.
     * @return EmployeeList1
     */
    public ViewObjectImpl getEmployeeList1() {
        return (ViewObjectImpl) findViewObject("EmployeeList1");
    }

    /**
     * Container's getter for EmployeeGradeList1.
     * @return EmployeeGradeList1
     */
    public EmployeeGradeListImpl getEmployeeGradeList1() {
        return (EmployeeGradeListImpl) findViewObject("EmployeeGradeList1");
    }


    /**
     * Container's getter for ContactTypeList1.
     * @return ContactTypeList1
     */
    public ViewObjectImpl getContactTypeList1() {
        return (ViewObjectImpl) findViewObject("ContactTypeList1");
    }

    /**
     * Container's getter for LocationTypeList1.
     * @return LocationTypeList1
     */
    public ViewObjectImpl getLocationTypeList1() {
        return (ViewObjectImpl) findViewObject("LocationTypeList1");
    }

    /**
     * Container's getter for RegionList1.
     * @return RegionList1
     */
    public ViewObjectImpl getRegionList1() {
        return (ViewObjectImpl) findViewObject("RegionList1");
    }

    /**
     * Container's getter for LocationList1.
     * @return LocationList1
     */
    public ViewObjectImpl getLocationList1() {
        return (ViewObjectImpl) findViewObject("LocationList1");
    }

    /**
     * Container's getter for DepartmentTypeList1.
     * @return DepartmentTypeList1
     */
    public ViewObjectImpl getDepartmentTypeList1() {
        return (ViewObjectImpl) findViewObject("DepartmentTypeList1");
    }

    /**
     * Container's getter for SalutationList1.
     * @return SalutationList1
     */
    public ViewObjectImpl getSalutationList1() {
        return (ViewObjectImpl) findViewObject("SalutationList1");
    }

    /**
     * Container's getter for GenderList1.
     * @return GenderList1
     */
    public ViewObjectImpl getGenderList1() {
        return (ViewObjectImpl) findViewObject("GenderList1");
    }

    /**
     * Container's getter for MaritalStatusList1.
     * @return MaritalStatusList1
     */
    public ViewObjectImpl getMaritalStatusList1() {
        return (ViewObjectImpl) findViewObject("MaritalStatusList1");
    }

    /**
     * Container's getter for NationalityList1.
     * @return NationalityList1
     */
    public ViewObjectImpl getNationalityList1() {
        return (ViewObjectImpl) findViewObject("NationalityList1");
    }


    /**
     * Container's getter for AddressTypeList1.
     * @return AddressTypeList1
     */
    public ViewObjectImpl getAddressTypeList1() {
        return (ViewObjectImpl) findViewObject("AddressTypeList1");
    }

    /**
     * Container's getter for CountryList1.
     * @return CountryList1
     */
    public ViewObjectImpl getCountryList1() {
        return (ViewObjectImpl) findViewObject("CountryList1");
    }

    /**
     * Container's getter for StateList1.
     * @return StateList1
     */
    public ViewObjectImpl getStateList1() {
        return (ViewObjectImpl) findViewObject("StateList1");
    }

    /**
     * Container's getter for CityList1.
     * @return CityList1
     */
    public ViewObjectImpl getCityList1() {
        return (ViewObjectImpl) findViewObject("CityList1");
    }

    /**
     * Container's getter for District1.
     * @return District1
     */
    public ViewObjectImpl getDistrict1() {
        return (ViewObjectImpl) findViewObject("District1");
    }

    /**
     * Container's getter for Tehsil1.
     * @return Tehsil1
     */
    public ViewObjectImpl getTehsil1() {
        return (ViewObjectImpl) findViewObject("Tehsil1");
    }

    /**
     * Container's getter for DivisionList1.
     * @return DivisionList1
     */
    public ViewObjectImpl getDivisionList1() {
        return (ViewObjectImpl) findViewObject("DivisionList1");
    }


    /**
     * Container's getter for ExperienceTypeList1.
     * @return ExperienceTypeList1
     */
    public ViewObjectImpl getExperienceTypeList1() {
        return (ViewObjectImpl) findViewObject("ExperienceTypeList1");
    }


    /**
     * Container's getter for DegreeTypeList1.
     * @return DegreeTypeList1
     */
    public ViewObjectImpl getDegreeTypeList1() {
        return (ViewObjectImpl) findViewObject("DegreeTypeList1");
    }


    /**
     * Container's getter for RelationTypeList1.
     * @return RelationTypeList1
     */
    public ViewObjectImpl getRelationTypeList1() {
        return (ViewObjectImpl) findViewObject("RelationTypeList1");
    }


    /**
     * Container's getter for SysFilesView1.
     * @return SysFilesView1
     */
    public ViewObjectImpl getSysFilesView1() {
        return (ViewObjectImpl) findViewObject("SysFilesView1");
    }


    /**
     * Container's getter for HrEmpOvertimeView1.
     * @return HrEmpOvertimeView1
     */
    public ViewObjectImpl getHrEmpOvertimeView1() {
        return (ViewObjectImpl) findViewObject("HrEmpOvertimeView1");
    }

    /**
     * Container's getter for HrEmployeesView1.
     * @return HrEmployeesView1
     */
    public ViewObjectImpl getHrEmployeesView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeesView1");
    }

    /**
     * Container's getter for HrEmployeeAddressView1.
     * @return HrEmployeeAddressView1
     */
    public ViewObjectImpl getHrEmployeeAddressView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeAddressView1");
    }

    /**
     * Container's getter for EmployeeAddressLink1.
     * @return EmployeeAddressLink1
     */
    public ViewLinkImpl getEmployeeAddressLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeAddressLink1");
    }

    /**
     * Container's getter for HrEmployeeContactView1.
     * @return HrEmployeeContactView1
     */
    public ViewObjectImpl getHrEmployeeContactView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeContactView1");
    }

    /**
     * Container's getter for EmployeeContactLink1.
     * @return EmployeeContactLink1
     */
    public ViewLinkImpl getEmployeeContactLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeContactLink1");
    }


    /**
     * Container's getter for HrEmployeeExperienceView1.
     * @return HrEmployeeExperienceView1
     */
    public ViewObjectImpl getHrEmployeeExperienceView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeExperienceView1");
    }

    /**
     * Container's getter for EmployeeExperienceLink1.
     * @return EmployeeExperienceLink1
     */
    public ViewLinkImpl getEmployeeExperienceLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeExperienceLink1");
    }

    /**
     * Container's getter for HrEmployeeFamilyMemberView1.
     * @return HrEmployeeFamilyMemberView1
     */
    public ViewObjectImpl getHrEmployeeFamilyMemberView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeFamilyMemberView1");
    }

    /**
     * Container's getter for EmployeeFamilyLink1.
     * @return EmployeeFamilyLink1
     */
    public ViewLinkImpl getEmployeeFamilyLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeFamilyLink1");
    }

    /**
     * Container's getter for HrEmployeeKinView1.
     * @return HrEmployeeKinView1
     */
    public ViewObjectImpl getHrEmployeeKinView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeKinView1");
    }

    /**
     * Container's getter for EmployeeKinLink1.
     * @return EmployeeKinLink1
     */
    public ViewLinkImpl getEmployeeKinLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeKinLink1");
    }

    /**
     * Container's getter for HrEmployeeQualificationView1.
     * @return HrEmployeeQualificationView1
     */
    public ViewObjectImpl getHrEmployeeQualificationView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeQualificationView1");
    }

    /**
     * Container's getter for EmployeeQualificationLink1.
     * @return EmployeeQualificationLink1
     */
    public ViewLinkImpl getEmployeeQualificationLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeQualificationLink1");
    }

    /**
     * Container's getter for HrEmployeeReferenceView1.
     * @return HrEmployeeReferenceView1
     */
    public ViewObjectImpl getHrEmployeeReferenceView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeReferenceView1");
    }

    /**
     * Container's getter for EmployeeReferenceLink1.
     * @return EmployeeReferenceLink1
     */
    public ViewLinkImpl getEmployeeReferenceLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeReferenceLink1");
    }

    /**
     * Container's getter for PrlGradeHeaderView1.
     * @return PrlGradeHeaderView1
     */
    public ViewObjectImpl getPrlGradeHeaderView1() {
        return (ViewObjectImpl) findViewObject("PrlGradeHeaderView1");
    }

    /**
     * Container's getter for PrlGradeLinesView1.
     * @return PrlGradeLinesView1
     */
    public ViewObjectImpl getPrlGradeLinesView1() {
        return (ViewObjectImpl) findViewObject("PrlGradeLinesView1");
    }

    /**
     * Container's getter for GradeAllowDeductLink1.
     * @return GradeAllowDeductLink1
     */
    public ViewLinkImpl getGradeAllowDeductLink1() {
        return (ViewLinkImpl) findViewLink("GradeAllowDeductLink1");
    }

    /**
     * Container's getter for PrlAllowDeductTrxView1.
     * @return PrlAllowDeductTrxView1
     */
    public ViewObjectImpl getPrlAllowDeductTrxView1() {
        return (ViewObjectImpl) findViewObject("PrlAllowDeductTrxView1");
    }

    /**
     * Container's getter for EmployeeGradeLink1.
     * @return EmployeeGradeLink1
     */
    public ViewLinkImpl getEmployeeGradeLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeGradeLink1");
    }

    /**
     * Container's getter for CnicView1.
     * @return CnicView1
     */
    public ViewObjectImpl getCnicView1() {
        return (ViewObjectImpl) findViewObject("CnicView1");
    }

    /**
     * Container's getter for EmployeeCnicLink1.
     * @return EmployeeCnicLink1
     */
    public ViewLinkImpl getEmployeeCnicLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeCnicLink1");
    }

    /**
     * Container's getter for DrivingLicenseView1.
     * @return DrivingLicenseView1
     */
    public ViewObjectImpl getDrivingLicenseView1() {
        return (ViewObjectImpl) findViewObject("DrivingLicenseView1");
    }

    /**
     * Container's getter for EmployeeDrivingLicenseLink1.
     * @return EmployeeDrivingLicenseLink1
     */
    public ViewLinkImpl getEmployeeDrivingLicenseLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeDrivingLicenseLink1");
    }

    /**
     * Container's getter for HrEmergencyContactView1.
     * @return HrEmergencyContactView1
     */
    public ViewObjectImpl getHrEmergencyContactView1() {
        return (ViewObjectImpl) findViewObject("HrEmergencyContactView1");
    }

    /**
     * Container's getter for EmployeeEmergencyContactLink1.
     * @return EmployeeEmergencyContactLink1
     */
    public ViewLinkImpl getEmployeeEmergencyContactLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeEmergencyContactLink1");
    }

    /**
     * Container's getter for PassportView1.
     * @return PassportView1
     */
    public ViewObjectImpl getPassportView1() {
        return (ViewObjectImpl) findViewObject("PassportView1");
    }

    /**
     * Container's getter for EmployeePassportView1.
     * @return EmployeePassportView1
     */
    public ViewLinkImpl getEmployeePassportView1() {
        return (ViewLinkImpl) findViewLink("EmployeePassportView1");
    }


    /**
     * Container's getter for StartDatesList1.
     * @return StartDatesList1
     */
    public ViewObjectImpl getStartDatesList1() {
        return (ViewObjectImpl) findViewObject("StartDatesList1");
    }

    /**
     * Container's getter for HrEmployeeAssetsView1.
     * @return HrEmployeeAssetsView1
     */
    public ViewObjectImpl getHrEmployeeAssetsView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeeAssetsView1");
    }

    /**
     * Container's getter for EmployeeAssetLink1.
     * @return EmployeeAssetLink1
     */
    public ViewLinkImpl getEmployeeAssetLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeAssetLink1");
    }

    /**
     * Container's getter for AssetTypeList1.
     * @return AssetTypeList1
     */
    public ViewObjectImpl getAssetTypeList1() {
        return (ViewObjectImpl) findViewObject("AssetTypeList1");
    }

    /**
     * Container's getter for AssetUsageTypeList1.
     * @return AssetUsageTypeList1
     */
    public ViewObjectImpl getAssetUsageTypeList1() {
        return (ViewObjectImpl) findViewObject("AssetUsageTypeList1");
    }

    /**
     * Container's getter for PaymentModeList1.
     * @return PaymentModeList1
     */
    public ViewObjectImpl getPaymentModeList1() {
        return (ViewObjectImpl) findViewObject("PaymentModeList1");
    }

    /**
     * Container's getter for BankList1.
     * @return BankList1
     */
    public ViewObjectImpl getBankList1() {
        return (ViewObjectImpl) findViewObject("BankList1");
    }

    /**
     * Container's getter for JobRoleList1.
     * @return JobRoleList1
     */
    public ViewObjectImpl getJobRoleList1() {
        return (ViewObjectImpl) findViewObject("JobRoleList1");
    }

    /**
     * Container's getter for EmpActiveList1.
     * @return EmpActiveList1
     */
    public ViewObjectImpl getEmpActiveList1() {
        return (ViewObjectImpl) findViewObject("EmpActiveList1");
    }

    /**
     * Container's getter for ReligionList1.
     * @return ReligionList1
     */
    public ViewObjectImpl getReligionList1() {
        return (ViewObjectImpl) findViewObject("ReligionList1");
    }

    /**
     * Container's getter for ScoreTypeList1.
     * @return ScoreTypeList1
     */
    public ViewObjectImpl getScoreTypeList1() {
        return (ViewObjectImpl) findViewObject("ScoreTypeList1");
    }

    /**
     * Container's getter for DutyStationList1.
     * @return DutyStationList1
     */
    public ViewObjectImpl getDutyStationList1() {
        return (ViewObjectImpl) findViewObject("DutyStationList1");
    }


    /**
     * Container's getter for EmployeeAttachmentsHeaderAll1.
     * @return EmployeeAttachmentsHeaderAll1
     */
    public ViewObjectImpl getEmployeeAttachmentsHeaderAll1() {
        return (ViewObjectImpl) findViewObject("EmployeeAttachmentsHeaderAll1");
    }

    /**
     * Container's getter for EmployeeAttachmentHeaderLink1.
     * @return EmployeeAttachmentHeaderLink1
     */
    public ViewLinkImpl getEmployeeAttachmentHeaderLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeAttachmentHeaderLink1");
    }

    /**
     * Container's getter for AttachmentLines1.
     * @return AttachmentLines1
     */
    public ViewObjectImpl getAttachmentLines1() {
        return (ViewObjectImpl) findViewObject("AttachmentLines1");
    }

    /**
     * Container's getter for EmployeeAttachmentAllLink1.
     * @return EmployeeAttachmentAllLink1
     */
    public ViewLinkImpl getEmployeeAttachmentAllLink1() {
        return (ViewLinkImpl) findViewLink("EmployeeAttachmentAllLink1");
    }

    /**
     * Container's getter for HrEmployeesHistoryView1.
     * @return HrEmployeesHistoryView1
     */
    public ViewObjectImpl getHrEmployeesHistoryView1() {
        return (ViewObjectImpl) findViewObject("HrEmployeesHistoryView1");
    }

    /**
     * Container's getter for LeavesApprovals1.
     * @return LeavesApprovals1
     */
    public ViewObjectImpl getLeavesApprovals1() {
        return (ViewObjectImpl) findViewObject("LeavesApprovals1");
    }

    /**
     * Container's getter for LeaveNotification1.
     * @return LeaveNotification1
     */
    public ViewObjectImpl getLeaveNotification1() {
        return (ViewObjectImpl) findViewObject("LeaveNotification1");
    }

    /**
     * Container's getter for ComplaintSeverityView1.
     * @return ComplaintSeverityView1
     */
    public ViewObjectImpl getComplaintSeverityView1() {
        return (ViewObjectImpl) findViewObject("ComplaintSeverityView1");
    }

    /**
     * Container's getter for ComplaintTypesView1.
     * @return ComplaintTypesView1
     */
    public ViewObjectImpl getComplaintTypesView1() {
        return (ViewObjectImpl) findViewObject("ComplaintTypesView1");
    }

    /**
     * Container's getter for ComplaintSeverityLink1.
     * @return ComplaintSeverityLink1
     */
    public ViewLinkImpl getComplaintSeverityLink1() {
        return (ViewLinkImpl) findViewLink("ComplaintSeverityLink1");
    }

    /**
     * Container's getter for ComplaintActionView1.
     * @return ComplaintActionView1
     */
    public ViewObjectImpl getComplaintActionView1() {
        return (ViewObjectImpl) findViewObject("ComplaintActionView1");
    }
}
