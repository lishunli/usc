package com.test.jdk5;

public class GenericFoo<T>
{
	private T foo;

	public void setFoo(T foo)
	{
		this.foo = foo;
	}

	public T getFoo()
	{
		return foo;
	}

	public static void main(String[] args)
	{
		GenericFoo<Boolean> foo1 = new GenericFoo<Boolean>();
		GenericFoo<Integer> foo2 = new GenericFoo<Integer>();

		foo1.setFoo(new Boolean(true));
		Boolean b = foo1.getFoo();//没有强制类型转换

		foo2.setFoo(new Integer(10));
		Integer i = foo2.getFoo();

		GenericFoo foo5 = new GenericFoo();

		 foo5.setFoo("hello world");
//		 Integer str = (Integer)foo5.getFoo();
		 String str = (String)foo5.getFoo();
		 System.out.println(str);

		/**
		 * 如果使用泛型类別，但声明时不指定类型呢？ 那么预设会使用Object，不过需要自己进行类型转换了，
		 * 但编译器会发出警告，告诉您这可能是不安全的操作
		 * 
		 */
//		 GenericFoo a = new GenericFoo();
//		 a.setFoo("aa");
//		 foo1与foo2不是同一个类型了，不能进行赋值
//		 foo1 = foo2;
	}
}
