package com.test.junit4;

public class Largest
{
	public int getLargest(int[] array) throws Exception
	{
//		if (null == array || 0 == array.length)//顺序是先判断它不为空后在判断它长度不为0
//		{
//			throw new Exception("数组不能为空或者长度不能为0！");
//		}
		
		
		if (null == array)//顺序是先判断它不为空后在判断它长度不为0
		{
			throw new Exception("数组不能为空！");
		}
		else if(0 == array.length)
		{
			throw new Exception("数组长度不能为0！");
		}

		
		

		int result = array[0];

		for (int i = 0; i < array.length; ++i)
		{
			if (result < array[i])
			{
				result = array[i];
			}
		}

		return result;
	}
}
