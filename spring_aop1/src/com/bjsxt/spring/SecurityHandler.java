package com.bjsxt.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ����Aspect
 * @author Administrator
 *
 */
@Aspect
public class SecurityHandler {
	
	/**
	 * ����Pointcut,Pointcut�����ƾ���allAddMethod���˷��������з���ֵ�Ͳ������÷���ֻ��һ��
	 * ��ʶ
	 * 
	 * Pointcut��������һ�����ʽ��������Щ�������Щ����������Joinpoint��
	 */
	@Pointcut("execution(* add*(..)) || execution(* del*(..))")
	private void allAddMethod(){};
	
	/**
	 * ����Advice����ʶ���Ǹ������δ�֯��˷���
	 */
	@Before("allAddMethod()")
	private void checkSecurity() {
		System.out.println("----------checkSecurity()---------------");
	}
	
}
