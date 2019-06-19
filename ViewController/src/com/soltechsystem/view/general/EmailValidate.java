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

public class EmailValidate implements Validator{
    public EmailValidate() {
        super();
    }
    

    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        String email = "";
        if (object != null)
            email= object.toString();
        
        System.out.println(email);
        String emailRegex = "[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Z-a-z0-9]{2,4}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        System.out.println(matcher.matches()+" - "+email);
        

        
        if (!matcher.matches()){
           
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Not Valid Email Address",null));
        }else{
            
        }
    }
}
