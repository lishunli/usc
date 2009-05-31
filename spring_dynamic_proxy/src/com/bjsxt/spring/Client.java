package com.bjsxt.spring;

public class Client {

	public static void main(String[] args) {
		//UserManager userManager = new UserManagerImpl();
		
		SecurityHandler handler = new SecurityHandler();
		UserManager userManager = (UserManager)handler.newProxy(new UserManagerImpl());
		
		userManager.addUser("ÕÅÈı", "123");
		userManager.deleteUser(1);
		userManager.findUserById(1);
	}
}
