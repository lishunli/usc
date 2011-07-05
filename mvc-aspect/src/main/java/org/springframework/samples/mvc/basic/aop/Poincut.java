package org.springframework.samples.mvc.basic.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Poincut {
    @Pointcut("execution(* org.springframework.samples.mvc.basic.service.Userervice.login(..))")
    public void isLogin() {}

    @Pointcut("execution(* org.springframework.samples.mvc.basic.service.Userervice.logout(..))")
    public void isLogout() {}

}
