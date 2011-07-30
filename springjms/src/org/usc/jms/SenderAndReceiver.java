package org.usc.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class SenderAndReceiver implements MessageListener{
	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage() {
		int i = 0;
		while ((i++) < 10){
			jmsTemplate.convertAndSend(i + " - Hello world!(" + System.currentTimeMillis() + ")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void onMessage(Message msg) {
		try {
			System.out.println("msg is "+((TextMessage)msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
