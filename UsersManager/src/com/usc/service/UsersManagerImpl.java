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
	 * ��һ���ַ���������MD5�������ܺ󷵻�һ�����ܺ���ַ���
	 */
	public String encoderByMd5(String password)
	{
		String resultString = null;
		resultString = new String(password);
		MessageDigest md;// ��ϢժҪ
		try
		{
			md = MessageDigest.getInstance("MD5");// ʵ����
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
		if (udao.findByUsername(username).isEmpty())//û���ҵ��û�����Ҳ���û���������
			return true;
		return false;//�û�������
	}

}
