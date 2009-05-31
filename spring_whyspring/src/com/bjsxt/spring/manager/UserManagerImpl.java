package com.bjsxt.spring.manager;

import com.bjsxt.spring.dao.UserDao;

public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	public UserManagerImpl(UserDao userDao) {
		this.userDao = userDao;
	} 
	
	public void save(String username, String password) {
		this.userDao.save(username, password);
	}
}
