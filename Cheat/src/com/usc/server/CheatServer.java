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
 * �����ҳ���ķ�������
 *
 *@author MZ
 *
 * 2009-10-14����04:39:27
 */
public class CheatServer
{

	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(8888);//��������
			Socket s = ss.accept();//�ȴ�����
			
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
