package com.usc.thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheatWriter extends Thread
{
	private DataOutputStream dos;

	public CheatWriter(DataOutputStream dos)
	{
		super();
		this.dos = dos;
	}

	@Override
	public void run()
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String info;
		try
		{
			while(true)
			{
				info = br.readLine();
				dos.writeUTF(info);
				if("bye".equals(info.trim()) || "quit".equals(info.trim()))
				{
					System.out.println("自己已下线，程序关闭");
					dos.close();
					System.exit(0);				
				}
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	

}
