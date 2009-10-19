package org.usc.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.usc.ejb3.IOther;
/**
 * 其他接口实现
 * 
 * @author MZ
 *
 * @2009-10-19上午09:19:43
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
