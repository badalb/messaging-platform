package com.appdirect.test.annotation.app;

import com.appdirect.event.event.publisher.AppDirectEventPublisher;
import com.appdirect.event.event.publisher.EventPublisher;
import com.appdirect.event.framework.Event;

public class AppDirectAnnotationTest {

	public static void main(String[] args) {
		EventPublisher<Event> publisher = new AppDirectEventPublisher();
		publisher.publishEvent(new AppDirectEvent());
	}

}
