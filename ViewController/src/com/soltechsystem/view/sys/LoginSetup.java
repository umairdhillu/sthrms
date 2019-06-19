package com.soltechsystem.view.sys;

import com.soltechsystem.view.general.ADFUtil;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class LoginSetup {
    private String username;
    private String password;
    private RichOutputText login_message;


    public LoginSetup() {
        super();
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String doLogin() {
        boolean login = false;


        BindingContainer bindings = getBindings();
        OperationBinding operationBinding = bindings.getOperationBinding("login");
        String id = (String) operationBinding.execute();
        if (id != null) {
            login = true;
            ADFUtil.setSessionValue("username", getUsername());
            ADFUtil.setSessionValue("userid", id);
            
            ADFUtil.setSessionValue("empid", ADFUtil.callOperation("getEmployeeID", null).toString());
            
        } else {
            login = false;

            //            FacesContext context = FacesContext.getCurrentInstance();
            //            ExtendedRenderKitService erks =
            //            Service.getRenderKitService(context, ExtendedRenderKitService.class);
            //            erks.addScript(context, "alert('hello')");
            //

        }
        if (login) {
            //LOAD ALL PROFILE OPTIONS RELATED TO MAIN MENU AGAINST USER
            ViewObject vOROFILE = ADFUtil.getViewObject("VOMainMenu1Iterator");
            vOROFILE.executeQuery();
            while (vOROFILE.hasNext()) {
                oracle.jbo.Row r = vOROFILE.next();
                ADFUtil.setSessionValue(r.getAttribute("ProfileName") + "", r.getAttribute("ProfileValue") + "");
                System.out.println(r.getAttribute("ProfileName") + "- "+ r.getAttribute("ProfileValue") + "");
            }

            //LOAD ALL PROFILES OPTION RELATED TO MAIN MENU AND OTHER MENU DISPLAYS
            //AGAINST ROLES ASSIGNED TO USER

            ViewObject voROLE = ADFUtil.getViewObject("UserRoleBasedAccessProfiles1Iterator");
            voROLE.executeQuery();
            while (voROLE.hasNext()) {
                oracle.jbo.Row r = voROLE.next();
                ADFUtil.setSessionValue(r.getAttribute("ProfileName") + "", r.getAttribute("ProfileValue") + "");
            }

            //LOAD ALL STRING RESOURCES


            ViewObject voStr = ADFUtil.getViewObject("StringResources1Iterator");
            voROLE.executeQuery();
            while (voStr.hasNext()) {
                oracle.jbo.Row r = voStr.next();
                ADFUtil.setSessionValue(r.getAttribute("ProfileName") + "", r.getAttribute("ProfileValue") + "");
            }

            ADFUtil.redirect("main_menu");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            ExtendedRenderKitService erks = Service.getRenderKitService(context, ExtendedRenderKitService.class);
            erks.addScript(context,
                           "AdfPage.PAGE.findComponent('login_message').setValue('Invalid Username or Password')");
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            adfFacesContext.addPartialTarget(getLogin_message());
            System.out.println("sdfsdfsdf");
        }

        return null;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }


    public void logout(ActionEvent actionEvent) {
        ADFUtil.logout();
        ADFUtil.redirect("login");
    }

    public void setLogin_message(RichOutputText login_message) {
        this.login_message = login_message;
    }

    public RichOutputText getLogin_message() {
        return login_message;
    }


    public void vce(ValueChangeEvent valueChangeEvent) {
        System.out.println("hello");
    }
}
