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
		// �����������
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
		// ʹ��XFire�ķ��񹤳�,���ɴ���ʵ��
		String helloWorldURL = "http://localhost:8080/WebService/services/Hello";
		// ָ������ĵ�ַ
		try
		{
			IHello srvc = (IHello) factory.create(srvcModel, helloWorldURL);
			String result = srvc.example("�ҵĵ�һ�����Գ���");
			// �������
			System.out.print(result);
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}

	}

}
