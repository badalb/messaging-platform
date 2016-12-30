package com.appdirect.consumer.framework;

import java.util.Set;

import org.reflections.Reflections;

import com.appdirect.consumer.annotation.DistributedConsumer;
import com.appdirect.consumer.annotation.processor.EventListenerAnnotationTypeProcessor;

public class AppDirectEventConsumerStarter {

	public static void loadContext() {
		Reflections reflections = new Reflections();
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(DistributedConsumer.class);
		for (Class<?> eventconsumer : annotated) {
			try {
				EventConsumer consumer = (EventConsumer) Class.forName(eventconsumer.getName()).newInstance();
				String queueName = EventListenerAnnotationTypeProcessor.process(consumer.getClass());
				consumer.startConsumer(queueName);

			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
