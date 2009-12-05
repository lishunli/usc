package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * 坦克类
 * 
 * @author ShunLi
 * @Time 2009-12-5
 */
public class Tank
{
	int x;
	int y;//坦克的坐标
	public Tank(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	/**
	 * 画坦克
	 * @param g
	 */
	public void draw(Graphics g)
	{
		Color c = g.getColor();// 获得当前颜色
		g.setColor(Color.RED);// 设置颜色
		g.fillOval(x, y, 30, 30);// 使用当前颜色填充外接指定矩形框的椭圆
		g.setColor(c);// 恢复颜色

	}
	/**
	 * 键盘监听
	 * @param e
	 */
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();// 获得key码
		switch (key)
		{

		case KeyEvent.VK_LEFT:
			x -= 5;
			break;
		case KeyEvent.VK_UP:
			y -= 5;
			break;
		case KeyEvent.VK_RIGHT:
			x += 5;
			break;
		case KeyEvent.VK_DOWN:
			y += 5;
			break;
		default:
			break;
		}
	}
}

