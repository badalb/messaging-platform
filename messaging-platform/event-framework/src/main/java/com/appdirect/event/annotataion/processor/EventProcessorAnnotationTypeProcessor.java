package com.appdirect.event.annotataion.processor;

import java.lang.annotation.Annotation;

import com.appdirect.event.annotataion.EventProcessor;

public class EventProcessorAnnotationTypeProcessor {

	public static Class<? extends Object> process(Class<? extends Object> classObject) {

		Annotation[] annotations = classObject.getAnnotations();

		for (Annotation annotation : annotations) {
			if (annotation instanceof EventProcessor) {
				EventProcessor processor = (EventProcessor) annotation;
				return processor.type();
			}
		}
		return null;
	}
}
