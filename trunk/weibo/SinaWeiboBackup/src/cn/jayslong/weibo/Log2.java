package cn.jayslong.weibo;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Log2
{
	static JScrollPane jsp = TheFrame.getJScrollPane1();
	static JTextArea jta = TheFrame.getJTextArea2();
	static int dcCount = 0;

	public static void log(String msg, Exception e)
	{
		appendLine(msg);

		// for (int i = 0; i < e.getStackTrace().length; i++)
		// {
		// appendLine(""+e.getStackTrace()[i]);
		// }
		appendLine(e.getMessage());
		e.printStackTrace();
	}

	public static void log(String msg)
	{
		appendLine(msg);
	}

	private static synchronized void appendLine(String str)
	{
		jta.append(str + "\n");
		jta.setCaretPosition(jta.getDocument().getLength());

		dcCount++;
		if (dcCount >= 1000)
		{
			jta.setText("");
			dcCount = 0;
		}

		jsp.repaint();
	}

}