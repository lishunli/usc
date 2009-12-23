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

		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		try
		{
			ss = new ServerSocket(TCP_PORT);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			started = true;
			while (started)
			{
				boolean bConnected = false;
				s = ss.accept();
				bConnected = true;
				System.out.println("A Client Connected!");

				dis = new DataInputStream(s.getInputStream());
				while (bConnected)
				{
					String str = dis.readUTF();
					System.out.println(str);
				}
			}

		} catch (Exception e)
		{
			System.out.println("Client Closed!");
			// e.printStackTrace();
		} finally
		{
			try
			{
				if (dis != null)
				{
					dis.close();
					dis = null;
				}
				if (s != null)
				{
					s.close();
					s = null;
				}
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}

	}
}
