package org.springframework.samples.mvc.aop;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.samples.mvc.util.SimpleNameUtil;

@Aspect
public class SystemAdvisor {
	private Logger log = LoggerFactory.getLogger(getClass());

	@After("org.springframework.samples.mvc.aop.SystemPointcut.isCallController()")
	@Order(13)
	public void executeControllerHandler(JoinPoint jp) throws Throwable {
		log.info(StringUtils.center(" 我就是哥 ", 100, "-"));
		log.info(StringUtils.repeat("-", 100));
		log.info("Invoke {}.{}()...", SimpleNameUtil.chompClassName(jp.getSignature().getDeclaringTypeName(), 2), jp.getSignature().getName());
	}
}
