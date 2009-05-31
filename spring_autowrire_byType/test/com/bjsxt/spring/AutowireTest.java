package com.bjsxt.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AutowireTest extends TestCase {
	
	private BeanFactory factory;
	
	@Override
	protected void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");	
	}

	public void testAutowire() {
		Bean2 bean2 = (Bean2)factory.getBean("bean2");
		System.out.println("bean2.bean3.id=" + bean2.getBean3().getId());
		System.out.println("bean2.bean3.name=" + bean2.getBean3().getName());
		System.out.println("bean2.bean3.password=" + bean2.getBean3().getPassword());
		System.out.println("bean2.bean4.id=" + bean2.getBean4().getId());
		System.out.println("bean2.bean4.name=" + bean2.getBean4().getName());
		System.out.println("bean2.bean5.age=" + bean2.getBean5().getAge());
	}
	
}
