package org.usc.chat.client;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 聊天的客户端
 * 
 * @author ShunLi
 * @Time 2009-12-21
 */
public class ChatClient extends Frame
{
	private static final long serialVersionUID = 1L;
	
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	
	public static void main(String[] args)
	{
		new ChatClient().launchFrame();
	}
	
	public void launchFrame()
	{
		this.setTitle("Chat Client");
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(tfTxt,BorderLayout.SOUTH);
		this.add(taContent,BorderLayout.NORTH);
		this.pack();
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		tfTxt.addActionListener(new TFListener());
		this.setVisible(true);
	}
	
	private class TFListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String s = tfTxt.getText().trim().toString();
			
			taContent.setText(s);
			tfTxt.setText("");
		}
	}
	
	
	

}
