package com.test.junit4;

public class Largest
{
	public int getLargest(int[] array) throws Exception
	{
//		if (null == array || 0 == array.length)//˳�������ж�����Ϊ�պ����ж������Ȳ�Ϊ0
//		{
//			throw new Exception("���鲻��Ϊ�ջ��߳��Ȳ���Ϊ0��");
//		}
		
		
		if (null == array)//˳�������ж�����Ϊ�պ����ж������Ȳ�Ϊ0
		{
			throw new Exception("���鲻��Ϊ�գ�");
		}
		else if(0 == array.length)
		{
			throw new Exception("���鳤�Ȳ���Ϊ0��");
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
