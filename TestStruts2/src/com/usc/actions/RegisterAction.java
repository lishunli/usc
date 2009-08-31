package com.usc.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.dao.User;
import com.usc.service.IUserService;

public class RegisterAction extends ActionSupport
{
	private User user;
	private String repassword;
	private IUserService us;
	
	public void setUs(IUserService us)
	{
		this.us = us;
	}

	public User getUser()
	{
		return user;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public void validate()
	{
		// TODO Auto-generated method stub]
//		System.out.println("validate");
//		System.out.println("username:"+ user.getUsername());
//		System.out.println("repassword"+this.getRepassword());
//		if()
		if(null == user.getUsername() || "".equals(user.getUsername().trim()))
		{
			this.addFieldError("user.username", "�û�������Ϊ��");
		}
//		else if("admin".equals(user.getUsername().trim()))
//		{
//			this.addFieldError("user.username", "�û�������admin");
//		}
		if(null == user.getPassword() || "".equals(user.getPassword().trim()))
		{
			this.addFieldError("user.password", "���벻��Ϊ��");
		}
		else if(!user.getPassword().equals(repassword))
		{
			this.addFieldError("repassword", "�ظ���������벻��ͬ");
		}
	
//		super.validate();
	}
	
	@Override
	public String execute() throws Exception
	{
		// TODO Auto-generated method stub
//		System.out.println("execute");
//		��֤�û��Ƿ����
		
//		return super.execute();
		us.addUser(user);
		return SUCCESS;
	}
}
