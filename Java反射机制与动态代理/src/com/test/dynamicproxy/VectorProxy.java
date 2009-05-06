package com.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler
{
	private Object proxyobj;

	public VectorProxy(Object obj)
	{
		proxyobj = obj;
	}

	public static Object factory(Object obj)
	{
		Class<?> cls = obj.getClass();

		return Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), new VectorProxy(obj));
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		System.out.println("before calling " + method);

		if (args != null)
		{
			for (int i = 0; i < args.length; i++)
			{
				System.out.println(args[i] + "");
			}
		}
		Object object = method.invoke(proxyobj, args);

		System.out.println("after calling " + method);
		return object;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		List<String> v = (List<String>) factory(new Vector<String>(10));

		v.add("New");
		v.add("York");
		System.out.println(v);
		System.out.println(v.getClass());
		/*
		 * An invocation of the hashCode, equals, or toString methods declared in java.lang.Object on 
		 * a proxy instance will be encoded and dispatched to the invocation handler's invoke method in 
		 * the same manner as interface method invocations are encoded and dispatched, as described above. 
		 * The declaring class of the Method object passed to invoke will be java.lang.Object. Other public 
		 * methods of a proxy instance inherited from java.lang.Object are not overridden by a proxy class, 
		 * so invocations of those methods behave like they do for instances of java.lang.Object.
		 * */
		
		
		

		v.remove(0);
		System.out.println(v);
	}
}
