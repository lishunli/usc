package org.usc.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import sun.misc.Cleaner;

/**
 * 聊天的服务器端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class ChatServer
{
	public static final int TCP_PORT = 8888;
	boolean started = false;
	ServerSocket ss = null;

	List<Client> clients = new ArrayList<Client>();
	
	public static void main(String[] args)
	{
		new ChatServer().start();
	}

	public void start()
	{
		try
		{
			ss = new ServerSocket(TCP_PORT);
			started = true;
		} catch (SocketException e)
		{
			System.out.println("端口正在使用...");
			System.out.println("请关掉服务器程序，并重启服务器！");
			System.exit(0);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			while (started)
			{
				Socket s = ss.accept();
				Client c = new Client(s);

				new Thread(c).start();
				clients.add(c);

				System.out.println("A Client Connected!");

			}

		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (ss != null)
			{
				try
				{
					ss.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				ss = null;
			}
		}
	}

	class Client implements Runnable
	{
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;
		
		public Client(Socket s)
		{
			this.s = s;
			try
			{
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public void send(String str)
		{
			try
			{
				dos.writeUTF(str);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		@Override
		public void run()
		{
			try
			{
				while (bConnected)
				{
					String str = dis.readUTF();
					System.out.println(str);
					for (int i = 0; i < clients.size(); i++)
					{
						Client c = clients.get(i);
						c.send(str);
					}
				}
			} catch (EOFException e)
			{
				System.out.println("Client Closed!");
			}

			catch (IOException e)
			{
				e.printStackTrace();
			} finally
			{
				try
				{
					if (dis != null)
					{
						dis.close();
						dis = null;
					}
					if(dos != null)
					{
						dos.close();
						dos = null;
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

}
