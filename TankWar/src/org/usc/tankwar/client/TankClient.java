package org.usc.tankwar.client;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

	int x =50,y=50;
	@Override
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		y +=5;

	}

	public void lanchFrame()
	{
		this.setTitle("坦克大战");// 设置窗体名称
		this.setLocation(400, 300);// 设置位置
		this.setSize(800, 600);// 设置窗体大小
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
		this.setVisible(true);// 设置窗体可见
		
		new Thread(new PaintThread()).start();//启动线程
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
			while(true)
			{
				repaint();//父类的repaint的方法，调用类
				try
				{
					Thread.sleep(50);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
