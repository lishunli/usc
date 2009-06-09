package com.usc.service;

import com.usc.dao.Users;
import com.usc.dao.UsersDAO;

public class userServiceImpl implements userService
{
	private UsersDAO dao;
	
	
	
	public void setDao(UsersDAO dao)
	{
		this.dao = dao;
	}


	public void save(Users user)
	{
		dao.save(user);
	}

}
