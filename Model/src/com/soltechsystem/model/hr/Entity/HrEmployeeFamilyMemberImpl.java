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
// ---    Fri Dec 07 19:39:28 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HrEmployeeFamilyMemberImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        MemberId,
        EmployeeId,
        RelationType,
        Name,
        Cnic,
        Dob,
        Attrib1,
        Attrib2,
        Attrib3,
        Attrib4,
        Attrib5,
        Col1,
        Col2,
        Col3,
        Col4,
        Col5,
        CreatedBy,
        CreationDate,
        UpdatedBy,
        UpdationDate,
        VersionNumber,
        Address,
        DirectDep;
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


    public static final int MEMBERID = AttributesEnum.MemberId.index();
    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int RELATIONTYPE = AttributesEnum.RelationType.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int CNIC = AttributesEnum.Cnic.index();
    public static final int DOB = AttributesEnum.Dob.index();
    public static final int ATTRIB1 = AttributesEnum.Attrib1.index();
    public static final int ATTRIB2 = AttributesEnum.Attrib2.index();
    public static final int ATTRIB3 = AttributesEnum.Attrib3.index();
    public static final int ATTRIB4 = AttributesEnum.Attrib4.index();
    public static final int ATTRIB5 = AttributesEnum.Attrib5.index();
    public static final int COL1 = AttributesEnum.Col1.index();
    public static final int COL2 = AttributesEnum.Col2.index();
    public static final int COL3 = AttributesEnum.Col3.index();
    public static final int COL4 = AttributesEnum.Col4.index();
    public static final int COL5 = AttributesEnum.Col5.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int UPDATIONDATE = AttributesEnum.UpdationDate.index();
    public static final int VERSIONNUMBER = AttributesEnum.VersionNumber.index();
    public static final int ADDRESS = AttributesEnum.Address.index();
    public static final int DIRECTDEP = AttributesEnum.DirectDep.index();

    /**
     * This is the default constructor (do not remove).
     */
    public HrEmployeeFamilyMemberImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.soltechsystem.model.hr.Entity.HrEmployeeFamilyMember");
    }


    /**
     * Gets the attribute value for MemberId, using the alias name MemberId.
     * @return the value of MemberId
     */
    public BigDecimal getMemberId() {
        return (BigDecimal) getAttributeInternal(MEMBERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MemberId.
     * @param value value to set the MemberId
     */
    public void setMemberId(BigDecimal value) {
        setAttributeInternal(MEMBERID, value);
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
     * Gets the attribute value for RelationType, using the alias name RelationType.
     * @return the value of RelationType
     */
    public BigDecimal getRelationType() {
        return (BigDecimal) getAttributeInternal(RELATIONTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for RelationType.
     * @param value value to set the RelationType
     */
    public void setRelationType(BigDecimal value) {
        setAttributeInternal(RELATIONTYPE, value);
    }

    /**
     * Gets the attribute value for Name, using the alias name Name.
     * @return the value of Name
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Name.
     * @param value value to set the Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for Cnic, using the alias name Cnic.
     * @return the value of Cnic
     */
    public String getCnic() {
        return (String) getAttributeInternal(CNIC);
    }

    /**
     * Sets <code>value</code> as the attribute value for Cnic.
     * @param value value to set the Cnic
     */
    public void setCnic(String value) {
        setAttributeInternal(CNIC, value);
    }

    /**
     * Gets the attribute value for Dob, using the alias name Dob.
     * @return the value of Dob
     */
    public Timestamp getDob() {
        return (Timestamp) getAttributeInternal(DOB);
    }

    /**
     * Sets <code>value</code> as the attribute value for Dob.
     * @param value value to set the Dob
     */
    public void setDob(Timestamp value) {
        setAttributeInternal(DOB, value);
    }

    /**
     * Gets the attribute value for Attrib1, using the alias name Attrib1.
     * @return the value of Attrib1
     */
    public String getAttrib1() {
        return (String) getAttributeInternal(ATTRIB1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attrib1.
     * @param value value to set the Attrib1
     */
    public void setAttrib1(String value) {
        setAttributeInternal(ATTRIB1, value);
    }

    /**
     * Gets the attribute value for Attrib2, using the alias name Attrib2.
     * @return the value of Attrib2
     */
    public String getAttrib2() {
        return (String) getAttributeInternal(ATTRIB2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attrib2.
     * @param value value to set the Attrib2
     */
    public void setAttrib2(String value) {
        setAttributeInternal(ATTRIB2, value);
    }

    /**
     * Gets the attribute value for Attrib3, using the alias name Attrib3.
     * @return the value of Attrib3
     */
    public String getAttrib3() {
        return (String) getAttributeInternal(ATTRIB3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attrib3.
     * @param value value to set the Attrib3
     */
    public void setAttrib3(String value) {
        setAttributeInternal(ATTRIB3, value);
    }

    /**
     * Gets the attribute value for Attrib4, using the alias name Attrib4.
     * @return the value of Attrib4
     */
    public String getAttrib4() {
        return (String) getAttributeInternal(ATTRIB4);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attrib4.
     * @param value value to set the Attrib4
     */
    public void setAttrib4(String value) {
        setAttributeInternal(ATTRIB4, value);
    }

    /**
     * Gets the attribute value for Attrib5, using the alias name Attrib5.
     * @return the value of Attrib5
     */
    public String getAttrib5() {
        return (String) getAttributeInternal(ATTRIB5);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attrib5.
     * @param value value to set the Attrib5
     */
    public void setAttrib5(String value) {
        setAttributeInternal(ATTRIB5, value);
    }

    /**
     * Gets the attribute value for Col1, using the alias name Col1.
     * @return the value of Col1
     */
    public BigDecimal getCol1() {
        return (BigDecimal) getAttributeInternal(COL1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Col1.
     * @param value value to set the Col1
     */
    public void setCol1(BigDecimal value) {
        setAttributeInternal(COL1, value);
    }

    /**
     * Gets the attribute value for Col2, using the alias name Col2.
     * @return the value of Col2
     */
    public BigDecimal getCol2() {
        return (BigDecimal) getAttributeInternal(COL2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Col2.
     * @param value value to set the Col2
     */
    public void setCol2(BigDecimal value) {
        setAttributeInternal(COL2, value);
    }

    /**
     * Gets the attribute value for Col3, using the alias name Col3.
     * @return the value of Col3
     */
    public BigDecimal getCol3() {
        return (BigDecimal) getAttributeInternal(COL3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Col3.
     * @param value value to set the Col3
     */
    public void setCol3(BigDecimal value) {
        setAttributeInternal(COL3, value);
    }

    /**
     * Gets the attribute value for Col4, using the alias name Col4.
     * @return the value of Col4
     */
    public BigDecimal getCol4() {
        return (BigDecimal) getAttributeInternal(COL4);
    }

    /**
     * Sets <code>value</code> as the attribute value for Col4.
     * @param value value to set the Col4
     */
    public void setCol4(BigDecimal value) {
        setAttributeInternal(COL4, value);
    }

    /**
     * Gets the attribute value for Col5, using the alias name Col5.
     * @return the value of Col5
     */
    public BigDecimal getCol5() {
        return (BigDecimal) getAttributeInternal(COL5);
    }

    /**
     * Sets <code>value</code> as the attribute value for Col5.
     * @param value value to set the Col5
     */
    public void setCol5(BigDecimal value) {
        setAttributeInternal(COL5, value);
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
     * Gets the attribute value for Address, using the alias name Address.
     * @return the value of Address
     */
    public String getAddress() {
        return (String) getAttributeInternal(ADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Address.
     * @param value value to set the Address
     */
    public void setAddress(String value) {
        setAttributeInternal(ADDRESS, value);
    }

    /**
     * Gets the attribute value for DirectDep, using the alias name DirectDep.
     * @return the value of DirectDep
     */
    public String getDirectDep() {
        return (String) getAttributeInternal(DIRECTDEP);
    }

    /**
     * Sets <code>value</code> as the attribute value for DirectDep.
     * @param value value to set the DirectDep
     */
    public void setDirectDep(String value) {
        setAttributeInternal(DIRECTDEP, value);
    }

    /**
     * @param memberId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal memberId) {
        return new Key(new Object[] { memberId });
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

