package com.usc.proxy;

import java.lang.reflect.Proxy;

public class TestProxy
{
	public static void main(String[] args)
	{
		sayhello say = new sayimpl();
		
		sayProxy saypro = new sayProxy(say);
		
//		Proxy pro = 
		
		sayhello hello = (sayhello)Proxy.newProxyInstance(say.getClass().getClassLoader(), say.getClass().getInterfaces(), saypro);
		
		hello.sayhello("mz");
		
	}
}
