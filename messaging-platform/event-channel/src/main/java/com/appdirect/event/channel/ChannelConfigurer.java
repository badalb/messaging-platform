package com.appdirect.event.channel;

import com.appdirect.event.config.ChannelConnection;
import com.rabbitmq.client.Channel;

public class ChannelConfigurer {

	public static Channel createChannel() {

		try {
			return ChannelConnection.getConnection().createChannel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}