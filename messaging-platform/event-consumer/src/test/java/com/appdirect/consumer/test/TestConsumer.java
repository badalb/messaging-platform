package com.appdirect.consumer.test;

import com.appdirect.consumer.annotation.DistributedConsumer;
import com.appdirect.consumer.framework.AppDirectEventConsumer;
import com.appdirect.springevents.bean.TaskAssignedEvent;

@DistributedConsumer(name = "test.test")
public class TestConsumer extends AppDirectEventConsumer {

	@Override
	public void consumeMessage(Object object) {
		System.out.println("Hi there message consumed");
		TaskAssignedEvent event = (TaskAssignedEvent) object;
		System.out.println(event);
		System.out.println(object);
	}

}
