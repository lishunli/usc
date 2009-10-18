package org.usc.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.usc.ejb3.IHelloWorldRemote;
import org.usc.ejb3.impl.HelloWorldBean;

/**
 * EJB 的客户端
 * 
 * @author MZ
 *
 * @2009-10-18下午08:42:00
 */
public class EJBRemoteClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		//1.获得属性
//		Properties props = new Properties();
//		//2.设置属性
//		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
//		src/jndi.properties文件
//		java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
//		java.naming.provider.url=localhost:1099
		
		try
		{
			//3.获得上下文环境
//			InitialContext ctx= new InitialContext(props);
			InitialContext ctx= new InitialContext();
			//4.通过JNDI获得接口代理
			IHelloWorldRemote helloWorld = (IHelloWorldRemote)ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloWorld.sayHello("Remote : ShunLi Lee"));
		} catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
