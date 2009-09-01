package com.usc.services.custom.Impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.usc.daos.Custom;
import com.usc.daos.CustomDAO;
import com.usc.services.custom.IBeforeMain;

public class BeforeMainImpl implements IBeforeMain {

	private CustomDAO customdao;
	
	public void saveCustom(Custom custom) {
		customdao.save(custom);
	}
	
	public List<Custom> findbyCustomName(String customName) {
		if(customdao.findByCustomName(customName).size()>0)
			return (List<Custom>)customdao.findByCustomName(customName);
		else return null;
		
	}
	
	public List<Custom> findByEmail(String email) {
		if(customdao.findByEmail(email).size()>0)
			return (List<Custom>)customdao.findByEmail(email);
		else return null;
		
	}

	public CustomDAO getCustomdao() {
		return customdao;
	}

	public void setCustomdao(CustomDAO customdao) {
		this.customdao = customdao;
	}

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

	}

	


