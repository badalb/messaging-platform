package com.appdirect.event.queue;

import org.junit.Test;

import com.appdirect.event.util.ChannelConstants;

public class QueueConfigurerTest {

	@Test
	public void testCreateAndBindQueue() {

		String exchangeName = ChannelConstants.EXCHANGE_DATA_GATEWAY;
		String queueName = "junit-test-queue";
		String routingKey = "junit.test";
		QueueConfigurer.createAndBindQueue(exchangeName, queueName, routingKey);
	}

}
