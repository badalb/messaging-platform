package com.appdirect.event.event.publisher;

import java.util.List;

import com.appdirect.event.annotataion.processor.AnnotationDetector;
import com.appdirect.event.framework.Event;
import com.appdirect.event.framework.Handler;

public class AppDirectEventPublisher implements EventPublisher<Event> {

	public AppDirectEventPublisher() {
	}

	public void publishEvent(Event event) {
		List<Class<?>> classAnnotations = AnnotationDetector.detect(event.getClass());
		for (Class<?> annotation : classAnnotations) {
			@SuppressWarnings("unchecked")
			Handler<Event> handler = (Handler<Event>) EventHandlerMapper.getHandlers().get(annotation.getName());
			if (handler != null) {
				handler.onEvent(event);
			}
		}

	}
}