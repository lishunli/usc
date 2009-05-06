package com.test.JUnit4;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest
{
	private Calculator cal;
	
	@Before
	public void init()
	{
		cal = new Calculator();
		
//		System.out.println("init invoked");
	}
	
	
	@After
	public void destroy()
	{
//		System.out.println("destroy invoked");
	}

	@BeforeClass
	public static void GlobalInit()//可以对数据库连接使用
	{
//		System.out.println("GlobalInit invoked");
	}
	
	@AfterClass
	public static void Globaldestory()
	{
//		System.out.println("Globaldestroy invoked");
	}
	
	
	@Test
	public void testAdd()//最好还是以JUnit3.8命名方式
	{

		
		int result = cal.add(1,2);
		
		//断言: assert
		assertEquals(4,result);
	}
	
	@Test
//	@Ignore
	public void testMinus()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.minus(1,2);
		
		//断言
		
		assertEquals(-1,result);
	}
	
	@Test
//	@Ignore
	public void testMultiply()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.multiply(2,3);
		
		//断言
		
		assertEquals(6,result);
	}
	
	@Test
	public void testDivide()
	{
//		Calculator cal = new Calculator();
		
		int result = 0;
		
		try
		{
			result = cal.divide(6,4);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			Assert.fail();//断言不会抛出异常，所以如果执行这句代码的话，肯定是测试失败
		}
		
		//断言
		
		Assert.assertEquals(1,result);
	}
	
	@Test(expected=Exception.class)
	public void testDivide2() throws Exception
	{

		cal.divide(1, 0);
	}
	//上面的方法就是期望他抛出异常，而且是相应的异常类型，如果没有异常的话，测试不成功
	
	
	@Test(timeout = 100)//100ms
	public void testDivid3()
	{
		try
		{
			cal.divide(4, 2);
//			Thread.sleep(110);
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
//	
//	@Test(expected = ArithmeticException.class)
//	public void testExceptionDemo()
//	{
//		cal.ExceptionDemo();
//		//上面的测试比抛出Exception好多了
//		
//		
//	}
//	
	
	
	
}
