package com.test.jdk5;


//�ɱ����

public class TestVarargs
{
	//ע�⣬�ɱ���������Ƿ��������е����һ������ 
	private static int sum(String a ,int... nums)//�ɱ����һ���ǲ�������������һ��
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
