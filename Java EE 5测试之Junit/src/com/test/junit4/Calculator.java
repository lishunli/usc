package com.test.junit4;

/**
 * ��ѧ����
 */

public class Calculator
{
	public int add(int a, int b)
	{
		return a + b;
	}

	public int minus(int a, int b)
	{
		return a - b;
	}

	public int multiply(int a, int b)
	{
		return a * b;
	}

	public int divide(int a, int b) throws Exception
	{
		if(0 == b)
		{
			throw new Exception("��������Ϊ�㣡");
		}
		
		return a / b;
	}
	
	
	public  void ExceptionDemo()
	{
		 throw new ArithmeticException("ExceptionDemo");
	}
	
//	public int divide(int a, int b) 
//	{
//		return a / b;
//	}
	
//	public static void main(String[] args)
//	{
//		//1.ʹ�������еķ������в���
//		junit.textui.TestRunner.run(CalculatorTest.class);
//		
//		//2.ʹ�ý���ķ������в���
//		junit.swingui.TestRunner.run(CalculatorTest.class);
//		
////		junit.awtui.TestRunner.run(CalculatorTest.class);
//		
//	}
	
	
	

}
