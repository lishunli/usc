package com.bjsxt.spring;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class ScopeTest extends TestCase {
	
	private BeanFactory factory;
	
	@Override
	protected void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");	
	}

	public void testScope1() {
		Bean1 bean11 = (Bean1)factory.getBean("bean1");
		Bean1 bean12 = (Bean1)factory.getBean("bean1");
		if (bean11 == bean12) {
			System.out.println("bean11==bean12");
		}else {
			System.out.println("bean11!=bean12");
		}
		
		String s1 =new String("123");
		String s2 =new String("123");
		
		if(s1==s2)
		{
			System.out.println("s1==s2");
		}
		
		if(s1.equals(s2))
		{
			System.out.println("s1.equals(s2)");
		}
	}
}
