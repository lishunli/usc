package com.usc.thread;

import java.io.DataInputStream;
import java.io.IOException;

public class CheatReader extends Thread
{
	private DataInputStream dis;

	public CheatReader(DataInputStream dis)
	{
		super();
		this.dis = dis;
	}

	@Override
	public void run()
	{
		String info;
		try
		{
			while(true)
			{
				info = dis.readUTF();
				System.out.println("对方说： " + info);
				if("bye".equals(info.trim()) || "quit".equals(info.trim()))
				{
					System.out.println("对方已下线，程序关闭");
					dis.close();
					System.exit(0);				
				}
				
			}
		} catch (IOException e)
		{
			//e.printStackTrace();
		}
	}
	
}
