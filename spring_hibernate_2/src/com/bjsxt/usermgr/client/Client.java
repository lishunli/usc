package com.bjsxt.usermgr.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.usermgr.manager.UserManager;
import com.bjsxt.usermgr.manager.UserManagerImpl;
import com.bjsxt.usermgr.model.User;

public class Client {

	public static void main(String[] args) {
		User user = new User();
		user.setName("д╬вс");
		
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		UserManager userManager = (UserManager)factory.getBean("userManager");
		
		try {
			userManager.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
