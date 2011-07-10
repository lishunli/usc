package org.springframework.samples.mvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SystemPointcut {

	@Pointcut("execution(public * *(..))")
	public void publicOperation() {
	}

	@Pointcut("@target(org.springframework.stereotype.Controller)")
	public void isController() {
	}

	// class level, class name org.springframework..controller..*Controller..
	@Pointcut("execution(* org.springframework..*Controller.*(..)) ")
	public void isControllerLayout() {
	}

	@Pointcut("publicOperation() && isControllerLayout() && isController()")
	public void isCallController() {
	}

}
