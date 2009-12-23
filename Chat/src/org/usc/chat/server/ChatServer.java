package org.usc.chat.server;

import java.io.DataInputStream;
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
		boolean started = false;
		try
		{
			ServerSocket ss = new ServerSocket(TCP_PORT);
			started = true;
			while (started)
			{
				boolean bConnected = false;
				Socket s = ss.accept();
				bConnected = true;
				System.out.println("A Client Connected!");
				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while (bConnected)
				{
					String str = dis.readUTF();
					System.out.println(str);
				}
				dis.close();
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
