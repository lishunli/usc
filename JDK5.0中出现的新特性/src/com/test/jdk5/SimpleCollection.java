package com.test.jdk5;

public class SimpleCollection<T>
{
	private T[] objArr;

	private int index = 0;

	@SuppressWarnings("unchecked")
	public SimpleCollection()
	{
		objArr = (T[]) new Object[10]; // 预设10个对象空间
	}

	@SuppressWarnings("unchecked")
	public SimpleCollection(int capacity)
	{
		objArr = (T[]) new Object[capacity];
	}

	public void add(T t)
	{
		objArr[index] = t;
		index++;
	}

	public int getLength()
	{
		return index;
	}

	public T get(int i)
	{
		return  objArr[i];
	}

	public static void main(String[] args)
	{
		SimpleCollection<Integer> c = new SimpleCollection<Integer>();
		for (int i = 0; i < 10; i++)
		{
			c.add(new Integer(i));
		}
		for (int i = 0; i < 10; i++)
		{
			Integer k = c.get(i);
			System.out.println(k);
		}
		
		SimpleCollection<Integer> c1 = new SimpleCollection<Integer>(15);
		for (int i = 0; i < 15; i++)
		{
			c1.add(new Integer(i));
		}
		for (int i = 0; i < c1.getLength(); i++)
		{
			Integer k = c1.get(i);
			System.out.println(k);
		}
		
		
	}

}
