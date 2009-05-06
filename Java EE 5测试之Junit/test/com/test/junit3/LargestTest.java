package com.test.junit3;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LargestTest extends TestCase
{
	private Largest largest;

	public void setUp()
	{
		largest = new Largest();
	}

	public void testGetLargest()
	{
		int[] array = { 1, 9, 10, -20, 23 };

		int result = 0;

		try
		{
			result = largest.getLargest(array);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			Assert.fail();
		}

		Assert.assertEquals(23, result);
	}
	


	public void testGetLargest2()
	{
		Throwable tx = null;

		int[] array = {};//数组长度为0

		try
		{
			largest.getLargest(array);
			
			Assert.fail();
		}
		catch (Exception ex)
		{
//			ex.printStackTrace();

			tx = ex;
		}

		Assert.assertNotNull(tx);

		Assert.assertEquals(Exception.class, tx.getClass());

		Assert.assertEquals("数组长度不能为0！", tx.getMessage());
	}
	
	public void testGetLargest3()
	{
		Throwable tx = null;//空数组
		
		try
		{
			int[] array = null;
			
			largest.getLargest(array);
			
			Assert.fail();
		}
		catch(Exception ex)
		{
//			ex.printStackTrace();
			
			tx = ex;
		}
		
		Assert.assertNotNull(tx);
		
		Assert.assertEquals(Exception.class,tx.getClass());
		
		Assert.assertEquals("数组不能为空！", tx.getMessage());
	}
	

}
