package org.springframework.samples.mvc.basic.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.samples.mvc.basic.model.User;

@Aspect
public class SystemPoincut {
	@Pointcut(value = "execution(* org.springframework.samples.mvc.basic.service.Userervice.*(..)) && args(user,..)", argNames = "user")
	public void isCallUserervice(User user) {
	}

	@Pointcut("execution(public * *(..))")
	public void publicOperation() {
	}

	@Pointcut("execution(* org.springframework.samples.mvc.basic.controller..*.*(..)) ")
	public void isControllerLayer() {
	}

	@Pointcut("@target(org.springframework.stereotype.Controller)")
	public void isController() {
	}

	@Pointcut("publicOperation() && isControllerLayer() && isController()")
	public void isCallController() {
	}

}
