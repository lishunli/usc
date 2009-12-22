package org.usc.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天的服务器端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class ChatServer
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
				
				System.out.println("A Client Connected!");
			}
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
