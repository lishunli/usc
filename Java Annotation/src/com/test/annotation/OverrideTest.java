package com.test.annotation;

public class OverrideTest
{
	//����Override�ᱣ֤ȷ�еظ�д�˸���ķ�������Ȼ�ᱨ��
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
