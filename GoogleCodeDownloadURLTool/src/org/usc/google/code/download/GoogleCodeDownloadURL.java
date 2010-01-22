package org.usc.google.code.download;

import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * Google Code下载地址获取器
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-21<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class GoogleCodeDownloadURL extends javax.swing.JFrame
{

	private static String thunderURL;

	/** Creates new form GoogleCodeDownloadURL */
	public GoogleCodeDownloadURL()
	{
		initComponents();
	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		jDialog1 = new javax.swing.JDialog();
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
		fileDialog = new FileDialog(this, "打开文件对话框", FileDialog.LOAD);

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Google Code\u5730\u5740\u83b7\u53d6\u5668");
		setFont(new java.awt.Font("微软雅黑", 0, 14));

		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setLocation((int) (width - this.getWidth()) / 5, (int) (height - this.getHeight()) / 8);

		jButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton1.setText("\u4e0a\u4f20\u6587\u4ef6\u5e76\u83b7\u53d6\u4e0b\u8f7d\u4fe1\u606f");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton1MouseClicked(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setText("Google Code\u4e0b\u8f7d\u5730\u5740\u83b7\u53d6\u5668");

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("\u987a\u5229\u5236\u4f5cV0.2");

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel3.setText("\u6587  \u4ef6  \u540d\uff1a");

		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel4.setText("\u4e0b\u8f7d\u5730\u5740\uff1a");

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel5.setText("\u4e0b\u8f7d\u4fe1\u606f\uff1a");

		jTextField1.setEditable(false);
		jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 16));

		jButton2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton2.setText("\u590d\u5236\u5230\u526a\u8d34\u677f");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton2MouseClicked(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton3.setText("\u590d\u5236\u5230\u526a\u8d34\u677f");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton3MouseClicked(evt);
			}
		});

		jEditorPane1.setEditable(false);
		jEditorPane1.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jScrollPane1.setViewportView(jEditorPane1);

		jButton4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton4.setText("\u590d\u5236\u5230\u526a\u8d34\u677f");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jButton4MouseClicked(evt);
			}
		});

		jEditorPane2.setEditable(false);
		jEditorPane2.setFont(new java.awt.Font("微软雅黑", 0, 14));
		jScrollPane2.setViewportView(jEditorPane2);

		jEditorPane2.setContentType("text/html");

		// 要能响应网页中的链接，则必须加上超链监听器
		jEditorPane2.addHyperlinkListener(new HyperlinkListener()
		{
			@Override
			// 超链监听器，处理对超级链接的点击事件，但对按钮的点击还捕获不到
			public void hyperlinkUpdate(HyperlinkEvent e)
			{
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
				{
					try
					{
						String command = "explorer.exe "// 如果是记事本打开,可用 notepad.exe
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
				layout.createSequentialGroup().addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap().addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4).addComponent(jLabel3))
										.addGap(10, 10, 10).addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane1,
														javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE).addGroup(
														layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jButton3).addComponent(
														jButton2))).addGroup(layout.createSequentialGroup().addGap(189, 189, 189).addComponent(jLabel1))
								.addGroup(layout.createSequentialGroup().addGap(238, 238, 238).addComponent(jButton1))).addContainerGap()).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(620, Short.MAX_VALUE).addComponent(jLabel2).addGap(31, 31, 31)).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(jLabel5).addGap(10, 10, 10).addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton4).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(7, 7, 7).addComponent(jLabel2).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1).addGap(39, 39, 39).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton2).addComponent(jTextField1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4).addComponent(jButton3).addComponent(
								jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5).addComponent(
								jButton4)).addGap(24, 24, 24)));

		pack();
	}// </editor-fold>

	// GEN-END:initComponents

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt)
	{
		String src = jEditorPane2.getText().trim();
		src = src.replaceAll("\n", "").replaceAll("\\<html>", "").replaceAll("\\</html>", "").replaceAll("\\<head>", "").replaceAll("\\</head>", "")
				.replaceAll("\\<body>", "<br>").replaceAll("\\</body>", "<br>");
		src = src + thunderURL;
		copy(src);
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
		jTextField1.setText(fileName.substring(0, fileName.lastIndexOf('.')));
		String googleCodeDownLoadURL = googleCodeDownLoadURL(fileName);
		jEditorPane1.setText(googleCodeDownLoadURL);
		// jEditorPane1

		jEditorPane2.setText("<html><body>顺利提供下载<br>文&nbsp;件&nbsp;名：" + fileName + "<br>下载地址：" + googleCodeDownLoadURL + "<br><a href=" + googleCodeDownLoadURL
				+ ">普通下载&nbsp;" + fileName + "</body></html>");

		thunderURL = "<script src=\"http://pstatic.xunlei.com/js/webThunderDetect.js\"></script>\n<script src=\"http://pstatic.xunlei.com/js/base64.js\"></script>\n<script language=\"javascript\">\nvar thunder_url = \""
				+ googleCodeDownLoadURL
				+ "\";\nvar thunder_pid = \"57029\";\nvar restitle = \"\";\ndocument.write('<a href=\"#\" thunderHref=\"' + ThunderEncode(thunder_url) + '\" thunderPid=\"' + thunder_pid + '\" thunderResTitle=\"' + restitle + '\" onClick=\"return OnDownloadClick_Simple(this,2,4)\" oncontextmenu=\"ThunderNetwork_SetHref(this)\">"
				+ "\u8fc5\u96f7\u4e13\u7528\u9ad8\u901f\u4e0b\u8f7d&nbsp;" + fileName + "</a> ');\n</script><br>";
	}

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
		/*
		 * # 用来标志特定的文档位置 %23 % 对特殊字符进行编码 %25 & 分隔不同的变量值对 %26 + 在变量值中表示空格 %2B \ 表示目录路径 %2F = 用来连接键和值 %3D ? 表示查询字符串的开始 %3F
		 */

		retVal = retVal.replaceAll("\\+", "%20");
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
	private javax.swing.JDialog jDialog1;
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