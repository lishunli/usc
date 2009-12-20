package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Map<String , Image> imgs  = new HashMap<String, Image>();
	private static Image[] tankImages = null;
	
	static
	{
		tankImages = new Image[]
		{
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileL.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileLU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileRU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileR.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileRD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/missileLD.gif"))
		};
		
		imgs.put("L", tankImages[0]);
		imgs.put("LU", tankImages[1]);
		imgs.put("U", tankImages[2]);
		imgs.put("RU", tankImages[3]);
		imgs.put("R", tankImages[4]);
		imgs.put("RD", tankImages[5]);
		imgs.put("D", tankImages[6]);
		imgs.put("LD", tankImages[7]);
				
	}
	
	
	public boolean isLive()
	{
		return live;
	}

	public Missile(int x, int y, boolean good, Direction direction,
			TankClient tc)
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
		if (!isLive())
		{
			tc.missiles.remove(this);
			return;
		}

//		Color c = g.getColor();// 获得当前颜色
//		if (good)
//			g.setColor(Color.RED);
//		else
//			g.setColor(Color.BLACK);// 设置颜色
//		g.fillOval(x, y, WIDTH, HEIGHT);// 使用当前颜色填充外接指定矩形框的椭圆
//		g.setColor(c);// 恢复颜色
		
		switch (direction)
		{
		case L:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x, this.y + Tank.HEIGHT / 2);
			g.drawImage(imgs.get("L"), x, y, null);
			break;
		case LU:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x, this.y);
			g.drawImage(imgs.get("LU"), x, y, null);
			break;
		case U:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x + Tank.WIDTH / 2, this.y);
			g.drawImage(imgs.get("U"), x, y, null);
			break;
		case RU:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x + Tank.WIDTH, this.y);
			g.drawImage(imgs.get("RU"), x, y, null);
			break;
		case R:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x + Tank.WIDTH, this.y + Tank.HEIGHT / 2);
			g.drawImage(imgs.get("R"), x, y, null);
			break;
		case RD:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x + Tank.WIDTH, this.y + Tank.HEIGHT);
			g.drawImage(imgs.get("RD"), x, y, null);
			break;
		case D:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT);
			g.drawImage(imgs.get("D"), x, y, null);
			break;
		case LD:
//			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
//					this.x, this.y + Tank.HEIGHT);
			g.drawImage(imgs.get("LD"), x, y, null);
			break;

		default:
			break;
		}
		
		
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
			// tc.missiles.remove(this);
		}
	}

	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean hitTank(Tank t)
	{
		if (this.live && this.getRect().intersects(t.getRect()) && t.isLive()
				&& this.good != t.isGood())
		{
			if (t.isGood())
			{
				t.setLife(t.getLife() - 20);
				if (t.getLife() <= 0)
					t.setLive(false);
			} else
			{
				t.setLive(false);
			}

			// t.setLive(false);

			this.live = false;// 打掉坦克后，子弹也消失

			Explode e = new Explode(x, y, tc);
			tc.explodes.add(e);

			return true;
		}

		return false;
	}

	public boolean hitTanks(List<Tank> tanks)
	{
		for (int i = 0; i < tanks.size(); i++)
		{
			if (hitTank(tanks.get(i)))
			{
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall w)
	{
		if (this.live && this.getRect().intersects(w.getRect()))
		{
			this.live = false;
			return true;
		}
		return false;
	}
}
