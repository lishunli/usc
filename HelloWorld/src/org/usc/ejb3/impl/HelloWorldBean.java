package org.usc.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.usc.ejb3.IHelloWorld;

/**
 * �ӿ�ʵ����
 * 
 * @author MZ
 *
 * @2009-10-18����08:23:50
 */

@Stateless
@Remote(IHelloWorld.class)
public class HelloWorldBean implements IHelloWorld
{
	@Override
	public String sayHello(String name)
	{
		// TODO Auto-generated method stub
		return name + " say : Hello World";
	}

}
