package com.appdirect.event.event.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.appdirect.event.annotataion.EventProcessor;
import com.appdirect.event.annotataion.processor.EventProcessorAnnotationTypeProcessor;
import com.appdirect.event.framework.Event;
import com.appdirect.event.framework.Handler;

public class EventHandlerMapper {

	private static Map<String, Handler<? extends Event>> handlers;

	public static Map<String, Handler<? extends Event>> getHandlers() {

		if (handlers == null) {
			synchronized (EventHandlerMapper.class) {
				if (handlers == null) {
					handlers = new HashMap<String, Handler<? extends Event>>();

					//// Time taken: 143 milliseconds subsequently takes 2
					//// milliseconds
					Reflections reflections = new Reflections();

					// Time taken 899 milliseconds for the first time
					// subsequently takes 2 milliseconds
					// Reflections reflections = new Reflections();

					Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(EventProcessor.class);
					for (Class<?> listener : annotated) {
						try {
							@SuppressWarnings("unchecked")
							Handler<Event> handler = (Handler<Event>) Class.forName(listener.getName()).newInstance();
							Class<?> clazz = EventProcessorAnnotationTypeProcessor.process(listener);
							registerHandler(clazz, handler);
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return handlers;
	}

	private static <E extends Event> void registerHandler(Class<?> eventType, Handler<E> handler) {
		handlers.put(eventType.getName(), handler);
	}

}
