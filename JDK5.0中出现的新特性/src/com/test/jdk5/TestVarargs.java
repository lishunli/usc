package com.test.jdk5;


//可变参数

public class TestVarargs
{
	//注意，可变参数必须是方法声明中的最后一个参数 
	private static int sum(String a ,int... nums)//可变参数一定是参数声明的最后的一个
	{
		System.out.println(a);
		
		int sum = 0;
		for (int num : nums)
		{
			sum += num;
		}
		return sum;
	}

	public static void main(String[] args)
	{
		int sum = 0 ;
		sum = sum("hello",1,2,3,4,5,6);
		System.out.println(sum);
	}

}
