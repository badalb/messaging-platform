package com.appdirect.springevents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.appdirect.springevents.bean.Producer;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		Producer producer = (Producer) ctx.getBean("producer");
		producer.createTask();
		ctx.close();
	}

}
