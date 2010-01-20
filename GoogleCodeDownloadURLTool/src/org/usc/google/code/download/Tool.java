/*
 * Tool.java
 *
 * Created on __DATE__, __TIME__
 */

package org.usc.google.code.download;

import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 
 * @author __USER__
 */
public class Tool extends javax.swing.JFrame
{

	/** Creates new form Tool */
	public Tool()
	{
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		button3 = new java.awt.Button();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		复制到剪贴板 = new javax.swing.JButton();
		jTextField2 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		复制到剪贴板1 = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		filedialog_load=new FileDialog(this,"打开文件对话框",FileDialog.LOAD); 
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Google Code\u4e0b\u8f7d\u5730\u5740\u83b7\u53d6\u5668");
		setResizable(false);
		
		
		button3.setLabel("\u4e0a\u4f20\u6587\u4ef6\u5e76\u83b7\u53d6\u4e0b\u8f7d\u5730\u5740");
		button3.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				button3MouseClicked(evt);
			}
		});

		jLabel1.setText("\u5b8c\u6574\u6587\u4ef6\u540d");

		jButton1.setText("\u83b7\u53d6");
		jButton1.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButton1ActionPerformed(evt);
			}
		});

		复制到剪贴板.setText("jButton2");

		jTextField2.setText("jTextField2");

		jLabel2.setText("jLabel2");

		jLabel3.setText("jLabel3");

		复制到剪贴板1.setText("jButton2");

		jEditorPane1.setContentType("text/html");
		jEditorPane1.setEditable(false);
		jEditorPane1.setText("<html><body><a href=http://www.baidu.com>baidu</a></body></html>");
		jEditorPane1.addHyperlinkListener(new javax.swing.event.HyperlinkListener()
		{
			public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt)
			{
				jEditorPane1HyperlinkUpdate(evt);
			}
		});
		jScrollPane3.setViewportView(jEditorPane1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addGroup(
												layout.createSequentialGroup().addContainerGap().addComponent(jLabel2))).addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jTextField2,
												javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
												.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)).addGap(17, 17, 17))
								.addGroup(
										layout.createSequentialGroup().addContainerGap().addComponent(jLabel3).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane3,
												javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
								127, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(
								layout.createSequentialGroup().addGap(14, 14, 14).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(复制到剪贴板1,
												javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(复制到剪贴板,
												javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))).addGap(119, 119, 119))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(299, Short.MAX_VALUE).addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(334, 334, 334)).addGroup(
						layout.createSequentialGroup().addGap(127, 127, 127).addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(360, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(24, 24, 24).addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jTextField1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton1)).addGap(25, 25, 25).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(复制到剪贴板).addComponent(jTextField2,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2)).addGap(24, 24, 24).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel3).addComponent(复制到剪贴板1).addGroup(
								layout.createSequentialGroup().addGap(9, 9, 9).addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))).addContainerGap(166, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void button3MouseClicked(java.awt.event.MouseEvent evt)
	{
		filedialog_load.setVisible(true);
		System.out.println(filedialog_load.getFile());


	}

	private void jEditorPane1HyperlinkUpdate(javax.swing.event.HyperlinkEvent evt)
	{
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
	{
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[])
	{
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new Tool().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private java.awt.Button button3;
	private javax.swing.JButton jButton1;
	private javax.swing.JEditorPane jEditorPane1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JButton 复制到剪贴板;
	private javax.swing.JButton 复制到剪贴板1;
	private FileDialog filedialog_load;

	// End of variables declaration//GEN-END:variables

	/**
	 * 字符串URL编码
	 * 
	 * @param filename
	 *            文件名
	 * @return URL编码后的文件名
	 */
	private static String stringToURL(String filename)
	{
		String retVal = null;
		try
		{
			retVal = URLEncoder.encode(filename, "UTF-8");// URL编码，GBK 到 UTF-8格式
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return retVal;
	}

	/**
	 * 获取Google Code 下载地址
	 * 
	 * @param filename
	 *            文件名
	 * @return Google Code 下载地址
	 */
	private static String googleCodeDownLoadURL(String filename)
	{
		final String prefixURL = "http://usc.googlecode.com/files/";// 前缀
		String retVal = prefixURL + stringToURL(filename);// Google Code 下载地址
		return retVal;
	}

	/**
	 * 复制到剪贴板
	 * 
	 * @param String
	 *            需要复制的文本
	 */
	public static void copy(String str)
	{
		StringSelection stsel = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
	}

}