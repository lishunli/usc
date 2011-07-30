package org.usc.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ReceiverOrSubsciber2 implements MessageListener {
	public void onMessage(Message msg) {
		try {
			System.out.println("From ReceiverOrSubsciber2, msg is " + ((TextMessage) msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
