package com.appdirect.event.event;

import com.appdirect.event.framework.Event;

public abstract class AbstractEvent implements Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8720548219146086690L;

	public Class<? extends Event> getType() {
		return getClass();
	}
}