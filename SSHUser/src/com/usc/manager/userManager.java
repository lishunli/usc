package com.usc.manager;

import com.usc.util.User;

public interface userManager
{	
	public void addUser(User user);
	public boolean checkusername(User user);
	public boolean checkuser(User user);
}
