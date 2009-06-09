package com.usc.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.service.userService;

public class UsersAction extends ActionSupport
{
	private List users;
	private userService us;
	
	public List getUsers()
	{
		return users;
	}
	
	public void setUs(userService us)
	{
		this.us = us;
	}
	public String getAllUsers() {   
		users = us.findAll();   
        return null;   
    }  
	
	
}
