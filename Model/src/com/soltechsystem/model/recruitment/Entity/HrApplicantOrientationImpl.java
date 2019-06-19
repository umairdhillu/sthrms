package com.soltechsystem.model.recruitment.Entity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 24 15:51:39 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HrApplicantOrientationImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        OrientationId,
        HeadId,
        ApplicationId,
        Line,
        CreatedBy,
        CreationDate,
        UpdatedBy,
        UpdationDate,
        VersionNumber,
        OrientationDone;
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


    public static final int ORIENTATIONID = AttributesEnum.OrientationId.index();
    public static final int HEADID = AttributesEnum.HeadId.index();
    public static final int APPLICATIONID = AttributesEnum.ApplicationId.index();
    public static final int LINE = AttributesEnum.Line.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();
    public static final int ORIENTATIONDONE = AttributesEnum.OrientationDone.index();

    /**
     * This is the default constructor (do not remove).
     */
    public HrApplicantOrientationImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.soltechsystem.model.recruitment.Entity.HrApplicantOrientation");
    }


    /**
     * Gets the attribute value for OrientationId, using the alias name OrientationId.
     * @return the value of OrientationId
     */
    public BigDecimal getOrientationId() {
        return (BigDecimal) getAttributeInternal(ORIENTATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrientationId.
     * @param value value to set the OrientationId
     */
    public void setOrientationId(BigDecimal value) {
        setAttributeInternal(ORIENTATIONID, value);
    }

    /**
     * Gets the attribute value for HeadId, using the alias name HeadId.
     * @return the value of HeadId
     */
    public BigDecimal getHeadId() {
        return (BigDecimal) getAttributeInternal(HEADID);
    }

    /**
     * Sets <code>value</code> as the attribute value for HeadId.
     * @param value value to set the HeadId
     */
    public void setHeadId(BigDecimal value) {
        setAttributeInternal(HEADID, value);
    }

    /**
     * Gets the attribute value for ApplicationId, using the alias name ApplicationId.
     * @return the value of ApplicationId
     */
    public BigDecimal getApplicationId() {
        return (BigDecimal) getAttributeInternal(APPLICATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ApplicationId.
     * @param value value to set the ApplicationId
     */
    public void setApplicationId(BigDecimal value) {
        setAttributeInternal(APPLICATIONID, value);
    }

    /**
     * Gets the attribute value for Line, using the alias name Line.
     * @return the value of Line
     */
    public String getLine() {
        return (String) getAttributeInternal(LINE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Line.
     * @param value value to set the Line
     */
    public void setLine(String value) {
        setAttributeInternal(LINE, value);
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
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Timestamp value) {
        setAttributeInternal(CREATIONDATE, value);
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
     * Sets <code>value</code> as the attribute value for UpdationDate.
     * @param value value to set the UpdationDate
     */
    public void setUpdationDate(Timestamp value) {
        setAttributeInternal(UPDATIONDATE, value);
    }

    /**
     * Gets the attribute value for VersionNumber, using the alias name VersionNumber.
     * @return the value of VersionNumber
     */
    public BigDecimal getVersionNumber() {
        return (BigDecimal) getAttributeInternal(VERSIONNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for VersionNumber.
     * @param value value to set the VersionNumber
     */
    public void setVersionNumber(BigDecimal value) {
        setAttributeInternal(VERSIONNUMBER, value);
    }


    /**
     * Gets the attribute value for OrientationDone, using the alias name OrientationDone.
     * @return the value of OrientationDone
     */
    public String getOrientationDone() {
        return (String) getAttributeInternal(ORIENTATIONDONE);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrientationDone.
     * @param value value to set the OrientationDone
     */
    public void setOrientationDone(String value) {
        setAttributeInternal(ORIENTATIONDONE, value);
    }

    /**
     * @param orientationId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal orientationId) {
        return new Key(new Object[] { orientationId });
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
        super.doDML(operation, e);
    }
}
