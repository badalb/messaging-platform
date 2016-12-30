package com.appdirect.consumer.annotation.processor;

import java.lang.annotation.Annotation;

import com.appdirect.consumer.annotation.DistributedConsumer;

public class EventListenerAnnotationTypeProcessor {

	public static String process(Class<? extends Object> classObject) {

		Annotation[] annotations = classObject.getAnnotations();

		for (Annotation annotation : annotations) {
			if (annotation instanceof DistributedConsumer) {
				DistributedConsumer consumer = (DistributedConsumer) annotation;
				return consumer.name();
			}
		}
		return null;
	}
}
