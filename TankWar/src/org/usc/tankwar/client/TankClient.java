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

	@Override
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(50, 50, 30, 30);
		g.setColor(c);

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
	}

	public static void main(String[] args)
	{
		TankClient tankClient = new TankClient();// 实例化对象
		tankClient.lanchFrame();// 显示窗体
	}

}
