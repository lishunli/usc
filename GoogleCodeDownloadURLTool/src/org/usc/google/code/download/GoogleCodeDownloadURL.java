/*
 * GoogleCodeDownloadURL.java
 *
 * Created on __DATE__, __TIME__
 */

package org.usc.google.code.download;

import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

/**
 * 
 * @author __USER__
 */
public class GoogleCodeDownloadURL extends javax.swing.JFrame
{

	/** Creates new form GoogleCodeDownloadURL */
	public GoogleCodeDownloadURL()
	{
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jEditorPane1 = new javax.swing.JEditorPane();
		jButton4 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jEditorPane2 = new javax.swing.JEditorPane();
		fileDialog = new FileDialog(this, "���ļ��Ի���", FileDialog.LOAD);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Google Code\u5730\u5740\u83b7\u53d6\u5668");
		setFont(new java.awt.Font("΢���ź�", 0, 14));

		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation((int) (width - this.getWidth()) / 4, (int) (height - this.getHeight()) / 6);

		jButton1.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton1.setText("\u4e0a\u4f20\u6587\u4ef6\u5e76\u83b7\u53d6\u4e0b\u8f7d\u4fe1\u606f");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton1MouseClicked(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("΢���ź�", 0, 24));
		jLabel1.setText("Google Code\u4e0b\u8f7d\u5730\u5740\u83b7\u53d6\u5668");

		jLabel2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel2.setText("\u987a\u5229\u5236\u4f5cV0.1");

		jLabel3.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel3.setText("\u6587  \u4ef6  \u540d\uff1a");

		jLabel4.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel4.setText("\u4e0b\u8f7d\u5730\u5740\uff1a");

		jLabel5.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jLabel5.setText("\u4e0b\u8f7d\u4fe1\u606f\uff1a");

		jTextField1.setEditable(false);
		jTextField1.setFont(new java.awt.Font("΢���ź�", 0, 16));

		jButton2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton2.setText("\u590d\u5236\u5230\u526a\u8d34\u677f");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton2MouseClicked(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton3.setText("\u590d\u5236\u5230\u526a\u8d34\u677f");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton3MouseClicked(evt);
			}
		});

		jEditorPane1.setEditable(false);
		jEditorPane1.setFont(new java.awt.Font("΢���ź�", 0, 16));
		jScrollPane1.setViewportView(jEditorPane1);

		jButton4.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton4.setText("\u590d\u5236\u5230\u526a\u8d34\u677f");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton4MouseClicked(evt);
			}
		});

		jEditorPane2.setEditable(false);
		jEditorPane2.setFont(new java.awt.Font("΢���ź�", 0, 14));
		jScrollPane2.setViewportView(jEditorPane2);

		jEditorPane2.setContentType("text/html");

		// Ҫ����Ӧ��ҳ�е����ӣ��������ϳ���������
		jEditorPane2.addHyperlinkListener(new HyperlinkListener()
		{
			@Override
			// �����������������Գ������ӵĵ���¼������԰�ť�ĵ�������񲻵�
			public void hyperlinkUpdate(HyperlinkEvent e)
			{
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
				{
					try
					{
						String command = "explorer.exe "// ����Ǽ��±���,���� notepad.exe
								+ e.getURL().toString();
						Runtime.getRuntime().exec(command);
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}

			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
								layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)).addGroup(
								layout.createSequentialGroup().addGap(20, 20, 20)
										.addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
														layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
																layout.createSequentialGroup().addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
																		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
																				layout.createSequentialGroup().addComponent(jLabel5).addGap(12, 12, 12)
																						.addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)).addGroup(
																				layout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
																						jScrollPane1, 0, 0, Short.MAX_VALUE))).addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE).addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton4).addComponent(
														jButton3).addComponent(jButton2)))).addGap(35, 35, 35)).addGroup(
				layout.createSequentialGroup().addGap(189, 189, 189).addComponent(jButton1).addContainerGap(235, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2))
								.addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addComponent(jButton1))).addGap(35, 35, 35).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton2)).addComponent(jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup().addGap(3, 3, 3).addComponent(jButton3)).addComponent(jLabel4).addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(16, 16, 16).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel5).addComponent(jButton4)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(41, 41, 41)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt)
	{
		copy(jEditorPane2.getText());
	}

	private void jButton3MouseClicked(java.awt.event.MouseEvent evt)
	{
		copy(jEditorPane1.getText());
	}

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt)
	{
		copy(jTextField1.getText());
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt)
	{
		fileDialog.setVisible(true);
		String fileName = fileDialog.getFile();
		jTextField1.setText(fileName);
		String googleCodeDownLoadURL = googleCodeDownLoadURL(fileName);
		jEditorPane1.setText(googleCodeDownLoadURL);
		// jEditorPane1

		jEditorPane2.setText("<html><body>�ļ�����" + fileName + "<br>���ص�ַ��" + googleCodeDownLoadURL + "<br>���أ�<a href=" + googleCodeDownLoadURL + ">" + fileName
				+ "</a></body></html>");

	}

	/**
	 * �ַ���URL����
	 * 
	 * @param filename
	 *            �ļ���
	 * @return URL�������ļ���
	 */
	private static String stringToURL(String filename)
	{
		String retVal = null;
		try
		{
			retVal = URLEncoder.encode(filename, "UTF-8");// URL���룬GBK �� UTF-8��ʽ
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		return retVal;
	}

	/**
	 * ��ȡGoogle Code ���ص�ַ
	 * 
	 * @param filename
	 *            �ļ���
	 * @return Google Code ���ص�ַ
	 */
	private static String googleCodeDownLoadURL(String filename)
	{
		final String prefixURL = "http://usc.googlecode.com/files/";// ǰ׺
		String retVal = prefixURL + stringToURL(filename);// Google Code ���ص�ַ
		return retVal;
	}

	/**
	 * ���Ƶ�������
	 * 
	 * @param String
	 *            ��Ҫ���Ƶ��ı�
	 */
	public static void copy(String str)
	{
		StringSelection stsel = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
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
				new GoogleCodeDownloadURL().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JEditorPane jEditorPane1;
	private javax.swing.JEditorPane jEditorPane2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField jTextField1;
	private FileDialog fileDialog;
	// End of variables declaration//GEN-END:variables

}