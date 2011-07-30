package org.usc.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQueue {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-queue.xml");
		SenderOrPublisher sender = (SenderOrPublisher) ctx.getBean("batchSender");
		sender.sendMessage();
	}

}
