package com.appdirect.springevents.bean;

import java.io.Serializable;

import com.appdirect.event.annotataion.DistributedEvent;

@DistributedEvent(queueName = "test.test", routingKey = "test.test")
public class TaskAssignedEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "TaskAssignedEvent";
	}
}