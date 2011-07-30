package org.usc.jms;

import org.springframework.jms.core.JmsTemplate;

public class SenderOrPublisher {
	private JmsTemplate jmsTemplate;

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

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}
