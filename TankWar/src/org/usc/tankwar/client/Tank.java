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
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	int x;
	int y;// 坦克的坐标

	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	enum Direction
	{
		L, LU, U, RU, R, RD, D, LD, STOP;
	}

	private Direction dir = Direction.STOP;

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
	 * 
	 * @param g
	 */
	public void draw(Graphics g)
	{
		Color c = g.getColor();// 获得当前颜色
		g.setColor(Color.RED);// 设置颜色
		g.fillOval(x, y, 30, 30);// 使用当前颜色填充外接指定矩形框的椭圆
		g.setColor(c);// 恢复颜色
		move();

	}

	void move()
	{
		switch (dir)
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
		case STOP:
			break;

		default:
			break;
		}
	}

	/**
	 * 键盘监听
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();// 获得key码
		switch (key)
		{

		case KeyEvent.VK_LEFT:
			bL = true;
			break;
		case KeyEvent.VK_UP:
			bU = true;
			break;
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_DOWN:
			bD = true;
			break;
		default:
			break;
		}
		locateDirection();
	}

	void locateDirection()
	{
		if (bL && !bU && !bR && !bD)
			dir = Direction.L;
		else if (bL && bU && !bR && !bD)
			dir = Direction.LU;
		else if (!bL && bU && !bR && !bD)
			dir = Direction.U;
		else if (!bL && bU && bR && !bD)
			dir = Direction.RU;
		else if (!bL && !bU && bR && !bD)
			dir = Direction.R;
		else if (!bL && !bU && bR && bD)
			dir = Direction.RD;
		else if (!bL && !bU && !bR && bD)
			dir = Direction.D;
		else if (bL && !bU && !bR && bD)
			dir = Direction.LD;
		else if (!bL && !bU && !bR && !bD)
			dir = Direction.STOP;
	}
	/**
	 * 键盘按下监听
	 * @param e
	 */

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();// 获得key码
		switch (key)
		{

		case KeyEvent.VK_LEFT:
			bL = false; 
			break;
		case KeyEvent.VK_UP:
			bU = false; 
			break;
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_DOWN:
			bD = false;
			break;
		default:
			break;
		}
		locateDirection();
	}
}
