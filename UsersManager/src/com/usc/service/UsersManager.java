package com.usc.service;

import com.usc.dao.User;

public interface UsersManager
{
	public void addUser(User user);
	public String encoderByMd5(String password);
	public Boolean checkUser(User user);
	
}
