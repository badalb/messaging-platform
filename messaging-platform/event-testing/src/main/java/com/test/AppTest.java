package com.test;

import com.appdirect.consumer.framework.AppDirectEventConsumerStarter;
import com.appdirect.event.event.publisher.AppDirectEventPublisher;
import com.appdirect.event.event.publisher.EventPublisher;
import com.appdirect.event.framework.Event;
import com.test.bean.TestEvent;

public class AppTest {

	public static void main(String[] args) {
		EventPublisher<Event> publisher = new AppDirectEventPublisher();
		publisher.publishEvent(new TestEvent("Hi There"));
		AppDirectEventConsumerStarter.loadContext();
	}

}
