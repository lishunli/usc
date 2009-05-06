package com.test.annotation;

import java.lang.annotation.Inherited;


//@InheritedTest("langsin")
public class Parent
{
	@InheritedTest("langsin")
	public void doSomething()
	{
		System.out.println("hello");
	}
}
