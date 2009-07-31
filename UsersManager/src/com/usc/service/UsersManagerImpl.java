package com.usc.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.usc.dao.User;
import com.usc.dao.UserDAO;

public class UsersManagerImpl implements UsersManager
{

	private UserDAO udao;

	public void setUdao(UserDAO udao)
	{
		this.udao = udao;
	}

	public void addUser(User user)
	{
		udao.save(user);
	}

	public boolean checkUser(User user)
	{
		if (udao.findByExample(user).size() == 0)
			return false;
		return true;
	}

	/**
	 * 传一个字符串，经过MD5经过加密后返回一个加密后的字符串
	 */
	public String encoderByMd5(String password)
	{
		String resultString = null;
		resultString = new String(password);
		MessageDigest md;// 信息摘要
		try
		{
			md = MessageDigest.getInstance("MD5");// 实例化
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digest.length; i++)
			{
				sb.append(Integer.toHexString(((int) digest[i]) & 0xFF));
			}
			resultString = sb.toString();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return resultString;
	}

	public boolean checkUserName(String username)
	{
		if (udao.findByUsername(username).isEmpty())//没有找到用户名，也即用户名不存在
			return true;
		return false;//用户名存在
	}

}
