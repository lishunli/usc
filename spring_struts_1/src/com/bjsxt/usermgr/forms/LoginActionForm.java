package com.bjsxt.usermgr.forms;

import org.apache.struts.action.ActionForm;

//数据收集
public class LoginActionForm extends ActionForm {
	
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
}
