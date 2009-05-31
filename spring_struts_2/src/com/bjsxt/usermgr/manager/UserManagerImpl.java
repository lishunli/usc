package com.bjsxt.usermgr.manager;

public class UserManagerImpl implements UserManager {

	public void login(String username, String password) {
		System.out.println("UserManagerImpl.login() -- username=" + username);
	}
}
