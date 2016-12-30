package com.test.consumer;

import com.appdirect.consumer.annotation.DistributedConsumer;
import com.appdirect.consumer.framework.AppDirectEventConsumer;
import com.test.bean.TestEvent;

@DistributedConsumer(name = "test_queue")
public class TestConsumer extends AppDirectEventConsumer {

	@Override
	public void consumeMessage(Object object) {
		//System.out.println("Hi there message consumed");
		TestEvent event = (TestEvent) object;
		System.out.println(event);
	}

}
