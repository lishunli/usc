package org.usc.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.usc.jms.request.SubmitNewJobRequest;


public class TestJms {

	public static void main2(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JmsTemplate jmsQueueTemplate = (JmsTemplate) ctx.getBean("jmsQueueTemplate");

		SubmitNewJobRequest msg = new SubmitNewJobRequest();
		msg.setJobRunId(1L);
		msg.setJobName("demo");

		jmsQueueTemplate.convertAndSend(msg);
	}

	public static void main3(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SenderAndReceiver jmsQueueTemplate = (SenderAndReceiver) ctx.getBean("senderAndReceiver");
		jmsQueueTemplate.sendMessage();
	}

	public static void main4(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SenderOrPublisher sender = (SenderOrPublisher) ctx.getBean("sender");
		sender.sendMessage();

//		Receiver receiver = (Receiver) ctx.getBean("receiver");
//		receiver.receiveMessage();
	}

	public static void main5(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx.getBean("batch.jmsFactory"));
	}

	public static void main6(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-queue.xml");
		SenderAndReceiver jmsQueueTemplate = (SenderAndReceiver) ctx.getBean("batchSenderAndReceiver");
		jmsQueueTemplate.sendMessage();
		SenderAndReceiver jmsQueueTemplate2 = (SenderAndReceiver) ctx.getBean("batchSenderAndReceiver2");
		jmsQueueTemplate2.sendMessage();
	}

	public static void main(String[] args) {
		main6(args);
	}

}
