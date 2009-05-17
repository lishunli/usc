package com.test;

import java.net.MalformedURLException;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.hello.IHello;

public class Test
{

	public static void main(String[] args)
	{
		Service srvcModel = new ObjectServiceFactory().create(IHello.class);
		// 创建服务对象
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
		// 使用XFire的服务工厂,生成创建实例
		String helloWorldURL = "http://localhost:8080/WebService/services/Hello";
		// 指定服务的地址
		try
		{
			IHello srvc = (IHello) factory.create(srvcModel, helloWorldURL);
			String result = srvc.example("我的第一个测试程序");
			// 输入参数
			System.out.print(result);
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

	}

}
