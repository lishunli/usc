package com.test.jdk5;

public class ShowEnum
{
	public static void main(String[] args)
	{
		// valueOf()方法可以让您将指定的字串尝试转换为枚举类型
		enumCompareTo(OpConstant.valueOf(args[0]));
	}

	public static void enumCompareTo(OpConstant constant)
	{
		System.out.println(constant);
		for (OpConstant c : OpConstant.values())
		{
			System.out.println(constant.compareTo(c));
		}
	}  
}
