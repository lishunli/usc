package com.usc.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.usc.thread.CheatReader;
import com.usc.thread.CheatWriter;

/**
 * 聊天室的客户端程序
 * 
 * @author MZ
 *
 * 2009-10-14下午04:58:03
 */
public class CheatClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("127.0.0.1",8888);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			new CheatReader(dis).start();
			new CheatWriter(dos).start();
			
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
