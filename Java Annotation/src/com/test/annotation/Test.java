package com.test.annotation;

import java.lang.reflect.Method;



public class Test
{
	public static void main(String[] args) throws Exception
	{
//		Class<Parent> c = Parent.class;
//		Class <Child> c=Child.class;	
//		if(c.isAnnotationPresent(InheritedTest.class))
//		{
//			InheritedTest inheritedTest = c.getAnnotation(InheritedTest.class);
//			
//			String value = inheritedTest.value();
//			System.out.println(value);
//		}
		
		
		Class <Child> c=Child.class;	
		Method method=c.getMethod("doSomething", new Class[]{});
		if(method.isAnnotationPresent(InheritedTest.class))
		{
			InheritedTest inheritedTest = method.getAnnotation(InheritedTest.class);
			
			String value = inheritedTest.value();
			System.out.println(value);
		}
		
		
		
	}
}
