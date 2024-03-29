package com.soltechsystem.model.hr.LeaveManagement.Entity;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Apr 18 11:52:27 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeeLeavesImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        LeaveId,
        LeaveType,
        LeaveStatus,
        LeaveFrom,
        LeaveTo,
        EmployeeId,
        CreatedBy,
        CreationDate,
        UpdatedBy,
        UpdationDate,
        VersionNumber;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int LEAVEID = AttributesEnum.LeaveId.index();
    public static final int LEAVETYPE = AttributesEnum.LeaveType.index();
    public static final int LEAVESTATUS = AttributesEnum.LeaveStatus.index();
    public static final int LEAVEFROM = AttributesEnum.LeaveFrom.index();
    public static final int LEAVETO = AttributesEnum.LeaveTo.index();
    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmployeeLeavesImpl() {
    }

    /**
     * Gets the attribute value for LeaveId, using the alias name LeaveId.
     * @return the value of LeaveId
     */
    public BigDecimal getLeaveId() {
        return (BigDecimal) getAttributeInternal(LEAVEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LeaveId.
     * @param value value to set the LeaveId
     */
    public void setLeaveId(BigDecimal value) {
        setAttributeInternal(LEAVEID, value);
    }

    /**
     * Gets the attribute value for LeaveType, using the alias name LeaveType.
     * @return the value of LeaveType
     */
    public BigDecimal getLeaveType() {
        return (BigDecimal) getAttributeInternal(LEAVETYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LeaveType.
     * @param value value to set the LeaveType
     */
    public void setLeaveType(BigDecimal value) {
        setAttributeInternal(LEAVETYPE, value);
    }

    /**
     * Gets the attribute value for LeaveStatus, using the alias name LeaveStatus.
     * @return the value of LeaveStatus
     */
    public String getLeaveStatus() {
        return (String) getAttributeInternal(LEAVESTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for LeaveStatus.
     * @param value value to set the LeaveStatus
     */
    public void setLeaveStatus(String value) {
        setAttributeInternal(LEAVESTATUS, value);
    }

    /**
     * Gets the attribute value for LeaveFrom, using the alias name LeaveFrom.
     * @return the value of LeaveFrom
     */
    public Timestamp getLeaveFrom() {
        return (Timestamp) getAttributeInternal(LEAVEFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for LeaveFrom.
     * @param value value to set the LeaveFrom
     */
    public void setLeaveFrom(Timestamp value) {
        setAttributeInternal(LEAVEFROM, value);
    }

    /**
     * Gets the attribute value for LeaveTo, using the alias name LeaveTo.
     * @return the value of LeaveTo
     */
    public Timestamp getLeaveTo() {
        return (Timestamp) getAttributeInternal(LEAVETO);
    }

    /**
     * Sets <code>value</code> as the attribute value for LeaveTo.
     * @param value value to set the LeaveTo
     */
    public void setLeaveTo(Timestamp value) {
        setAttributeInternal(LEAVETO, value);
    }

    /**
     * Gets the attribute value for EmployeeId, using the alias name EmployeeId.
     * @return the value of EmployeeId
     */
    public BigDecimal getEmployeeId() {
        return (BigDecimal) getAttributeInternal(EMPLOYEEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for EmployeeId.
     * @param value value to set the EmployeeId
     */
    public void setEmployeeId(BigDecimal value) {
        setAttributeInternal(EMPLOYEEID, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public BigDecimal getCreatedBy() {
        return (BigDecimal) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(BigDecimal value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the value of CreationDate
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
    }

    /**
     * Gets the attribute value for UpdatedBy, using the alias name UpdatedBy.
     * @return the value of UpdatedBy
     */
    public BigDecimal getUpdatedBy() {
        return (BigDecimal) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for UpdatedBy.
     * @param value value to set the UpdatedBy
     */
    public void setUpdatedBy(BigDecimal value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for UpdationDate, using the alias name UpdationDate.
     * @return the value of UpdationDate
     */
    public Timestamp getUpdationDate() {
        return (Timestamp) getAttributeInternal(UPDATIONDATE);
    }

    /**
     * Gets the attribute value for VersionNumber, using the alias name VersionNumber.
     * @return the value of VersionNumber
     */
    public BigDecimal getVersionNumber() {
        return (BigDecimal) getAttributeInternal(VERSIONNUMBER);
    }

    /**
     * @param leaveId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal leaveId) {
        return new Key(new Object[] { leaveId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.soltechsystem.model.hr.LeaveManagement.Entity.EmployeeLeaves");
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        String userid = (ADFContext.getCurrent()
                                   .getSessionScope()
                                   .get("userid") == null) ? "-1" : ADFContext.getCurrent()
                                                                              .getSessionScope()
                                                                              .get("userid")
                                                                              .toString();


        switch (operation) {

        case DML_INSERT:


            setUpdatedBy(new BigDecimal(userid));
            setCreatedBy(new BigDecimal(userid));
            setLeaveStatus("USER_INITIATED");
            
            
            
            break;
        case DML_UPDATE:
            setUpdatedBy(new BigDecimal(userid));

        }
        super.doDML(operation, e);
    }
    
}

