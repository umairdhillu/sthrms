package com.soltechsystem.view;


import com.soltechsystem.view.general.ADFUtil;

import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;


public class MyPagePhaseListener implements PagePhaseListener {
    public MyPagePhaseListener() {
    }

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {

    }

    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.INIT_CONTEXT_ID) {
            System.out.println( pagePhaseEvent.getSource()+" <<<<");
            if (ADFUtil.getSessionValue("username")==null){
                System.out.println("session is null");
            }else{
                System.out.println("session is not null");
            }
        }
    }

}


