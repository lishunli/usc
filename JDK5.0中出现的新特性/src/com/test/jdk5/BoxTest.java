package com.test.jdk5;

import java.util.ArrayList;
import java.util.Collection;

public class BoxTest
{
	public static void main(String[] args)
	{
		int a = 3;
		Collection<Integer> c = new ArrayList<Integer>();
		//�Զ�װ��
		c.add(a);//c.add(new Interge(3));
		c.add(a + 3);//c.add(new Interge(a+3));
		
		for(Integer i : c)
//		for(int i : c)//�Զ�����
		{
			System.out.println(i);
		}
	} 
}
