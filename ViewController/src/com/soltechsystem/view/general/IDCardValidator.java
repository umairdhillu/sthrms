package com.soltechsystem.view.general;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.Period;

import java.util.Calendar;

import java.util.regex.*;

import javax.faces.application.FacesMessage;

public class IDCardValidator implements Validator{
    public IDCardValidator() {
        super();
    }
    

    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        String nic = "";
        if (object != null)
            nic= object.toString();
        
        
        String nicRegex = "[0-9]{5}\\-[0-9]{7}\\-[0-9]{1}";
        Pattern pattern = Pattern.compile(nicRegex);
        Matcher matcher = pattern.matcher(nic);
        
        

        
        if (!matcher.matches()){
           
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Not Valid CNIC (XXXXX-XXXXXXX-X)",null));
        }else{
            
        }
    }
}
