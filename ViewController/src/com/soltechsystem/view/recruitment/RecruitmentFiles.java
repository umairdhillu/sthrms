package com.soltechsystem.view.recruitment;

import com.soltechsystem.view.general.ADFUtil;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class RecruitmentFiles {
    
    private List<UploadedFile> cvFiles;


    public void setCvFiles(List<UploadedFile> cvFiles) {
        this.cvFiles = cvFiles;
    }

    public List<UploadedFile> getCvFiles() {
        return cvFiles;
    }

    public RecruitmentFiles() {
        super();
    }

   
    public String uploadCV() {
        System.out.println(getCvFiles().size()+" <<<");
        List<UploadedFile> files = getCvFiles();
        ViewObject filesVO = ADFUtil.getViewObject("SysFilesView1Iterator");
        Row currEmployeeRow = (Row) ADFUtil.evaluateEL("#{bindings.HrApplicationsView1Iterator.currentRow}");
        String applicationID = currEmployeeRow.getAttribute("ApplicationId").toString();
        int count = 1;
        
        //call a stored procedure to delete all previous driving license
        Map params = new HashMap();
        params.put("type", "APPLICANT_CV");
        params.put("referenceID", Integer.parseInt(applicationID));
        ADFUtil.callOperation("deleteFileLinks", params);
        
        //save to database and disk
        
        for (UploadedFile file : files) {
            Row r = filesVO.createRow();
            r.setAttribute("FileMimeType", file.getContentType());
            r.setAttribute("FileName", applicationID + "_" + count);
                r.setAttribute("FileContext", "APPLICANT_CV");
            r.setAttribute("ReferenceId", applicationID);
            r.setAttribute("FileExt",file.getFilename().split("\\.")[1]);
            
            System.out.println(ADFUtil.getSessionValue("APPLICANT_CV_PATH").toString());
            copyFile(file,
                     ADFUtil.getSessionValue("APPLICANT_CV_PATH").toString() + applicationID + "_" + count + "." +
                     file.getFilename().split("\\.")[1]);
            count = count+1;

        }
        ADFUtil.showMessage("cv Uploaded");
        ADFUtil.callOperation("Commit1", null);
        return null;
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
