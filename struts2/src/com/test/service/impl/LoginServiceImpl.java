package com.test.service.impl;

import com.test.service.LoginService;

public class LoginServiceImpl implements LoginService
{
	public boolean isLogin(String username, String password)
	{
		if ("hello".equals(username) && "world".equals(password))
		{
			return true;
		}

		return false;
	}

}
