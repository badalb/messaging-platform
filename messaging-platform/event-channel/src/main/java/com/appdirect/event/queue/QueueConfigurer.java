package com.appdirect.event.queue;

import com.appdirect.event.channel.ChannelConfigurer;
import com.appdirect.event.exchange.ExchangeConfigurer;
import com.appdirect.event.util.ChannelConstants;
import com.rabbitmq.client.Channel;

public class QueueConfigurer {

	public static void createAndBindQueue(String exchangeName, String queueName, String routingKey) {

		try {
			Channel channel = ChannelConfigurer.createChannel();
			ExchangeConfigurer.createExchange(channel);
			channel.queueDeclare(queueName, true, false, false, null);
			channel.queueBind(queueName, exchangeName, routingKey);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createAndBindQueue(String queueName, String routingKey) {
		createAndBindQueue(ChannelConstants.EXCHANGE_DATA_DISTRIBUTOR, queueName, routingKey);
	}
}
