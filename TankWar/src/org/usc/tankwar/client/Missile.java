package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;

import org.usc.tankwar.client.Tank.Direction;

/**
 * 子弹类
 * 
 * @author ShunLi
 * @Time 2009-12-6
 */
public class Missile
{
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;//子弹的速度
	int x;
	int y;
	Tank.Direction direction;
	public Missile(int x, int y, Direction direction)
	{
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public void draw(Graphics g)
	{
		Color c = g.getColor();// 获得当前颜色
		g.setColor(Color.BLACK);// 设置颜色
		g.fillOval(x, y, 10, 10);// 使用当前颜色填充外接指定矩形框的椭圆
		g.setColor(c);// 恢复颜色
		move();
	}
	private void move()
	{
		switch (direction)
		{
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U:
			y -= YSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		
		default:
			break;
		}
	}
	
}
