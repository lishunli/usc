package org.usc.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.usc.ejb3.IHelloWorldRemote;
import org.usc.ejb3.IHelloWorldLocal;

/**
 * �ӿ�ʵ���࣬��ʵ��Զ�̽ӿ���ʵ�ֱ��ؽӿ�
 * 
 * @author MZ
 *
 * @2009-10-18����08:23:50
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
