package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 坦克的客户端
 * 
 * @author ShunLi
 * @Time 2009-12-2
 */
public class TankClient extends Frame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int GAME_WINDTH = 800;
	public static final int GAME_HEIGHT = 600;

	Tank tank = new Tank(50,50,true,Direction.STOP,this);//坦克
//	Tank enemyTank  = new Tank(150,150,false,this);//坦克
	
	
	Explode e = new Explode(70,70,this);
	
	Wall w1 = new Wall(100,200,20,150,this);
	Wall w2 = new Wall(300,100,300,20,this);
	
	List<Missile> missiles = new ArrayList<Missile>();//子弹
	List<Explode> explodes = new ArrayList<Explode>();
	List<Tank> tanks = new ArrayList<Tank>();
	
	Blood b = new Blood();
	
	Image offScreenImage = null;// 虚拟的背景图片

	@Override
	public void update(Graphics g)
	{

		if (offScreenImage == null)
		{
			offScreenImage = this.createImage(GAME_WINDTH, GAME_HEIGHT);// 创建一张图片
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		// 设置颜色
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);

		gOffScreen.fillRect(0, 0, GAME_WINDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);// 画背景图片上
		g.drawImage(offScreenImage, 0, 0, null);

	}

	@Override
	public void paint(Graphics g)
	{
		g.drawString("Missiles count:"+missiles.size(), 10, 50);
		g.drawString("Explodes count:"+explodes.size(), 10, 70);
		g.drawString("Tanks count:"+tanks.size(), 10, 90);
		g.drawString("Tanks life:"+tank.getLife(), 10, 110);
		
		int reProduceTankCount=0;
		try
		{
			reProduceTankCount = Integer.parseInt(PropertyMgr.getProperty("reProduceTankCount"));
			
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(tanks.size()<=0)
		{
			for (int i = 0; i < reProduceTankCount; i++)
			{
				tanks.add(new Tank(50+40*(i+1),50,false,Direction.D,this));
			}
		}
		
		for(int i=0;i<missiles.size();i++)
		{
			Missile missile = missiles.get(i);
			
//			missile.hitTank(enemyTank);
			missile.hitTanks(tanks);
			missile.hitTank(tank);
			missile.hitWall(w1);
			missile.hitWall(w2);
			
			missile.draw(g);
			
//			if(!missile.isLive())
//			{
//				missiles.remove(missile);
//			}
//			else
//				missile.draw(g);
		}
//		if(null!=missile) missile.draw(g);
		
		for (int i = 0; i < explodes.size(); i++)
		{
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		for (int i = 0; i < tanks.size(); i++)
		{
			Tank t = tanks.get(i);
			t.collidesWiteWall(w1);
			t.collidesWiteWall(w2);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
		
		tank.draw(g);//调用坦克的draw方法
		tank.eat(b);
//		enemyTank.draw(g);
		w1.draw(g);
		w2.draw(g);
		b.draw(g);
	}

	public void lanchFrame()
	{
		Properties p = new Properties();
		int initTankCount = 0;
		try
		{
			initTankCount = Integer.parseInt(PropertyMgr.getProperty("initTankCount"));
			
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		for (int i = 0; i < initTankCount; i++)
		{
			tanks.add(new Tank(50+40*(i+1),50,false,Direction.D,this));
		}
		
		this.setTitle("坦克大战");// 设置窗体名称
		this.setLocation(400, 300);// 设置位置
		this.setSize(GAME_WINDTH, GAME_HEIGHT);// 设置窗体大小
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

		});// 关闭窗体事件
		this.setResizable(false);// 设置窗体大小不可以变
		this.setBackground(Color.GREEN);// 设置背景颜色

		this.addKeyListener(new KeyMonitor());// 添加键盘监听

		this.setVisible(true);// 设置窗体可见

		new Thread(new PaintThread()).start();// 启动线程
	}

	public static void main(String[] args)
	{
		TankClient tankClient = new TankClient();// 实例化对象
		tankClient.lanchFrame();// 显示窗体
		
	}

	private class PaintThread implements Runnable
	{
		@Override
		public void run()
		{
			while (true)
			{
				repaint();// 父类的repaint的方法，调用类
				try
				{
					Thread.sleep(50);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		}
	}

	private class KeyMonitor extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
			tank.keyPressed(e);//调用坦克的键盘监听方法
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			tank.keyReleased(e);
		}

	}

}
