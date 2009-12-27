package org.usc.tankwar.client;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * net客户端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class NetClient
{
	TankClient tc;
	private static int UDP_PORT_START = 2223;
	
	private int udpPort;
	DatagramSocket ds = null;

	public NetClient(TankClient tc)
	{
		udpPort = UDP_PORT_START++;
		this.tc = tc;
		try
		{
			ds = new DatagramSocket(udpPort);
		} catch (SocketException e)
		{
			e.printStackTrace();
		}
	}

	public void conncet(String IP, int port)
	{
		Socket s = null;

		try
		{
			s = new Socket(IP, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(udpPort);

			DataInputStream dis = new DataInputStream(s.getInputStream());
			int id = dis.readInt();
			tc.tank.id = id;
			System.out.println("Connceted to Server! And Server give me a ID:"
					+ id);

		} catch (UnknownHostException e)
		{
			e.printStackTrace();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		TankNewMsg msg = new TankNewMsg(tc.tank);
		send(msg);
	}

	public void send(TankNewMsg msg)
	{
		msg.send(ds, "127.0.0.1", udpPort);
	}
	

}
