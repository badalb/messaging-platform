package com.test.bean;

import com.appdirect.event.annotataion.DistributedEvent;
import com.appdirect.event.event.AbstractEvent;

@DistributedEvent(queueName = "test_queue", routingKey = "test_route.key")
public class TestEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 978818016117492601L;
	private String name;

	public TestEvent() {

	}

	public TestEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
