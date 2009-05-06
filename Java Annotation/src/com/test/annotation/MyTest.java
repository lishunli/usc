package com.test.annotation;

@MyAnnotation(hello = "beijing", world = "shanghai")
public class MyTest
{
	@MyAnnotation(hello = "beijing", world = "shanghai")
	@Deprecated
	@SuppressWarnings("unchecked")
	public void output()
	{
		System.out.println("output something");
	}
}
