package org.springframework.samples.mvc.basic.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.samples.mvc.basic.model.User;
import org.springframework.samples.mvc.basic.util.SimpleNameUtil;
import org.springframework.stereotype.Component;

@Aspect
@Component("systemAdvisor")
public class SystemAdvisor {
	private Logger log = LoggerFactory.getLogger(getClass());

	@After(value = "org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallUserervice(user)", argNames = "user")
	@Order(20)
	public void executeUsererviceHandler(JoinPoint jp, User user) throws Throwable {
		Object[] params = { user.getUsername(), jp.getSignature().getName(), String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", new Date()) };
		log.info("User [{}] {} at {}.", params);
		// TODO log into db. and ip? user spring security?
	}

	@After("org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallController()")
	@Order(11)
	public void executeControllerHandler(JoinPoint jp) throws Throwable {
		log.info("[FL] Invoke {}.{}()...", SimpleNameUtil.chompClassName(jp.getSignature().getDeclaringTypeName()), jp.getSignature().getName());
		// TODO add args params into log.
	}

	@After("org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallPLController()")
	@Order(12)
	public void executePLControllerHandler(JoinPoint jp) throws Throwable {
		log.info("[PL] Invoke {}.{}()...", SimpleNameUtil.chompClassName(jp.getSignature().getDeclaringTypeName()), jp.getSignature().getName());
		// TODO add args params into log.
	}

	@After("org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallCLController()")
	@Order(13)
	public void executeCLControllerHandler(JoinPoint jp) throws Throwable {
		log.info("[CL] Invoke {}.{}()...", SimpleNameUtil.chompClassName(jp.getSignature().getDeclaringTypeName()), jp.getSignature().getName());
		// TODO add args params into log.
	}

	/**
	 * Method three to calculate spent time in invoke controller method<br>
	 * Advantages: very easy impl and understand(user aspectj,aop) <br>
	 * Disadvantages: very diffcult to get handler's method name<br>
	 *
	 * @param jp
	 * @return
	 * @throws Throwable
	 */
	// @Around("org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallController()")
	@Around("execution(* org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter.handle(..))")
	@Order(3)
	public Object executeControllerFlow(ProceedingJoinPoint jp) throws Throwable {
		long startTime = 0;
		startTime = System.currentTimeMillis();
		Object proceed = jp.proceed(); // execute

		log.info("[4] elapsed time {} ms ", System.currentTimeMillis() - startTime);
		// TODO to get handler's method name.

		return proceed;
	}

//	 @Around("org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallController()")
	@Around("org.springframework.samples.mvc.basic.aop.SystemPointcut.isCallPLController()")
	@Order(5)
	public Object executeControllerNormalFlow(ProceedingJoinPoint jp) throws Throwable {
		long startTime = 0;
		startTime = System.currentTimeMillis();
		Object proceed = jp.proceed(); // execute

		Object[] params = { SimpleNameUtil.chompClassName(jp.getSignature().getDeclaringTypeName()), jp.getSignature().getName(), (System.currentTimeMillis() - startTime) };
		log.info("[1] {} elapsed time for {}() = {} ms ", params);
		// TODO to get handler's method name.

		return proceed;
	}
}
