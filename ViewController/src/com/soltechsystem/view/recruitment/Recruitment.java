package com.soltechsystem.view.recruitment;

import com.soltechsystem.view.general.ADFUtil;

import java.util.HashMap;
import java.util.Map;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

public class Recruitment {
    private RichPopup recruitmentPopup;
    private RichTable recruitmentTable;
    private RichPopup applicationPopup;
    private RichTable applicationTable;
    private RichPopup interviewPopup;
    private RichPopup questionnairePopup;
    private RichPopup orientationPopup;

    public Recruitment() {
        super();
    }

    public String showRecruitmentPopup() {
        ADFUtil.callOperation("CreateInsert", null);
        getRecruitmentPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setRecruitmentPopup(RichPopup recruitmentPopup) {
        this.recruitmentPopup = recruitmentPopup;
    }

    public RichPopup getRecruitmentPopup() {
        return recruitmentPopup;
    }

    public void setRecruitmentTable(RichTable recruitmentTable) {
        this.recruitmentTable = recruitmentTable;
    }

    public RichTable getRecruitmentTable() {
        return recruitmentTable;
    }

    public String editVacancy() {
        getRecruitmentPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveVacancy() {
        getRecruitmentPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("HrVacanciesView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getRecruitmentTable());

        return null;
    }

    public String cancelVacancyAndExit() {
        ADFUtil.callOperation("Rollback", null);
        getRecruitmentPopup().hide();
        return null;
    }

    public String showApplicationPopup() {
        ADFUtil.callOperation("CreateInsert1", null);
        getApplicationPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveApplication() {
        getApplicationPopup().hide();

        ADFUtil.callOperation("Commit", null);

        ADFUtil.getViewObject("HrApplicationsView1Iterator").executeQuery();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getApplicationTable());
        return null;
    }

    public String cancelApplication() {
        ADFUtil.callOperation("Rollback", null);
        getApplicationPopup().hide();
        return null;
    }

    public void setApplicationPopup(RichPopup applicationPopup) {
        this.applicationPopup = applicationPopup;
    }

    public RichPopup getApplicationPopup() {
        return applicationPopup;
    }

    public void setApplicationTable(RichTable applicationTable) {
        this.applicationTable = applicationTable;
    }

    public RichTable getApplicationTable() {
        return applicationTable;
    }

    public String viewApplication() {
        getApplicationPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public void setInterviewPopup(RichPopup interviewPopup) {
        this.interviewPopup = interviewPopup;
    }

    public RichPopup getInterviewPopup() {
        return interviewPopup;
    }

    public String newEvaluation() {

        Row row = ADFUtil.getViewObject("HrApplicationsView1Iterator").getCurrentRow();
        int applicationID = Integer.parseInt(row.getAttribute("ApplicationId").toString());
        Map params = new HashMap();
        params.put("applicationID", applicationID);

        String result = ADFUtil.callOperation("interviewDone", params).toString();
        
        System.out.println(result+" result");
        if (result.equals("NOTDONE"))
            ADFUtil.callOperation("CreateInsert2", null);

        getInterviewPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveEvaluation() {
        getInterviewPopup().hide();

        ADFUtil.callOperation("Commit", null);
        return null;
    }

    public String cancelEvaluation() {
        ADFUtil.callOperation("Rollback", null);
        getInterviewPopup().hide();
        return null;
    }

    public String showQuestionnaire() {
        getQuestionnairePopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveAnswers() {
        getQuestionnairePopup().hide();

        ADFUtil.callOperation("Commit", null);
        return null;
    }

    public String cancelAnswers() {
        ADFUtil.callOperation("Rollback", null);
        getQuestionnairePopup().hide();
        return null;
    }

    public void setQuestionnairePopup(RichPopup questionnairePopup) {
        this.questionnairePopup = questionnairePopup;
    }

    public RichPopup getQuestionnairePopup() {
        return questionnairePopup;
    }

    public void setOrientationPopup(RichPopup orientationPopup) {
        this.orientationPopup = orientationPopup;
    }

    public RichPopup getOrientationPopup() {
        return orientationPopup;
    }

    public String showOrientation() {
        getOrientationPopup().show(new RichPopup.PopupHints());
        return null;
    }

    public String saveOrientation() {
        getOrientationPopup().hide();

        ADFUtil.callOperation("Commit", null);
        return null;
    }
}
