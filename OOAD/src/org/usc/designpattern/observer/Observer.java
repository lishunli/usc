package org.usc.designpattern.observer;

import java.io.IOException;
import java.util.Properties;
/**
 * 设计模式之观察着模式
 * 
 * @author MZ
 *
 * @2009-10-22上午10:29:01
 */
public class Observer
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/**
		 * 实现了从配置文件读数据加载
		 */
		Properties props = new Properties();
		try
		{
			props.load(Observer.class.getClassLoader().getResourceAsStream("org/usc/designpattern/observer/observers.properties"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		props.getProperty("observers");
		System.out.println(props.getProperty("observers"));
		String[] observers = props.getProperty("observers").split(",");
		for(String s:observers)
		{
			try
			{
				System.out.println(Class.forName(s).newInstance());
			} catch (InstantiationException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
