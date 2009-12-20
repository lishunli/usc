package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * 墙
 * 
 * @author ShunLi
 * @Time 2009-12-18
 */
public class Wall
{
	int x,y,w,h;
	
	TankClient tc ;

	public Wall(int x, int y, int w, int h, TankClient tc)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, w, h);
		g.setColor(c);
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(x,y,w,h);
	}
	
	
}
