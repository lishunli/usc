package com.bjsxt.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserManagerImpl userManager = (UserManagerImpl)factory.getBean("userManager");
		
		userManager.addUser("уехЩ", "123");
		//userManager.deleteUser(1);
	}
}
