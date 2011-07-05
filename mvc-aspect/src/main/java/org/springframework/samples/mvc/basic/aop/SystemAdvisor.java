package org.springframework.samples.mvc.basic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.samples.mvc.basic.model.User;

@Aspect
public class SystemAdvisor {
	private Logger log = LoggerFactory.getLogger(getClass());

	@After(value = "org.springframework.samples.mvc.basic.aop.Poincut.isLogin()", argNames = "user")
	@Order(1)
	public void logLogin(JoinPoint jp, User user) throws Throwable {
		log.info("invoke {} method", jp.getSignature().getName());
		log.info("{} user login", user.getUsername());
	}

	@Before(value = "org.springframework.samples.mvc.basic.aop.Poincut.isLogout()", argNames = "user")
	@Order(2)
	public void logLogout(JoinPoint jp, User user) throws Throwable {
		log.info("invoke {} method", jp.getSignature().getName());
		log.info("{} user logou", user.getUsername());
	}
}
