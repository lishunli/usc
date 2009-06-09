package com.usc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.dao.Users;
import com.usc.service.userService;

public class SaveUserAction extends ActionSupport
{
	private Users user;
	private userService us;
	public Users getUser()
	{
		return user;
	}
	public void setUser(Users user)
	{
		this.user = user;
	}
	public void setUs(userService us)
	{
		this.us = us;
	}
	
	@Override
	public String execute() throws Exception
	{
		us.save(user);
		return SUCCESS;
	}

}
