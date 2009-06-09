package com.usc.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.dao.Users;
import com.usc.service.userService;

public class SaveUserAction extends ActionSupport
{
	private Users user;
	private String sex;
	private String mz;
	public String getMz()
	{
		return mz;
	}
	public void setMz(String mz)
	{
		this.mz = mz;
	}


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
	
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}


	@Override
	public String execute() throws Exception
	{
		System.out.println(""+us.findAll().size());
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("list", us.findAll());
		


		
		
		System.out.println("z******"+getSex()+"++++++"+mz);
//		user.setFirstname(sex);
		us.save(user);
		return SUCCESS;
	}

}
