package com.bjsxt.dp.proxy;

public class Tank2 extends Tank
{
	@Override
	public void move()
	{
		long start = System.currentTimeMillis();
		super.move();
		long end = System.currentTimeMillis();
		System.out.println("Time is used :"+(end - start));
	}
}
