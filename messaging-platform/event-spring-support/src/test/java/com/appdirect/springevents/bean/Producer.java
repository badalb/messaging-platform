package com.appdirect.springevents.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appdirect.springevent.AppDirectEventPublisher;

@Component
public class Producer {

	@Autowired
    private AppDirectEventPublisher appDirectEventPublisher;

    public void createTask() {
    	appDirectEventPublisher.publishEvent(new TaskAssignedEvent());
    }
    
    
}