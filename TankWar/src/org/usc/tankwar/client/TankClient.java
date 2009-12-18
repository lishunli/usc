package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

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

	Tank tank = new Tank(50,50,true,this);//坦克
	Tank enemyTank  = new Tank(150,150,false,this);//坦克
	
	
	Explode e = new Explode(70,70,this);
	
	
	List<Missile> missiles = new ArrayList<Missile>();//子弹
	List<Explode> explodes = new ArrayList<Explode>();
	
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
		gOffScreen.setColor(Color.GREEN);

		gOffScreen.fillRect(0, 0, GAME_WINDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);// 画背景图片上
		g.drawImage(offScreenImage, 0, 0, null);

	}

	@Override
	public void paint(Graphics g)
	{
		g.drawString("missiles count:"+missiles.size(), 10, 50);
		g.drawString("explodes count:"+explodes.size(), 10, 70);
		
		for(int i=0;i<missiles.size();i++)
		{
			Missile missile = missiles.get(i);
			
			missile.hitTank(enemyTank);
			
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
		
		tank.draw(g);//调用坦克的draw方法
		enemyTank.draw(g);
		
	}

	public void lanchFrame()
	{
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
