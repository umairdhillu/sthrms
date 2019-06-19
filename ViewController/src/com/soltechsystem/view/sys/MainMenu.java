package com.soltechsystem.view.sys;

import com.soltechsystem.view.general.ADFUtil;

import javax.faces.event.PhaseEvent;

public class MainMenu {


    public void beforePhase(PhaseEvent ev){
        System.out.println(ev.getPhaseId()+" ");
    }

    public MainMenu() {
        super();
    }


    public String logout() {
        ADFUtil.logout();
        return null;
    }
}
