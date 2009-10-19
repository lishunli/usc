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
 * 接口实现类，既实现远程接口又实现本地接口
 * 
 * @author MZ
 *
 * @2009-10-18下午08:23:50
 */
//无状态bean
@Stateless
//有状态bean
//@Stateful
@Remote(IHelloWorldRemote.class)
@Local(IHelloWorldLocal.class)
public class HelloWorldBean implements IHelloWorldRemote,IHelloWorldLocal
{
//	ejb注入比jndi查找方便多了
//	@EJB IOther other;
	@EJB(beanName = "OtherBean") IOther other;
	//@Resource 指定一些资源
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
