package com.appdirect.springevents.bean;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@EventListener
	List<TaskEvent> handleAssignedEvent2(TaskAssignedEvent event) {
		return Arrays.asList(new TaskEvent(), new TaskEvent());
	}
}