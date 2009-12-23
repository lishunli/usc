package org.usc.chat.client;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 聊天的客户端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class ChatClient extends Frame
{
	private static final long serialVersionUID = 1L;
	Socket s = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	private boolean bConnected = false;

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();

	Thread tRecv = new Thread(new RecvThread());

	public static void main(String[] args)
	{
		new ChatClient().launchFrame();
	}

	public void launchFrame()
	{
		this.setTitle("Chat Client");
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				disConncet();
				System.exit(0);
			}
		});
		tfTxt.addActionListener(new TFListener());
		this.setVisible(true);

		connect();

		tRecv.start();
	}

	private void connect()
	{
		try
		{
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			bConnected = true;
			System.out.println("Connected!");

		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void disConncet()
	{
		try
		{
			dos.close();
			dis.close();
			s.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		/*
		 * try { bConnected = false; tRecv.join();// 关闭线程
		 * 
		 * } catch (InterruptedException e) { e.printStackTrace(); } finally {
		 * try { dos.close(); dis.close(); s.close(); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * }
		 */
	}

	private class TFListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String str = tfTxt.getText().trim().toString();
			// taContent.setText(taContent.getText()
			// + ("".equals(taContent.getText()) ? "" : "\n") + str);
			tfTxt.setText("");

			try
			{
				dos.writeUTF(str);
				dos.flush();
				// dos.close();

			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	private class RecvThread implements Runnable
	{

		@Override
		public void run()
		{
			try
			{
				while (bConnected)
				{
					String str = dis.readUTF();
					// System.out.println(str);
					taContent.setText(taContent.getText()
							+ ("".equals(taContent.getText()) ? "" : "\n")
							+ str);
				}
			} catch (SocketException e)
			{
				System.out.println("客户端正在关闭...");
				System.exit(0);
			} 
			catch(EOFException e)
			{
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
