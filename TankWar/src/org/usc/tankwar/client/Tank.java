package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

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
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	TankClient tankClient;
	private int x;
	private int y;// 坦克的坐标
	private int oldX;
	private int oldY;

	private boolean good;
	private int life=100;
	private BloodBar bar = new BloodBar();

	public int getLife()
	{
		return life;
	}

	public void setLife(int life)
	{
		this.life = life;
	}

	public boolean isGood()
	{
		return good;
	}

	public void setGood(boolean good)
	{
		this.good = good;
	}

	private boolean live = true;

	private static Random r = new Random();

	public void setLive(boolean live)
	{
		this.live = live;
	}

	public boolean isLive()
	{
		return live;
	}

	private boolean bL = false;
	private boolean bU = false;
	private boolean bR = false;
	private boolean bD = false;

	enum Direction
	{
		L, LU, U, RU, R, RD, D, LD, STOP;
	}

	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.D;// 炮筒
	private int step = r.nextInt(12) + 3;

	public Tank(int x, int y, boolean good)
	{
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
		this.good = good;
	}

	public Tank(int x, int y, boolean good, Direction dir, TankClient tankClient)
	{
		this(x, y, good);
		this.tankClient = tankClient;
		this.dir = dir;
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
		if (!live)
		{
			if (!good)
			{
				tankClient.tanks.remove(this);
			}
			return;
		}
		Color c = g.getColor();// 获得当前颜色
		if (good)
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLUE);
		// g.setColor(Color.RED);// 设置颜色
		g.fillOval(x, y, WIDTH, HEIGHT);// 使用当前颜色填充外接指定矩形框的椭圆
		g.setColor(c);// 恢复颜色
		
		if(good)bar.draw(g);

		switch (ptDir)
		{
		case L:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x, this.y + Tank.HEIGHT / 2);
			break;
		case LU:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x, this.y);
			break;
		case U:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x + Tank.WIDTH / 2, this.y);
			break;
		case RU:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x + Tank.WIDTH, this.y);
			break;
		case R:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x + Tank.WIDTH, this.y + Tank.HEIGHT / 2);
			break;
		case RD:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x + Tank.WIDTH, this.y + Tank.HEIGHT);
			break;
		case D:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT);
			break;
		case LD:
			g.drawLine(this.x + Tank.WIDTH / 2, this.y + Tank.HEIGHT / 2,
					this.x, this.y + Tank.HEIGHT);
			break;

		default:
			break;
		}

		move();

	}

	void move()
	{
		this.oldX = x;
		this.oldY = y;

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
		if (this.dir != Direction.STOP)
		{
			this.ptDir = this.dir;
		}

		if (x < 0)
			x = 0;
		if (y < 30)
			y = 30;
		if (x + Tank.WIDTH > TankClient.GAME_WINDTH)
			x = TankClient.GAME_WINDTH - Tank.WIDTH;
		if (y + Tank.HEIGHT > TankClient.GAME_HEIGHT)
			y = TankClient.GAME_HEIGHT - Tank.HEIGHT;

		if (!good)
		{
			Direction[] dirs = Direction.values();
			if (step == 0)
			{
				step = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);
				dir = dirs[rn];
			}
			step--;
			if (r.nextInt(40) > 38)
				this.fire();
		}

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

	/**
	 * 键盘按下监听
	 * 
	 * @param e
	 */

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();// 获得key码
		switch (key)
		{
		case KeyEvent.VK_CONTROL:// Ctrl
			fire();
			break;
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
		case KeyEvent.VK_A:
			superFire();
			break;
		default:
			break;
		}
		locateDirection();
	}

	public Missile fire()
	{
		if (!live)
			return null;
		Missile missile = new Missile(this.x + Tank.WIDTH / 2 - Missile.WIDTH
				/ 2, this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2, good,
				ptDir, this.tankClient);
		tankClient.missiles.add(missile);
		return missile;

	}
	public Missile fire(Direction dir)
	{
		if (!live)
			return null;
		Missile missile = new Missile(this.x + Tank.WIDTH / 2 - Missile.WIDTH
				/ 2, this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2, good,
				dir, this.tankClient);
		tankClient.missiles.add(missile);
		return missile;

	}

	public Rectangle getRect()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean collidesWiteWall(Wall w)
	{
		if (this.live && this.getRect().intersects(w.getRect()))
		{
			this.stay();
			return true;
		}
		return false;
	}

	private void stay()
	{
		x = oldX;
		y = oldY;
	}

	public boolean collidesWithTanks(List<Tank> tanks)
	{
		for (int i = 0; i < tanks.size(); i++)
		{
			Tank t = tanks.get(i);
			if (this != t)
				if (this.live && t.isLive()
						&& this.getRect().intersects(t.getRect()))
				{
					this.stay();
					t.stay();
					return true;
				}
		}
		return false;
	}
	
	private void superFire()
	{
		Direction[] dirs = Direction.values();
		for (int i = 0; i <8; i++)
		{
			fire(dirs[i]);
		}
	}
	
	
	private class BloodBar
	{
		public void draw(Graphics g)
		{
			Color c = g.getColor();
			
			g.setColor(Color.RED);
			g.drawRect(x, y-10, WIDTH, 10);
			int w = WIDTH * life /100;
			g.fillRect(x, y-10, w, 10);
			
			g.setColor(c);
			
		}
	}
	
}
