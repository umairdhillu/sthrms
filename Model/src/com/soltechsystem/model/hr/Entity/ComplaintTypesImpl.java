package com.soltechsystem.model.hr.Entity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed May 15 19:55:13 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ComplaintTypesImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        ComplaintTypeId,
        ComplaintType,
        SeverityId,
        CreatedBy,
        UpdatedBy,
        CreationDate,
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

    public static final int COMPLAINTTYPEID = AttributesEnum.ComplaintTypeId.index();
    public static final int COMPLAINTTYPE = AttributesEnum.ComplaintType.index();
    public static final int SEVERITYID = AttributesEnum.SeverityId.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ComplaintTypesImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.soltechsystem.model.hr.Entity.ComplaintTypes");
    }

    /**
     * Gets the attribute value for ComplaintTypeId, using the alias name ComplaintTypeId.
     * @return the value of ComplaintTypeId
     */
    public BigDecimal getComplaintTypeId() {
        return (BigDecimal) getAttributeInternal(COMPLAINTTYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ComplaintTypeId.
     * @param value value to set the ComplaintTypeId
     */
    public void setComplaintTypeId(BigDecimal value) {
        setAttributeInternal(COMPLAINTTYPEID, value);
    }

    /**
     * Gets the attribute value for ComplaintType, using the alias name ComplaintType.
     * @return the value of ComplaintType
     */
    public String getComplaintType() {
        return (String) getAttributeInternal(COMPLAINTTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for ComplaintType.
     * @param value value to set the ComplaintType
     */
    public void setComplaintType(String value) {
        setAttributeInternal(COMPLAINTTYPE, value);
    }

    /**
     * Gets the attribute value for SeverityId, using the alias name SeverityId.
     * @return the value of SeverityId
     */
    public BigDecimal getSeverityId() {
        return (BigDecimal) getAttributeInternal(SEVERITYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SeverityId.
     * @param value value to set the SeverityId
     */
    public void setSeverityId(BigDecimal value) {
        setAttributeInternal(SEVERITYID, value);
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
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the value of CreationDate
     */
    public Timestamp getCreationDate() {
        return (Timestamp) getAttributeInternal(CREATIONDATE);
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
     * @param complaintTypeId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal complaintTypeId) {
        return new Key(new Object[] { complaintTypeId });
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

