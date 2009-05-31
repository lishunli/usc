package com.bjsxt.spring;

public class UserManagerImpl implements UserManager {

	public void addUser(String username, String password) {
		System.out.println("-------UserManagerImpl.addUser()----------");
	}

	public void deleteUser(int id) {
		System.out.println("-------UserManagerImpl.deleteUser()----------");
	}

	public String findUserById(int id) {
		System.out.println("-------UserManagerImpl.findUserById()----------");
		return null;
	}

	public void modifyUser(int id, String username, String password) {
		System.out.println("-------UserManagerImpl.modifyUser()----------");
	}
	
//	private void checkSecurity() {
//		System.out.println("----------checkSecurity()---------------");
//	}
}
