package com.appdirect.consumer.framework;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.appdirect.event.channel.ChannelConfigurer;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public abstract class AppDirectEventConsumer implements EventConsumer {

	public abstract void consumeMessage(Object object);

	public void startConsumer(String queueName) {
		try {
			Channel channel = ChannelConfigurer.createChannel();

			channel.queueDeclare(queueName, true, false, false, null);
			//System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
						byte[] body) throws IOException {
					Object object = deserialize(body);
					consumeMessage(object);
				}
			};
			channel.basicConsume(queueName, true, consumer);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object deserialize(byte[] data) {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			ObjectInputStream is = new ObjectInputStream(in);
			return is.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
