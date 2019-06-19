package com.soltechsystem.view.general;


import java.io.IOException;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;


public class ADFUtil {
    public ADFUtil() {
        super();
    }
    public static void showMessage(String message) {
            
            FacesMessage fm = new FacesMessage(message);
            /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, fm);
            
 }
    
    public static Object callOperation(String actionName, Map params) {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding(actionName);
        if (params != null) {
            System.out.println(" params is not null");
            operationBinding.getParamsMap().putAll(params);
        }
        Object result = operationBinding.execute();
        return result;
    }


    public static void setSessionValue(String key, String value) {
        ADFContext.getCurrent()
                  .getSessionScope()
                  .put(key, value);
    }

    public static Object getSessionValue(String key) {
        return ADFContext.getCurrent()
                         .getSessionScope()
                         .get(key);
    }

    public static ViewObject getViewObject(String iterator) {
        BindingContainer bindings = getBindings();
        DCBindingContainer bc = (DCBindingContainer) bindings;
        DCIteratorBinding it = bc.findIteratorBinding(iterator);
        return it.getViewObject();
    }

    private static BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public static void logout() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.invalidate();
        
        System.out.println(ADFContext.getCurrent().getSessionScope().get("username")+" ");
    }
    public static Object evaluateEL(String el) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ELContext elContext = facesContext.getELContext();
            ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
            ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);

            return exp.getValue(elContext);
   }

    public static void redirect(String viewname) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();


        ControllerContext controllerCtx = null;
        controllerCtx = ControllerContext.getInstance();
        String activityURL = controllerCtx.getGlobalViewActivityURL(viewname);
        System.out.println(activityURL);
        try {
            ectx.redirect(activityURL);
        } catch (IOException e) { //Can't redirect
            e.printStackTrace();
        }
    }
    public static Object invokeEL(String el, Class[] paramTypes, Object[] params) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        MethodExpression exp = expressionFactory.createMethodExpression(elContext, el, Object.class, paramTypes);

        return exp.invoke(elContext, params);
    }


}
