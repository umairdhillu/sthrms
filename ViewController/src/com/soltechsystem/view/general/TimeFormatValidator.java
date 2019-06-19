package com.soltechsystem.view.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class TimeFormatValidator implements Validator {
    public TimeFormatValidator() {
        super();
    }
    
    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        String time = "";
        if (object != null)
            time= object.toString();
        
        
        
        
        String timeRegex = "[0-9]{1,2}:[0-9]{1,2}";
        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(time);
        
        

        
        if (!matcher.matches()){
           
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Not a valid Time Format use HH:MM",null));
        }else{
            
        }
    }
}
