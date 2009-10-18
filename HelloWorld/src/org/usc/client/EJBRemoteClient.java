package org.usc.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.usc.ejb3.IHelloWorldRemote;
import org.usc.ejb3.impl.HelloWorldBean;

/**
 * EJB �Ŀͻ���
 * 
 * @author MZ
 *
 * @2009-10-18����08:42:00
 */
public class EJBRemoteClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		//1.�������
//		Properties props = new Properties();
//		//2.��������
//		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
//		src/jndi.properties�ļ�
//		java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
//		java.naming.provider.url=localhost:1099
		
		try
		{
			//3.��������Ļ���
//			InitialContext ctx= new InitialContext(props);
			InitialContext ctx= new InitialContext();
			//4.ͨ��JNDI��ýӿڴ���
			IHelloWorldRemote helloWorld = (IHelloWorldRemote)ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloWorld.sayHello("Remote : ShunLi Lee"));
		} catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
