package com.usc.manager;

import com.usc.util.Users;

public interface userManager
{
	public void addUser(Users user);
	public boolean checkUser(Users user);
	public boolean checkLogin(Users user);
}
