package com.usc.manager;

import java.util.List;

import com.usc.util.User;
import com.usc.util.UserDAO;

public class userManagerImpl implements userManager
{
	private UserDAO dao;

	public void setDao(UserDAO dao)// Spring注入
	{
		this.dao = dao;
	}

	public void addUser(User user)// 注册用户
	{
		dao.save(user);
	}

	public boolean checkusername(User user)// 查找用户名是否存在
	{
		if (null == dao.findById(user.getUsename()))
		{
			return true;
		} else
		{
			return false;
		}

	}

	public boolean checkuser(User user)//查找用户是否存在
	{
		if (0 == dao.findByExample(user).size())//用户不存在
			return false;
		else
		{
//			List<User> list = (List<User>) dao.findByExample(user);
//			for(User li : list)
//			{
//				System.out.println(""+li.getUsename()+"**"+li.getPassword());
//			}
			return true;
		}
	}

}
