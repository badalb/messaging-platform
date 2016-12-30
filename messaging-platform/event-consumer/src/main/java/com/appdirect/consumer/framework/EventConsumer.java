package com.appdirect.consumer.framework;

public interface EventConsumer {

	public void consumeMessage(Object object);

	public void startConsumer(String queueName);
}
