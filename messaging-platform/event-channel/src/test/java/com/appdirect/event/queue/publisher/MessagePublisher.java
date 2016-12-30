package com.appdirect.event.queue.publisher;

import org.junit.Test;

import com.appdirect.event.channel.ChannelConfigurer;
import com.appdirect.event.queue.QueueConfigurer;
import com.appdirect.event.util.ChannelConstants;
import com.rabbitmq.client.Channel;

public class MessagePublisher {

	@Test
	public void publishToQueue() {
		Channel channel = ChannelConfigurer.createChannel();
		try {

			String routingKey = getRouting();
			String message = getMessage();

			QueueConfigurer.createAndBindQueue(ChannelConstants.EXCHANGE_DATA_DISTRIBUTOR, getQueueName(), routingKey);

			channel.basicPublish(ChannelConstants.EXCHANGE_DATA_GATEWAY, routingKey, null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (channel.getConnection() != null) {
				try {
					channel.getConnection().close();
				} catch (Exception ignore) {
				}
			}
		}
	}

	private static String getRouting() {
		return "test.test";
	}

	private static String getMessage() {
		return "Hello World";
	}

	private static String getQueueName() {
		return getRouting();
	}
}
