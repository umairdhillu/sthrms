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

public class DoNotValidate implements Validator{
    public DoNotValidate() {
        super();
    }
    

    @Override
    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
        
    }
}
