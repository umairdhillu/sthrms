package com.soltechsystem.view.general;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class ForTesting {
    public ForTesting() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String b1_action() {
        String email = "";

        email = "usmanriaz@usaparel.com";

        System.out.println(email);
        String emailRegex = "[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Z-a-z0-9]{2,4}";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        System.out.println(matcher.matches() + " - " + email);


        
        return null;
    }
}
