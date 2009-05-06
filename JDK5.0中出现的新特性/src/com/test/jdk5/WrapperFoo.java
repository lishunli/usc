package com.test.jdk5;

public class WrapperFoo<T>
{
	private GenericFoo3<T> foo;

	public void setFoo(GenericFoo3<T> foo)
	{
		this.foo = foo;
	}

	public GenericFoo3<T> getFoo()
	{
		return foo;
	}

	public static void main(String[] args)
	{
		
		GenericFoo3<Integer> foo = new GenericFoo3<Integer>();
		foo.setFoo(new Integer(10));

		WrapperFoo<Integer> wrapper = new WrapperFoo<Integer>();
		wrapper.setFoo(foo);

	}
}

class GenericFoo3<T>
{
	private T foo;

	public T getFoo()
	{
		return foo;
	}

	public void setFoo(T foo)
	{
		this.foo = foo;
	}	
}
