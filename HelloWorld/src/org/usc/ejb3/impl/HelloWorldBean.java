package org.usc.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.usc.ejb3.IHelloWorld;

/**
 * 接口实现类
 * 
 * @author MZ
 *
 * @2009-10-18下午08:23:50
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
