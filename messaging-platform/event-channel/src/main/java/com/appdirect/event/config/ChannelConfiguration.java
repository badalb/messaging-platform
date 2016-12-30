package com.appdirect.event.config;

import com.appdirect.event.util.ProprtyUtils;
import com.rabbitmq.client.ConnectionFactory;

public class ChannelConfiguration {

	public static Host getHost() {
		return new Host() {
			public String getValue() {
				String host = ProprtyUtils.getProperties().getProperty("connection.host");
				return host != null ? host : ConnectionFactory.DEFAULT_HOST;
			}

		};

	}

	public static Port getPort() {
		return new Port() {
			public int getValue() {
				String port = ProprtyUtils.getProperties().getProperty("connection.port");
				return port != null ? Integer.valueOf(port) : ConnectionFactory.DEFAULT_AMQP_PORT;
			}
		};

	}

	public static Credential getCredential() {
		return new Credential() {

			public String getUserName() {
				String username = ProprtyUtils.getProperties().getProperty("connection.username");
				return username != null ? username : ConnectionFactory.DEFAULT_USER;
			}

			public String getPassword() {
				String password = ProprtyUtils.getProperties().getProperty("connection.password");
				return password != null ? password : ConnectionFactory.DEFAULT_PASS;
			}
		};
	}
}
