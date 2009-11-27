package org.usc.actions;

import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport
{
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception
	{
		if("jsjmz".equals(username.trim()) && "lishunli".equals(password.trim()))
			return SUCCESS;
		return INPUT;
	}

}
