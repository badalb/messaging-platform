package com.appdirect.springevent;

import java.lang.annotation.Annotation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.appdirect.event.annotataion.DistributedEvent;
import com.appdirect.event.annotataion.processor.EventQueueNameEvaluator;
import com.appdirect.event.annotataion.processor.EventRoutingKeyEvaluator;
import com.appdirect.event.publisher.MessagePublisher;

@Component
public class AppDirectEventPublisher implements ApplicationEventPublisher {

	private final ApplicationEventPublisher publisher;

	public AppDirectEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void publishEvent(ApplicationEvent event) {
		publisher.publishEvent(event);
	}

	public void publishEvent(Object event) {
		
		Annotation[] annotations = event.getClass().getAnnotations();
		for (Annotation annotation : annotations) {
			if(annotation instanceof DistributedEvent){
				String routingKey = EventRoutingKeyEvaluator.process(event.getClass());
				String queueName = EventQueueNameEvaluator.process(event.getClass());
				MessagePublisher.publish(queueName, routingKey, event);
			}
		}
		publisher.publishEvent(event);
	}

}
