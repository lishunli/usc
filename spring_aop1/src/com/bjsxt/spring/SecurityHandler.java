package com.bjsxt.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义Aspect
 * @author Administrator
 *
 */
@Aspect
public class SecurityHandler {
	
	/**
	 * 定义Pointcut,Pointcut的名称就是allAddMethod，此方法不能有返回值和参数，该方法只是一个
	 * 标识
	 * 
	 * Pointcut的内容是一个表达式，描述那些对象的那些方法（订阅Joinpoint）
	 */
	@Pointcut("execution(* add*(..)) || execution(* del*(..))")
	private void allAddMethod(){};
	
	/**
	 * 定义Advice，标识在那个切入点何处织入此方法
	 */
	@Before("allAddMethod()")
	private void checkSecurity() {
		System.out.println("----------checkSecurity()---------------");
	}
	
}
