package com.bjsxt.usermgr.client;

import com.bjsxt.usermgr.manager.UserManager;
import com.bjsxt.usermgr.manager.UserManagerImpl;
import com.bjsxt.usermgr.model.User;

public class Client {

	public static void main(String[] args) {
		User user = new User();
		user.setName("ÕÅÈı");
		
		UserManager userManager = new UserManagerImpl();
		userManager.addUser(user);
	}
}
