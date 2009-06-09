package com.usc.service;

import java.util.List;

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


	public List findAll()
	{
		return dao.findAll();
	}



}
