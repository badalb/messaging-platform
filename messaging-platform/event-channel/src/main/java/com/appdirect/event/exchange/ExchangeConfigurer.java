package com.appdirect.event.exchange;

import com.appdirect.event.util.ChannelConstants;
import com.rabbitmq.client.Channel;

public class ExchangeConfigurer {

	public static void createExchange(Channel channel) {

		try {

			// Fanout data gateway exchange
			channel.exchangeDeclare(ChannelConstants.EXCHANGE_DATA_GATEWAY, ChannelConstants.DATA_GATEWAY_EXCHANGE_TYPE,
					true, false, null);

			// Topic data distributor exchange gateway
			channel.exchangeDeclare(ChannelConstants.EXCHANGE_DATA_DISTRIBUTOR,
					ChannelConstants.DATA_DISTRIBUTOR_EXCHANGE_TYPE, true, false, null);

			// Bind data gateway to data distributor
			channel.exchangeBind(ChannelConstants.EXCHANGE_DATA_DISTRIBUTOR, ChannelConstants.EXCHANGE_DATA_GATEWAY,
					ChannelConstants.ROUTING_KEY_ALL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}