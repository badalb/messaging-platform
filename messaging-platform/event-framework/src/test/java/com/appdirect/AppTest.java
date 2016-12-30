package com.appdirect;

import com.appdirect.event.UserCreatedEvent;
import com.appdirect.event.event.publisher.AppDirectEventPublisher;
import com.appdirect.event.event.publisher.EventPublisher;
import com.appdirect.event.framework.Event;
import com.appdirect.model.User;

public class AppTest {

	public static void main(String[] args) {

		User user = new User("test");
		EventPublisher<Event> publisher = new AppDirectEventPublisher();

		publisher.publishEvent(new UserCreatedEvent(user));

//		long start = System.currentTimeMillis();
//		try {
//			Thread.sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		publisher.publishEvent(new UserCreatedEvent(user));
//		long end = System.currentTimeMillis();
//		// publisher.publishEvent(new UserCreatedEvent(user));
//		System.out.println("total time:" + (end - start));
	}

}
