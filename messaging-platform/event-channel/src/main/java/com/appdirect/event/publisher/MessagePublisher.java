package com.appdirect.event.publisher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.appdirect.event.channel.ChannelConfigurer;
import com.appdirect.event.queue.QueueConfigurer;
import com.appdirect.event.util.ChannelConstants;
import com.rabbitmq.client.Channel;

public class MessagePublisher {

	public static void publish(String queueName, String routingKey, Object message) {

		Channel channel = ChannelConfigurer.createChannel();

		QueueConfigurer.createAndBindQueue(ChannelConstants.EXCHANGE_DATA_DISTRIBUTOR, queueName, routingKey);

		try {
			channel.basicPublish(ChannelConstants.EXCHANGE_DATA_GATEWAY, routingKey, null,
					serialize(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static byte[] serialize(Object obj) throws IOException {
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    ObjectOutputStream os = new ObjectOutputStream(out);
	    os.writeObject(obj);
	    return out.toByteArray();
	}
}
