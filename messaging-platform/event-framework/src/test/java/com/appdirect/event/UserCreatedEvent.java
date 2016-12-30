package com.appdirect.event;

import com.appdirect.event.annotataion.DistributedEvent;
import com.appdirect.event.event.AbstractEvent;
import com.appdirect.model.User;

@DistributedEvent(routingKey="test.test")
public class UserCreatedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8586135819286883125L;
	private User user;

	public UserCreatedEvent() {

	}

	public UserCreatedEvent(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
