package com.bjsxt.spring;

import org.aspectj.lang.JoinPoint;

public class SecurityHandler {
	
	private void checkSecurity(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("----------checkSecurity()---------------");
	}
	
}
