package com.usc.manager;

import java.util.List;

import com.usc.util.User;
import com.usc.util.UserDAO;

public class userManagerImpl implements userManager
{
	private UserDAO dao;

	public void setDao(UserDAO dao)// Springע��
	{
		this.dao = dao;
	}

	public void addUser(User user)// ע���û�
	{
		dao.save(user);
	}

	public boolean checkusername(User user)// �����û����Ƿ����
	{
		if (null == dao.findById(user.getUsename()))
		{
			return true;
		} else
		{
			return false;
		}

	}

	public boolean checkuser(User user)//�����û��Ƿ����
	{
		if (0 == dao.findByExample(user).size())//�û�������
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
