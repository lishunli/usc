package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 * 子弹类
 * 
 * @author ShunLi
 * @Time 2009-12-6
 */
public class Missile
{
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;// 子弹的速度
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	int x;
	int y;
	Direction direction;

	private boolean live = true;
	private TankClient tc;
	private boolean good;
	
	public boolean isLive()
	{
		return live;
	}

	public Missile(int x, int y, boolean good,Direction direction, TankClient tc)
	{
		this(x, y, direction);
		this.tc = tc;
		this.good = good;
	}

	public Missile(int x, int y, Direction direction)
	{
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void draw(Graphics g)
	{
		if(!isLive())
		{
			tc.missiles.remove(this);
			return;
		}
		
		Color c = g.getColor();// 获得当前颜色
		g.setColor(Color.BLACK);// 设置颜色
		g.fillOval(x, y, WIDTH, HEIGHT);// 使用当前颜色填充外接指定矩形框的椭圆
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

		if (x < 0 || y < 0 || x > TankClient.GAME_WINDTH
				|| y > TankClient.GAME_HEIGHT)
		{
			live = false;
//			tc.missiles.remove(this);
		}
	}

	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean hitTank(Tank t)
	{
		if (this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.isGood())
		{
			if(t.isGood())
			{
				t.setLife(t.getLife()-20);
				if(t.getLife()<=0)t.setLive(false);
			}
			else {
				t.setLive(false);
			}
					
//			t.setLive(false);
			
			this.live = false;//打掉坦克后，子弹也消失
			
			Explode e = new Explode(x,y,tc);
			tc.explodes.add(e);
			
			return true;
		}
			
		return false;
	}
	
	public boolean hitTanks(List<Tank> tanks)
	{
		for (int i = 0; i < tanks.size(); i++)
		{
			if(hitTank(tanks.get(i)))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall w)
	{
		if(this.live && this.getRect().intersects(w.getRect()))
		{
			this.live = false;
			return true;
		}
		return  false;
	}
}
