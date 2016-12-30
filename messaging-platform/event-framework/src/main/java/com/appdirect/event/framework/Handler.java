package com.appdirect.event.framework;

public interface Handler<E extends Event> {
	void onEvent(E event);
}