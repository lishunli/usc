package com.bjsxt.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserManager userManager = (UserManager)factory.getBean("userManager");
		
		userManager.addUser("����", "123");
		//userManager.deleteUser(1);
	}
}
