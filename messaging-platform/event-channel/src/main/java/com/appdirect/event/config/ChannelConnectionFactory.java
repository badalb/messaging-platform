package com.appdirect.event.config;

import com.rabbitmq.client.ConnectionFactory;

public class ChannelConnectionFactory {

	private static ConnectionFactory connectionFactory;

	private ChannelConnectionFactory() {

	}

	public static ConnectionFactory getConnectionFactory() {

		if (connectionFactory == null) {
			synchronized (ChannelConnectionFactory.class) {
				if (connectionFactory == null) {

					connectionFactory = new ConnectionFactory();
					connectionFactory.setHost(ChannelConfiguration.getHost().getValue());
					connectionFactory.setPort(ChannelConfiguration.getPort().getValue());
					connectionFactory.setUsername(ChannelConfiguration.getCredential().getUserName());
					connectionFactory.setPassword(ChannelConfiguration.getCredential().getPassword());
				}
			}

		}
		return connectionFactory;
	}

}
