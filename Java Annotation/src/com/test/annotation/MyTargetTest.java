package com.test.annotation;


public class MyTargetTest
{
	@MyTarget("xyz")
	public void doSomething()
	{
		System.out.println("hello world");
	}
}
