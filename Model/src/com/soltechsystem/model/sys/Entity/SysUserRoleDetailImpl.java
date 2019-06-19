package com.soltechsystem.model.sys.Entity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 27 12:01:20 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SysUserRoleDetailImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        RoleDetailId,
        RoleId,
        ProfileId,
        ProfileValue,
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


    public static final int ROLEDETAILID = AttributesEnum.RoleDetailId.index();
    public static final int ROLEID = AttributesEnum.RoleId.index();
    public static final int PROFILEID = AttributesEnum.ProfileId.index();
    public static final int PROFILEVALUE = AttributesEnum.ProfileValue.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SysUserRoleDetailImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.soltechsystem.model.sys.Entity.SysUserRoleDetail");
    }


    /**
     * Gets the attribute value for RoleDetailId, using the alias name RoleDetailId.
     * @return the value of RoleDetailId
     */
    public BigDecimal getRoleDetailId() {
        return (BigDecimal) getAttributeInternal(ROLEDETAILID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RoleDetailId.
     * @param value value to set the RoleDetailId
     */
    public void setRoleDetailId(BigDecimal value) {
        setAttributeInternal(ROLEDETAILID, value);
    }

    /**
     * Gets the attribute value for RoleId, using the alias name RoleId.
     * @return the value of RoleId
     */
    public BigDecimal getRoleId() {
        return (BigDecimal) getAttributeInternal(ROLEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for RoleId.
     * @param value value to set the RoleId
     */
    public void setRoleId(BigDecimal value) {
        setAttributeInternal(ROLEID, value);
    }

    /**
     * Gets the attribute value for ProfileId, using the alias name ProfileId.
     * @return the value of ProfileId
     */
    public BigDecimal getProfileId() {
        return (BigDecimal) getAttributeInternal(PROFILEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProfileId.
     * @param value value to set the ProfileId
     */
    public void setProfileId(BigDecimal value) {
        setAttributeInternal(PROFILEID, value);
    }

    /**
     * Gets the attribute value for ProfileValue, using the alias name ProfileValue.
     * @return the value of ProfileValue
     */
    public String getProfileValue() {
        return (String) getAttributeInternal(PROFILEVALUE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProfileValue.
     * @param value value to set the ProfileValue
     */
    public void setProfileValue(String value) {
        setAttributeInternal(PROFILEVALUE, value);
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
     * @param roleDetailId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal roleDetailId) {
        return new Key(new Object[] { roleDetailId });
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

            break;
        case DML_UPDATE:
            setUpdatedBy(new BigDecimal(userid));
        }


        super.doDML(operation, e);
    }
}
