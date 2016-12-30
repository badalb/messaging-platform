package com.appdirect.event.annotataion.processor;

import java.lang.annotation.Annotation;

import com.appdirect.event.annotataion.DistributedEvent;

public class EventQueueNameEvaluator {

	public static String process(Class<? extends Object> classObject) {

		Annotation[] annotations = classObject.getAnnotations();

		for (Annotation annotation : annotations) {
			if (annotation instanceof DistributedEvent) {
				DistributedEvent event = (DistributedEvent) annotation;
				return event.queueName();
			}
		}
		return null;
	}
}
