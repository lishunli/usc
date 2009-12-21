package org.usc.tankwar.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * net客户端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class NetClient
{
	
	public void conncet(String IP,int port)
	{
		try
		{
			Socket s = new Socket(IP,port);
			System.out.println("Connceted to Server!");
			
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{

	}

}
