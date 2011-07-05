package org.springframework.samples.mvc.basic.aop;

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

	@After(value = "org.springframework.samples.mvc.basic.aop.Poincut.isUserervice(user)", argNames = "user")
	@Order(1)
	public void logLogin(JoinPoint jp, User user) throws Throwable {
		log.info("{} user {}", user.getUsername(), jp.getSignature().getName());
	}
}
