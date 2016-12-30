package com.appdirect.event.framework;

import java.io.Serializable;

public interface Event extends Serializable {

	Class<? extends Event> getType();
}
