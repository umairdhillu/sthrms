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

public class MobilePhoneValidator implements Validator{
    public MobilePhoneValidator() {
        super();
    }
    

    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        String mobile = "";
        if (object != null)
            mobile= object.toString();
        
        
        String phoneNumber = "[\\+92|0]+[0-9]{3}-[0-9]{7}";
        Pattern pattern = Pattern.compile(phoneNumber);
        Matcher matcher = pattern.matcher(mobile);
        
        

        
        if (!matcher.matches()){
           
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Not Valid Mobile Phone(+92XXX-XXXXXXX or 0XXX-XXXXXXX)",null));
        }else{
            
        }
    }
}
