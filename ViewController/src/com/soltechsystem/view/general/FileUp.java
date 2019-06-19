package com.soltechsystem.view.general;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.model.UploadedFile;


public class FileUp {
    private UploadedFile profileImage;
    private RichPopup profileImagePopup;
    private RichImage profilePic;
    private List<UploadedFile> cnicFiles;
    private List<UploadedFile> drivingLicense;
    private List<UploadedFile> passport;
    
    public FileUp() {
        super();
    }

    public void setPassport(List<UploadedFile> passport) {
        this.passport = passport;
    }

    public List<UploadedFile> getPassport() {
        return passport;
    }

    public String uploadProfileImage() {
        UploadedFile f = getProfileImage();
        String fileExt = f.getFilename().split("\\.")[1];
        InputStream is = null;

        FileOutputStream fos = null;
        try {
            is = f.getInputStream();

            Row r = (Row) ADFUtil.evaluateEL("#{bindings.HrEmployeesView1Iterator.currentRow}");
            fos =
                new FileOutputStream(ADFUtil.getSessionValue("PROFILE_PIC_PATH").toString() + r.getAttribute("EmployeeId") + "." +
                                     fileExt);
            byte[] buffer = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, numBytesRead);
            }
            is.close();
            fos.close();
            System.out.println("closed");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        getProfileImagePopup().hide();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(getProfilePic());
        return null;
    }


    public void setProfileImage(UploadedFile profileImage) {
        this.profileImage = profileImage;
    }

    public UploadedFile getProfileImage() {
        return profileImage;
    }


    public void setDrivingLicense(List<UploadedFile> drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public List<UploadedFile> getDrivingLicense() {
        return drivingLicense;
    }

    public void setProfileImagePopup(RichPopup profileImagePopup) {
        this.profileImagePopup = profileImagePopup;
    }

    public RichPopup getProfileImagePopup() {
        return profileImagePopup;
    }

    public void setProfilePic(RichImage profilePic) {
        this.profilePic = profilePic;
    }

    public RichImage getProfilePic() {
        return profilePic;
    }

    public void setCnicFiles(List<UploadedFile> cnicFiles) {
        this.cnicFiles = cnicFiles;
    }

    public List<UploadedFile> getCnicFiles() {
        return cnicFiles;
    }

    public String uploadCNIC() {
        List<UploadedFile> files = getCnicFiles();
        ViewObject filesVO = ADFUtil.getViewObject("SysFilesView1Iterator");
        Row currEmployeeRow = (Row) ADFUtil.evaluateEL("#{bindings.HrEmployeesView1Iterator.currentRow}");
        String employeeID = currEmployeeRow.getAttribute("EmployeeId").toString();
        int count = 1;
        
        //call a stored procedure to delete all previous cnic
        Map params = new HashMap();
        params.put("type", "CNIC");
        params.put("employeeID", Integer.parseInt(employeeID));
        ADFUtil.callOperation("deleteFileLinks", params);
        
        //save to database and disk
        for (UploadedFile file : files) {
            Row r = filesVO.createRow();
            r.setAttribute("FileMimeType", file.getContentType());
            r.setAttribute("FileName", employeeID + "_" + count);
            r.setAttribute("FileContext", "CNIC");
            r.setAttribute("ReferenceId", employeeID);
            r.setAttribute("FileExt",file.getFilename().split("\\.")[1]);
            
            copyFile(file,
                     ADFUtil.getSessionValue("CNIC_PIC_PATH").toString() + employeeID + "_" + count + "." +
                     file.getFilename().split("\\.")[1]);
            count = count+1;

        }
        ADFUtil.showMessage("Cnic Uploaded");
        
        ADFUtil.callOperation("Commit", null);
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

    public String uploadDrivingLicense() {
        List<UploadedFile> files = getDrivingLicense();
        ViewObject filesVO = ADFUtil.getViewObject("SysFilesView1Iterator");
        Row currEmployeeRow = (Row) ADFUtil.evaluateEL("#{bindings.HrEmployeesView1Iterator.currentRow}");
        String employeeID = currEmployeeRow.getAttribute("EmployeeId").toString();
        int count = 1;
        
        //call a stored procedure to delete all previous driving license
        Map params = new HashMap();
        params.put("type", "DRIVING_LICENSE");
        params.put("employeeID", Integer.parseInt(employeeID));
        ADFUtil.callOperation("deleteFileLinks", params);
        
        //save to database and disk
        for (UploadedFile file : files) {
            Row r = filesVO.createRow();
            r.setAttribute("FileMimeType", file.getContentType());
            r.setAttribute("FileName", employeeID + "_" + count);
            r.setAttribute("FileContext", "DRIVING_LICENSE");
            r.setAttribute("ReferenceId", employeeID);
            r.setAttribute("FileExt",file.getFilename().split("\\.")[1]);
            
            System.out.println(ADFUtil.getSessionValue("DRIVING_LICENSE_PATH").toString());
            copyFile(file,
                     ADFUtil.getSessionValue("DRIVING_LICENSE_PATH").toString() + employeeID + "_" + count + "." +
                     file.getFilename().split("\\.")[1]);
            count = count+1;

        }
        ADFUtil.showMessage("Driving License Uploaded");
        ADFUtil.callOperation("Commit", null);
        return null;
    }

    public String uploadPassport() {
        List<UploadedFile> files = getPassport();
        ViewObject filesVO = ADFUtil.getViewObject("SysFilesView1Iterator");
        Row currEmployeeRow = (Row) ADFUtil.evaluateEL("#{bindings.HrEmployeesView1Iterator.currentRow}");
        String employeeID = currEmployeeRow.getAttribute("EmployeeId").toString();
        int count = 1;
        
        //call a stored procedure to delete all previous cnic
        Map params = new HashMap();
        params.put("type", "PASSPORT");
        params.put("employeeID", Integer.parseInt(employeeID));
        ADFUtil.callOperation("deleteFileLinks", params);
        
        //save to database and disk
        for (UploadedFile file : files) {
            Row r = filesVO.createRow();
            r.setAttribute("FileMimeType", file.getContentType());
            r.setAttribute("FileName", employeeID + "_" + count);
            r.setAttribute("FileContext", "PASSPORT");
            r.setAttribute("ReferenceId", employeeID);
            r.setAttribute("FileExt",file.getFilename().split("\\.")[1]);
            
            copyFile(file,
                     ADFUtil.getSessionValue("PASSPORT_PATH").toString() + employeeID + "_" + count + "." +
                     file.getFilename().split("\\.")[1]);
            count = count+1;

        }
        ADFUtil.showMessage("Passport Uploaded");
        ADFUtil.callOperation("Commit", null);
        return null;
    }
}
