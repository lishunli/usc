package com.test.annotation;

public class SubDeprecatedTest extends DeprecatedTest
{
	@Override
	public void doSomething()
	{
		System.out.println("do something in sub class");
	}
	
	public static void main(String[] args)
	{
		SubDeprecatedTest sub = new SubDeprecatedTest();
		sub.doSomething();
	}
}
