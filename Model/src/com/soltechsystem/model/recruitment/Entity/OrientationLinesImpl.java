package com.soltechsystem.model.recruitment.Entity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Apr 24 11:30:45 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OrientationLinesImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        LineId,
        HeadId,
        Line,
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


    public static final int LINEID = AttributesEnum.LineId.index();
    public static final int HEADID = AttributesEnum.HeadId.index();
    public static final int LINE = AttributesEnum.Line.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OrientationLinesImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.soltechsystem.model.recruitment.Entity.OrientationLines");
    }


    /**
     * Gets the attribute value for LineId, using the alias name LineId.
     * @return the value of LineId
     */
    public BigDecimal getLineId() {
        return (BigDecimal) getAttributeInternal(LINEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LineId.
     * @param value value to set the LineId
     */
    public void setLineId(BigDecimal value) {
        setAttributeInternal(LINEID, value);
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
     * @param lineId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal lineId) {
        return new Key(new Object[] { lineId });
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

