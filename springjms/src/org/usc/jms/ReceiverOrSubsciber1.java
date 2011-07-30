package org.usc.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ReceiverOrSubsciber1 implements MessageListener {
	public void onMessage(Message msg) {
		try {
			System.out.println("From ReceiverOrSubsciber1, msg is " + ((TextMessage) msg).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
