package com.test.junit3;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * 在junit3.8中测试类必须要继承TestCase父类
 * 
 * keep the bar green to keep the code clean(robust)
 * 
 * 单元测试不是证明您是对的，而是证明您没有错误
 */
public class CalculatorTest extends TestCase
{
	/**
	 * 在junit3.8中，测试方法满足如下原则
	 * 1）public的
	 * 2）void的
	 * 3）无方法参数
	 * 4）方法名称必须以test开头
	 * 5）Don't repeat youself
	 */
	
//	protected void setUp() throws Exception{};
	
	
	/*在测试方法都先执行setUp方法
	 * 
	 * 所以可以进行一些提取代码的操作
	 * 
	 * 算是可以进行一些初始化操作（数据库连接等）
	 * */
	
	private Calculator cal=null;
	
	public void setUp()
	{
//		System.out.println("hello world");
		
		cal = new Calculator();//每次测试每个方法时都是不同的对象
		
	}
	
//	@Override
//	protected void tearDown() throws Exception
//	{
//		// TODO Auto-generated method stub
//		super.tearDown();
//	}
	
	/*每次测试方法结束后都执行下面的代码tearDown()
	 * 
	 * 在JUnit3.8不存在在所有的测试方法前和后时都执行一个方法但在JUnit4.0里有
	 * 
	 * */
	public void tearDown()
	{
//		System.out.println("木子");
	}
	
	public void testAdd()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.add(1,2);
		
		//断言: assert
		
		Assert.assertEquals(3,result);
//		Assert.assertEquals(4,result);
	}
	
	public void testMinus()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.minus(1,2);
		
		//断言
		
		Assert.assertEquals(-1,result);
	}
	
	public void testMultiply()
	{
//		Calculator cal = new Calculator();
		
		int result = cal.multiply(2,3);
		
		//断言
		
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
			
			Assert.fail();//断言不会抛出异常，所以如果执行这句代码的话，肯定是测试失败
		}
		
		//断言
		
		Assert.assertEquals(1,result);
	}
	
	public void testDivide2()
	{
		
		Throwable tx = null;
		
		try
		{
//			Calculator cal = new Calculator();
			
			cal.divide(4,0);
			
			//出现异常后不可能再执行下面的语句，如果执行下面的语句的话表明测试失败，加上Assert.fail();
			
//			System.out.println("hello");
			
			Assert.fail();
			
		}
		catch(Exception ex)
		{
			tx = ex;
		}
		
		Assert.assertNotNull(tx);//存在异常
		
		Assert.assertEquals(Exception.class,tx.getClass());//异常为Exception
		
		Assert.assertEquals("除数不能为零！",tx.getMessage());//异常信息为“除数不能为零！”
	}
	
}
