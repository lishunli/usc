/**
 * 
 */
package com.test.jdk5;

/**
 * @author Administrator
 * 
 */
public class Generic2<T>
{
	private T[] fooArray;//数组类型

	public void setFooArray(T[] fooArray)
	{
		this.fooArray = fooArray;
	}

	public T[] getFooArray()
	{
		return fooArray;
	}

	public static void main(String[] args)
	{
		String[] strs = { "hello", "world", "welcome" };
		String[] strs2 = null;
		Generic2<String> foo = new Generic2<String>();

		foo.setFooArray(strs);
		strs2 = foo.getFooArray();

		for (int i = 0; i < strs2.length; i++)
		{
			System.out.println(strs2[i]);
		}

	}
}
