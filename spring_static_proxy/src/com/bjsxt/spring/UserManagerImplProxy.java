package com.bjsxt.spring;

public class UserManagerImplProxy implements UserManager {
	
	private UserManager userManager;
	
	public UserManagerImplProxy(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public void addUser(String username, String password) {
		checkSecurity();
		this.userManager.addUser(username, password);
	}

	public void deleteUser(int id) {
		checkSecurity();
		this.userManager.deleteUser(id);
	}

	public String findUserById(int id) {
		return null;
	}

	public void modifyUser(int id, String username, String password) {
	}
	
	private void checkSecurity() {
	System.out.println("----------checkSecurity()---------------");
}
	
}
