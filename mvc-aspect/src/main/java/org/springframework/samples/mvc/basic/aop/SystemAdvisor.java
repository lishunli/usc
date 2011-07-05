package org.springframework.samples.mvc.basic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
public class SystemAdvisor {
	private Logger log = LoggerFactory.getLogger(getClass());

	@After("org.springframework.samples.mvc.basic.aop.Poincut.isLogin()")
	@Order(1)
	public void logLogin(JoinPoint jp) throws Throwable {
		log.info("invoke {} method", jp.getSignature().getName());
	}

	@Before("org.springframework.samples.mvc.basic.aop.Poincut.isLogout()")
	@Order(2)
	public void logLogout(JoinPoint jp) throws Throwable {
		log.info("invoke {} method", jp.getSignature().getName());
	}
}
