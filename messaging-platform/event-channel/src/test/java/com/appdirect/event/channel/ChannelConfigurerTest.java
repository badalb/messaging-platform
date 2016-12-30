package com.appdirect.event.channel;

import org.junit.Test;

import com.rabbitmq.client.Channel;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ChannelConfigurerTest {

	@Test
	public void testCreateChannel() {
		Channel channel = ChannelConfigurer.createChannel();
		Assert.assertNotNull(channel);
	}

}
