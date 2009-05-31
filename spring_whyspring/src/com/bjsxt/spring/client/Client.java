package com.bjsxt.spring.client;

import com.bjsxt.spring.dao.UserDao4MySqlImpl;
import com.bjsxt.spring.dao.UserDao4OracleImpl;
import com.bjsxt.spring.manager.UserManager;
import com.bjsxt.spring.manager.UserManagerImpl;

public class Client {

	public static void main(String[] args) {
		UserManager userManager = new UserManagerImpl(new UserDao4OracleImpl());
//		UserManager userManager = new UserManagerImpl(new UserDao4MySqlImpl());
		userManager.save("уехЩ", "123");
	}
}
