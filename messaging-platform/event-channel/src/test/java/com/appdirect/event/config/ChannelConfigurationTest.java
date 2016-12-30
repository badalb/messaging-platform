package com.appdirect.event.config;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ChannelConfigurationTest {

	@Test
	public void testGetHost() {
		String host = ChannelConfiguration.getHost().getValue();
		Assert.assertEquals("127.0.0.1", host);
	}

}
