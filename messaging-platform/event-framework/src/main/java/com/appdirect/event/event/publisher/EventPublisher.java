package com.appdirect.event.event.publisher;

import com.appdirect.event.framework.Event;

public interface EventPublisher<E extends Event> {

	public void publishEvent(E event);
}
