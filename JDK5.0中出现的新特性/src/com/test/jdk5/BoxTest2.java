package com.test.jdk5;

public class BoxTest2
{
	public static void main(String[] args)
	{
		
		//Intege范围在 -128 ~ 127 内的话比较原始数据的值，超过范围的话比较Integer
		//第一种情况下就比较值，第二种情况比较对象（对象的地址）
//		Integer i1 = 100;
//		Integer i2 = 100;
//
//		if (i1 == i2)
//			System.out.println("i1 == i2");
//		else
//			System.out.println("i1 != i2");

		Integer i1 = 200;
		Integer i2 = 200;
		
		if (i1 == i2)
			System.out.println("i1 == i2");
		else
			System.out.println("i1 != i2");

	}
}
