package com.appdirect.event.connection.util;

import java.util.Properties;

import org.junit.Test;

import com.appdirect.event.util.ProprtyUtils;

import junit.framework.Assert;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class ProprtyUtilsTest extends TestCase {

	@Test
	public void testGetProperty() {

		Properties properties = ProprtyUtils.getProperties();
		String host = properties.getProperty("connection.host");
		Assert.assertEquals("127.0.0.1", host);

	}
}
