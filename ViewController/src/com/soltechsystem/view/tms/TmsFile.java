package com.soltechsystem.view.tms;

import com.soltechsystem.view.general.ADFUtil;

import java.io.InputStream;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TmsFile {
    private UploadedFile attendanceFile;
    private RichInputFile fileBinding;

    public TmsFile() {
    }

    public String processAttendance() {
        InputStream is = null;
        try{
            is = getAttendanceFile().getInputStream();
            XSSFWorkbook workBook = new XSSFWorkbook(is);
            XSSFSheet sheet = workBook.getSheetAt(0);
            int skipRowCount = 0;
            
            ViewObject interfaceVO = ADFUtil.getViewObject("EmployeeInoutInterfaceView1Iterator");
            
            for(Row tempRow:sheet){
                
                if (skipRowCount >= 1){
                    Cell EmployeeID = tempRow.getCell(0);
                    Cell logDate = tempRow.getCell(1);
                    Cell logTime = tempRow.getCell(2);
                    
                    oracle.jbo.Row r = interfaceVO.createRow();
                    r.setAttribute("EmployeeId",EmployeeID.getNumericCellValue());
                    Date d =  logTime.getDateCellValue();
                    
                    r.setAttribute("InoutDate",new Timestamp(logDate.getDateCellValue().getTime()));
                    r.setAttribute("LogTime",new java.sql.Date (logTime.getDateCellValue().getTime()));
                }
                    
                
                skipRowCount = skipRowCount +1;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ADFUtil.callOperation("Commit", null);
        ADFUtil.callOperation("processAttendance", null);
        
        return null;
    }
    
    public void setAttendanceFile(UploadedFile attendanceFile) {
        this.attendanceFile = attendanceFile;
    }

    public UploadedFile getAttendanceFile() {
        return attendanceFile;
    }


   
}
