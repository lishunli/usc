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
	public static void GlobalInit()//���Զ����ݿ�����ʹ��
	{
//		System.out.println("GlobalInit invoked");
	}
	
	@AfterClass
	public static void Globaldestory()
	{
//		System.out.println("Globaldestroy invoked");
	}
	
	
	@Test
	public void testAdd()//��û�����JUnit3.8������ʽ
	{

		
		int result = cal.add(1,2);
		
		//����: assert
		assertEquals(4,result);
	}
	
	@Test
//	@Ignore
	public void testMinus()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.minus(1,2);
		
		//����
		
		assertEquals(-1,result);
	}
	
	@Test
//	@Ignore
	public void testMultiply()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.multiply(2,3);
		
		//����
		
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
			
			Assert.fail();//���Բ����׳��쳣���������ִ��������Ļ����϶��ǲ���ʧ��
		}
		
		//����
		
		Assert.assertEquals(1,result);
	}
	
	@Test(expected=Exception.class)
	public void testDivide2() throws Exception
	{

		cal.divide(1, 0);
	}
	//����ķ��������������׳��쳣����������Ӧ���쳣���ͣ����û���쳣�Ļ������Բ��ɹ�
	
	
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
//		//����Ĳ��Ա��׳�Exception�ö���
//		
//		
//	}
//	
	
	
	
}
