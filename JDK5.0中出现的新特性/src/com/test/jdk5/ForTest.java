package com.test.jdk5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class ForTest
{
	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4, 5 };

		/**
		 * 新式写法
		 */
		for (int element : arr)
		{
			System.out.println(element);
		}

		System.out.println();

		/**
		 * 旧式写法
		 */
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}

		String[] names = { "hello", "world", "welcome" };

		for (String name : names)
		{
			System.out.println(name);
		}

		/**
		 * 数组本身就是对象
		 */
		int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		for (int[] row : arr2)
		{
			for (int element : row)
			{
				System.out.println(element);
			}
		}

		Collection<String> collection = new ArrayList<String>();
		collection.add("one");
		collection.add("two");
		collection.add("three");
		
		for(String str : collection)
		{
			System.out.println(str);
		}
		
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		
		for(int i = 0 ; i < list.size() ; i++)
		{
			System.out.println(list.get(i));
		}
		
		for(Iterator i = list.iterator(); i.hasNext();)
		{
			System.out.println(i.next());
		}
		
		for(String str : list)
		{
			System.out.println(str);
		}
		
		
	}
}
