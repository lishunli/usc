package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 爆炸类
 * 
 * @author ShunLi
 * @Time 2009-12-18
 */
public class Explode
{
	int x, y;
	private boolean live = true;

	int[] diameter =
	{ 4, 7, 12, 18, 26, 32, 49, 30, 14, 6 };
	int step = 0;

	private TankClient tc;

	public Explode(int x, int y, TankClient tc)
	{
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

	public void draw(Graphics g)
	{
		if (!live)
		{
			tc.explodes.remove(this);
			return;
		}

		if (step == diameter.length)
		{
			live = false;
			step = 0;
			return;
		}

		Color c = g.getColor();// 获得当前颜色
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step], diameter[step]);
		step++;

		g.setColor(c);// 恢复颜色
	}
}
