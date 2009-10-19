package org.usc.ejb3.impl;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.usc.ejb3.IHelloWorldRemote;
import org.usc.ejb3.IHelloWorldLocal;
import org.usc.ejb3.IOther;

/**
 * �ӿ�ʵ���࣬��ʵ��Զ�̽ӿ���ʵ�ֱ��ؽӿ�
 * 
 * @author MZ
 *
 * @2009-10-18����08:23:50
 */
//��״̬bean
@Stateless
//��״̬bean
//@Stateful
@Remote(IHelloWorldRemote.class)
@Local(IHelloWorldLocal.class)
public class HelloWorldBean implements IHelloWorldRemote,IHelloWorldLocal
{
//	ejbע���jndi���ҷ������
//	@EJB IOther other;
	@EJB(beanName = "OtherBean") IOther other;
	//@Resource ָ��һЩ��Դ
	//@Resource TimerService timerService;
	
	
//	@Override
//	public String sayHello(String name)
//	{
//		// TODO Auto-generated method stub
//		return name + " say : Hello World";
//	}
	@Override
	public String sayHello(String name)
	{
		
		
//		try
//		{
//			InitialContext ctx = new InitialContext();
//			IOther other = (IOther)ctx.lookup("OtherBean/remote");
//			return name + " say : Hello World" + "  " + other.sayMe();
//		} catch (NamingException e)
//		{
//			e.printStackTrace();
//		}
		
		return name + " say : Hello World" + "  " + other.sayMe();
	}

}
