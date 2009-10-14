package com.usc.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.usc.thread.CheatReader;
import com.usc.thread.CheatWriter;

/**
 * 聊天室程序的服务器端
 *
 *@author MZ
 *
 * 2009-10-14下午04:39:27
 */
public class CheatServer
{

	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(8888);//建立连接
			Socket s = ss.accept();//等待连接
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			new CheatReader(dis).start();
			new CheatWriter(dos).start();
					
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
