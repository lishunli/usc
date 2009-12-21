package org.usc.tankwar.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 坦克的服务器端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class TankServer
{
	public static final int TCP_PORT = 8888;
	
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(TCP_PORT);
			
			while(true)
			{
				Socket s = ss.accept();
				System.out.println("A Client Connect! Addr:"+s.getInetAddress()+":"+s.getPort());
			}
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
