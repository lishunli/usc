package org.usc.tankwar.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 坦克的服务器端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class TankServer
{
	private static int ID = 100;
	public static final int TCP_PORT = 8888;

	List<Client> clients = new ArrayList<Client>();

	public void start()
	{
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(TCP_PORT);

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		while (true)
		{
			Socket s = null;

			try
			{
				s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String IP = s.getInetAddress().getHostAddress();
				int udpPort = dis.readInt();
				Client c = new Client(IP, udpPort);
				clients.add(c);
				
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				dos.writeInt(ID++);

				s.close();

				System.out.println("A Client Connect! Addr:"
						+ s.getInetAddress() + ":" + s.getPort()+"udpPort :"+udpPort);

			} catch (IOException e)
			{
				e.printStackTrace();
			} finally
			{
				if (s != null)

					try
					{
						s.close();
						s = null;
					} catch (IOException e)
					{
						e.printStackTrace();
					}

			}

		}

	}

	public static void main(String[] args)
	{
		new TankServer().start();
	}

	private class Client
	{
		String IP;
		int udpPort;

		public Client(String ip, int udpPort)
		{
			this.IP = ip;
			this.udpPort = udpPort;
		}
	}
}
