package org.springframework.samples.mvc.basic.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.samples.mvc.basic.model.User;

@Aspect
public class Poincut {
	@Pointcut(value = "execution(* org.springframework.samples.mvc.basic.service.Userervice.login(user))", argNames = "user")
	public void isLogin(User user) {
	}

	@Pointcut(value = "execution(* org.springframework.samples.mvc.basic.service.Userervice.logout(user))", argNames = "user")
	public void isLogout(User user) {
	}

}
