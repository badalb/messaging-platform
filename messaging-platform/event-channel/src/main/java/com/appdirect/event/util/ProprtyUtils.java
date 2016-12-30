package com.appdirect.event.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProprtyUtils {

	private static Properties properties;

	private ProprtyUtils() {

	}

	public static Properties getProperties() {

		if (properties == null) {
			synchronized (ProprtyUtils.class) {
				if (properties == null) {
					try {
						properties = new Properties();
						InputStream input = ProprtyUtils.class.getClassLoader()
								.getResourceAsStream("channel-config.properties");
						properties.load(input);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}

		}
		return properties;
	}

}
