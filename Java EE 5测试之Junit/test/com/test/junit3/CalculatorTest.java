package com.test.junit3;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * ��junit3.8�в��������Ҫ�̳�TestCase����
 * 
 * keep the bar green to keep the code clean(robust)
 * 
 * ��Ԫ���Բ���֤�����ǶԵģ�����֤����û�д���
 */
public class CalculatorTest extends TestCase
{
	/**
	 * ��junit3.8�У����Է�����������ԭ��
	 * 1��public��
	 * 2��void��
	 * 3���޷�������
	 * 4���������Ʊ�����test��ͷ
	 * 5��Don't repeat youself
	 */
	
//	protected void setUp() throws Exception{};
	
	
	/*�ڲ��Է�������ִ��setUp����
	 * 
	 * ���Կ��Խ���һЩ��ȡ����Ĳ���
	 * 
	 * ���ǿ��Խ���һЩ��ʼ�����������ݿ����ӵȣ�
	 * */
	
	private Calculator cal=null;
	
	public void setUp()
	{
//		System.out.println("hello world");
		
		cal = new Calculator();//ÿ�β���ÿ������ʱ���ǲ�ͬ�Ķ���
		
	}
	
//	@Override
//	protected void tearDown() throws Exception
//	{
//		// TODO Auto-generated method stub
//		super.tearDown();
//	}
	
	/*ÿ�β��Է���������ִ������Ĵ���tearDown()
	 * 
	 * ��JUnit3.8�����������еĲ��Է���ǰ�ͺ�ʱ��ִ��һ����������JUnit4.0����
	 * 
	 * */
	public void tearDown()
	{
//		System.out.println("ľ��");
	}
	
	public void testAdd()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.add(1,2);
		
		//����: assert
		
		Assert.assertEquals(3,result);
//		Assert.assertEquals(4,result);
	}
	
	public void testMinus()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.minus(1,2);
		
		//����
		
		Assert.assertEquals(-1,result);
	}
	
	public void testMultiply()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.multiply(2,3);
		
		//����
		
		Assert.assertEquals(6,result);
	}
	
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
	
	public void testDivide2()
	{
		
		Throwable tx = null;
		
		try
		{
//			Calculator cal = new Calculator();
			
			cal.divide(4,0);
			
			//�����쳣�󲻿�����ִ���������䣬���ִ����������Ļ���������ʧ�ܣ�����Assert.fail();
			
//			System.out.println("hello");
			
			Assert.fail();
			
		}
		catch(Exception ex)
		{
			tx = ex;
		}
		
		Assert.assertNotNull(tx);//�����쳣
		
		Assert.assertEquals(Exception.class,tx.getClass());//�쳣ΪException
		
		Assert.assertEquals("��������Ϊ�㣡",tx.getMessage());//�쳣��ϢΪ����������Ϊ�㣡��
	}
	
}
