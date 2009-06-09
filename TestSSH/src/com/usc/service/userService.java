package com.usc.service;

import java.util.List;

import com.usc.dao.Users;

public interface userService
{
	public void save(Users user);

	public List findAll();
}
