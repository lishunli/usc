package org.usc.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.usc.ejb3.IOther;
/**
 * �����ӿ�ʵ��
 * 
 * @author MZ
 *
 * @2009-10-19����09:19:43
 */
@Stateless
@Remote(IOther.class)
public class OtherBean implements IOther
{

	@Override
	public String sayMe()
	{
		// TODO Auto-generated method stub
		return "other";
	}

}
