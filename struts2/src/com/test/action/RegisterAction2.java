package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.test.bean.User;

public class RegisterAction2 extends ActionSupport implements ModelDriven<User>,Preparable
{
	private User user = new User();
	
	public User getModel()
	{
		return user;
	}
//	This prepare() method is called to allow the action to prepare itself.
	public void prepare() throws Exception
	{
		System.out.println("hello world");
	}
	
	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
//		return super.execute();
	}
}
