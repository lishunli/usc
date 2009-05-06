package com.test.jdk5;

//jdk1.4以前读对类似泛型的处理
public class ObjectFoo
{
	private Object foo;

	public void setFoo(Object foo)
	{
		this.foo = foo;
	}

	public Object getFoo()
	{
		return foo;
	}

	public static void main(String[] args)
	{
		ObjectFoo foo1 = new ObjectFoo();
		ObjectFoo foo2 = new ObjectFoo();

		foo1.setFoo(new Boolean(true));
		// 类型转换
		Boolean b = (Boolean) foo1.getFoo();

		// 类型转换
		foo2.setFoo(new Integer(10));
		Integer i = (Integer) foo2.getFoo();

//		ObjectFoo foo3 = new ObjectFoo();
//		foo3.setFoo(new Boolean(true));
//		String s = (String) foo1.getFoo();//错误的转换类型

	}
}
