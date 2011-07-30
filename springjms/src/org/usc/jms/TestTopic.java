package org.usc.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTopic {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-topic.xml");
		SenderOrPublisher sender = (SenderOrPublisher) ctx.getBean("batchPublisher");
		sender.sendMessage();
	}

}
