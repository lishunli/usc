package com.test.annotation;


public @interface AnnotationTest
{
	EnumTest value1() default EnumTest.Hello;
	String[] value2();
}

enum EnumTest
{
	Hello, World, Welcome;
}
