package com.test.annotation;

public class DocumentedTest
{
	/**
	 * This is the comments that I have added
	 */
	@DocumentedAnnotation(hello = "welcome")
	public void method()
	{
		System.out.println("hello world");
	}
}
