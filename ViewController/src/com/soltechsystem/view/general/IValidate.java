package com.soltechsystem.view.general;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.Period;

import java.util.Calendar;

import javax.faces.application.FacesMessage;

public class IValidate implements Validator{
    public IValidate() {
        super();
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        Timestamp st = (Timestamp)object;
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(st.getTime());
        
        
        Period diff = Period.between(LocalDate.of(c.get(Calendar.YEAR)+1,c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH)), LocalDate.now());

        if (diff.getYears()<18)
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Below 18 Years",null));
          

    }
    
}
