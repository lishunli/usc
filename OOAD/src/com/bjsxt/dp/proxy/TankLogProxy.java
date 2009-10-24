package com.bjsxt.dp.proxy;


public class TankLogProxy implements Moveable
{
	Moveable t;
	
	public TankLogProxy(Moveable t)
	{
		super();
		this.t = t;
	}

	@Override
	public void move()
	{
		System.out.println("Tank Start...");
		t.move();
		System.out.println("Tank end...");
	}
	
}
