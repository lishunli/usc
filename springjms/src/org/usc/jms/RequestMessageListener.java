package org.usc.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import org.usc.jms.request.SubmitNewJobRequest;


public class RequestMessageListener implements MessageListener {

	private static final Logger log = Logger.getLogger(RequestMessageListener.class);

	public void onMessage(Message msg) {
		if (msg instanceof ObjectMessage) {
			Object o;
			try {
				o = ((ObjectMessage) msg).getObject();
				handleMessage(o);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}

	protected void handleMessage(Object o) {
		if (o instanceof SubmitNewJobRequest) {
			SubmitNewJobRequest o2 = (SubmitNewJobRequest) o;
			System.out.println(o2.getJobName());
		} else {
			log.info("Unexpected message received");
		}
	}

}
