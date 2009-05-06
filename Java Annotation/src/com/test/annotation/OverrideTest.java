package com.test.annotation;

public class OverrideTest
{
	//加入Override会保证确切地复写了父类的方法。不然会报错
	@Override
	public String toString()
	{
		return "This is override";
	}

	public static void main(String[] args)
	{
		OverrideTest test = new OverrideTest();

		System.out.println(test.toString());
	}
}
