package com.usc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class sayProxy implements InvocationHandler
{
	private Object obj;

	public sayProxy(Object obj)
	{
		this.obj = obj;
	}

	public Object invoke(Object arg0, Method method, Object[] arg2)
			throws Throwable
	{
		System.out.println("��ʼ���ñ�������ķ���" + method);

		method.invoke(obj, arg2);

		System.out.println("�������ñ�������ķ���" + method);

		return null;
	}

}
