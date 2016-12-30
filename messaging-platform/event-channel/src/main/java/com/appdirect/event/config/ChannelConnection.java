package com.appdirect.event.config;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;

public class ChannelConnection {

	private static Connection connection;

	private ChannelConnection() {

	}

	public static Connection getConnection() {
		if (connection == null) {
			synchronized (ChannelConnection.class) {
				if (connection == null) {
					try {
						connection = ChannelConnectionFactory.getConnectionFactory().newConnection();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (TimeoutException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return connection;
	}
	
	public static void closeConnection(){
		if(connection !=null){
			try {
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
