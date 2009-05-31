package com.bjsxt.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.spring.dao.UserDao4MySqlImpl;
import com.bjsxt.spring.dao.UserDao4OracleImpl;
import com.bjsxt.spring.manager.UserManager;
import com.bjsxt.spring.manager.UserManagerImpl;

public class Client {

	public static void main(String[] args) {
		//UserManager userManager = new UserManagerImpl(new UserDao4OracleImpl());
//		UserManager userManager = new UserManagerImpl(new UserDao4MySqlImpl());
//		userManager.save("张三", "123");
		
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserManager userManager = (UserManager)factory.getBean("userManager");
		userManager.save("张三", "123");
		
//		UserManagerImpl userManager = new UserManagerImpl();
//		userManager.setUserDao(new UserDao4MySqlImpl());
//		userManager.save("张三", "123");
	}
}
