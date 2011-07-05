package org.springframework.samples.mvc.basic.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.samples.mvc.basic.model.User;

@Aspect
public class SystemAdvisor {
	private Logger log = LoggerFactory.getLogger(getClass());

	@After(value = "org.springframework.samples.mvc.basic.aop.SystemPoincut.isCallUserervice(user)", argNames = "user")
	@Order(1)
	public void handleCallUserervice(JoinPoint jp, User user) throws Throwable {
		Object[] params = { user.getUsername(), jp.getSignature().getName(), String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", new Date()) };
		log.info("User [{}] {} at {}.", params);
		// TODO log into db. and ip? user spring security?
	}
}
