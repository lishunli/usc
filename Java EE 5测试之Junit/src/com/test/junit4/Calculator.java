package com.test.junit4;

/**
 * 数学计算
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
			throw new Exception("除数不能为零！");
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
//		//1.使用命令行的方法进行测试
//		junit.textui.TestRunner.run(CalculatorTest.class);
//		
//		//2.使用界面的方法进行测试
//		junit.swingui.TestRunner.run(CalculatorTest.class);
//		
////		junit.awtui.TestRunner.run(CalculatorTest.class);
//		
//	}
	
	
	

}
