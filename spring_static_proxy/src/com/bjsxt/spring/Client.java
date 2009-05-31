package com.bjsxt.spring;

public class Client {

	public static void main(String[] args) {
//		UserManager userManager = new UserManagerImpl();
		
		UserManager userManager = new UserManagerImplProxy(new UserManagerImpl());
//		userManager.addUser("ÕÅÈı", "123");
		userManager.deleteUser(1);
	}
}
