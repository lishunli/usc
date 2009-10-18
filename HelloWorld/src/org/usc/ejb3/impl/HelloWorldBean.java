package org.usc.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.usc.ejb3.IHelloWorldRemote;
import org.usc.ejb3.IHelloWorldLocal;

/**
 * 接口实现类，既实现远程接口又实现本地接口
 * 
 * @author MZ
 *
 * @2009-10-18下午08:23:50
 */

@Stateless
@Remote(IHelloWorldRemote.class)
@Local(IHelloWorldLocal.class)
public class HelloWorldBean implements IHelloWorldRemote,IHelloWorldLocal
{
	@Override
	public String sayHello(String name)
	{
		// TODO Auto-generated method stub
		return name + " say : Hello World";
	}

}
