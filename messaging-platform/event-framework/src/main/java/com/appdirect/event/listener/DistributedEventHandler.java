package com.appdirect.event.listener;

import com.appdirect.event.annotataion.DistributedEvent;
import com.appdirect.event.annotataion.EventProcessor;
import com.appdirect.event.annotataion.processor.EventQueueNameEvaluator;
import com.appdirect.event.annotataion.processor.EventRoutingKeyEvaluator;
import com.appdirect.event.framework.Event;
import com.appdirect.event.framework.Handler;
import com.appdirect.event.publisher.MessagePublisher;

@EventProcessor(type = DistributedEvent.class)
public class DistributedEventHandler<T> implements Handler<Event> {

	public void onEvent(Event event) {

		//System.out.println("This is a distributed event hence it will be processed by this handler");

		//System.out.println("Start integrating with RabbitMQ from here");

		String routingKey = EventRoutingKeyEvaluator.process(event.getClass());

		String queueName = EventQueueNameEvaluator.process(event.getClass());
		
		MessagePublisher.publish(queueName, routingKey, event);
	}

}
