package com.test.jdk5;

public class ShowEnum2
{
	public static void main(String[] args)
	{
		for (OpConstant c : OpConstant.values())
		{
			System.out.printf("%d, %s %n", c.ordinal(), c);//类似C语言的printf，%n是回车换行
		}
	}
}
