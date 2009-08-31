package com.usc.service;

import com.usc.dao.User;
import com.usc.dao.UserDAO;

public class UserServiceImpl implements IUserService
{
	private UserDAO udao;
	
	public void setUdao(UserDAO udao)
	{
		this.udao = udao;
	}

	public void addUser(User user)
	{
		udao.save(user);
		
	}

}
