package com.appdirect.test.annotation.listener;

import java.io.Serializable;

import com.appdirect.event.annotataion.EventProcessor;
import com.appdirect.event.annotataion.processor.EventQueueNameEvaluator;
import com.appdirect.event.annotataion.processor.EventRoutingKeyEvaluator;
import com.appdirect.event.framework.Event;
import com.appdirect.event.framework.Handler;
import com.appdirect.event.publisher.MessagePublisher;
import com.appdirect.test.annotation.AppDirect;

@EventProcessor(type = AppDirect.class)
public class AppDirectEventListener<T> implements Handler<Event> {

	public void onEvent(Event event) {

		//System.out.println("Inside appdirect annotation handler");
		String routingKey = EventRoutingKeyEvaluator.process(event.getClass());
		String queueName = EventQueueNameEvaluator.process(event.getClass());
		MessagePublisher.publish(queueName, routingKey, (Serializable) event);

	}

}
