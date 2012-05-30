package cn.jayslong.weibo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import SQLite.Callback;
import SQLite.Database;
import SQLite.Exception;

public class FileOutput implements Runnable
{
	static Database db = new Database();
	static String format = "TXT";
	static boolean reverse = false;
	static FileOutputStream fw;
	static BufferedWriter bw;
	static int rowCount;
	String userId = TheFrame.getJTextField2().getText();

	String tableName = TheFrame.getJCheckBox1().isSelected() ? TheFrame.getJTextField6().getText() : userId.contains("@") ? userId.substring(0, userId.indexOf("@")) : userId;

	// String tableName = Controller.dbPath.substring(Controller.dbPath.lastIndexOf("\\")+1, Controller.dbPath.lastIndexOf("."));
	String strDisplay = "select * from '" + tableName + "'";

	// public static void main(String[] args)
	// {
	// System.out.println(System.getProperties().get("java.library.path"));
	// }

	public boolean checkTable()
	{
		connectDB();
		try
		{
			excute(strDisplay, null);
		} catch (Exception e)
		{
			if (e.getMessage().contains("no such table"))
			{
				Log.log("找不到当前帐号的导出数据");
			} else
			{
				Log.log("读取数据库发生未知错误", e);
			}
			return false;
		}
		return true;
	}

	public static void countRows() throws Exception
	{
		FileOutput s = new FileOutput();
		s.connectDB();
		s.excute("select MAX(id) from '" + s.tableName + "'", new CountFmt());
	}

	public static void getRemotePaths() throws Exception
	{
		FileOutput s = new FileOutput();
		s.connectDB();
		s.excute("select image from '" + s.tableName + "'", new ImageFmt());
	}

	// public static void main(String[] args) throws Exception
	// {
	// FileOutput s = new FileOutput();
	// s.connectDB();
	// // s.excute(strCreate, null);
	// // s.excute(strInsert, null);
	// s.excute("select MAX(id) from "+s.tableName, new CountFmt());
	// System.out.println(s.tableName);
	// }

	public void excute(String sql, Callback callback) throws Exception
	{
		try
		{
			db.exec(sql, callback);
		} catch (SQLite.Exception e)
		{
			throw e;
		} catch (java.lang.Exception e)
		{
			e.printStackTrace();
		}
	}

	public void connectDB()
	{
		try
		{
			db.open(Controller.dbPath, 0666);
		} catch (Exception e)
		{
			Log.log("数据库文件打开失败,无法读取数据库", e);
		}
	}

	public void showOptions()
	{
		JPanel jp1 = TheFrame.getJPanel1();
		JPanel jp2 = TheFrame.getJPanel2();
		jp1.setVisible(false);
		jp2.setVisible(true);
	}

	public static void startOutput()
	{
		Thread t = new Thread(new FileOutput());
		t.start();
	}

	@Override
	public void run()
	{
		Log2.log("读取数据库...");
		connectDB();
		if (reverse)
		{
			strDisplay = strDisplay + " order by time";
		}
		try
		{
			excute(strDisplay, (Callback) (Class.forName("cn.jayslong.weibo." + format + "Fmt").newInstance()));
		} catch (Exception e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		TheFrame.getJComboBox1().setEnabled(true);
		TheFrame.getJButton5().setEnabled(true);
		TheFrame.getJButton6().setEnabled(true);
		TheFrame.getDownImageButton().setEnabled(true);
		try
		{
			fw.close();
			bw.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		Log2.log("导出成功!");
		JOptionPane.showMessageDialog(null, "导出成功!");

		// 尝试打开文件夹
		try
		{
			Process process = Runtime.getRuntime().exec("cmd /c start " + new File("").getAbsolutePath());
			process.waitFor();
		} catch (java.lang.Exception e)
		{
			e.printStackTrace();
		}
	}

}

class PrintFmt implements Callback
{

	public void columns(String[] cols)
	{
		System.out.println("columns: ");
		for (int i = 0; i < cols.length; i++)
		{
			System.out.println(cols[i]);
		}
		System.out.println();
	}

	public boolean newrow(String[] cols)
	{
		System.out.println("newrow: ");
		for (int i = 0; i < cols.length; i++)
		{
			System.out.println(cols[i]);
		}
		System.out.println();
		return false;
	}

	public void types(String[] cols)
	{
		System.out.println("types: ");
		for (int i = 0; i < cols.length; i++)
		{
			System.out.println(cols[i]);
		}
		System.out.println();
	}

}

class CountFmt implements Callback
{

	public void columns(String[] cols)
	{
	}

	public boolean newrow(String[] cols)
	{
		FileOutput.rowCount = Integer.valueOf(cols[0].trim());
		return false;
	}

	public void types(String[] cols)
	{
	}

}

class ImageFmt implements Callback
{

	public void columns(String[] cols)
	{
	}

	public boolean newrow(String[] cols)
	{
		if (cols[0] != null && cols[0].trim().length() > 0 && !cols[0].trim().equals("null"))
		{
			DownloadImages.addPath(cols[0]);
		}
		return false;
	}

	public void types(String[] cols)
	{
	}

}

class TXTFmt implements Callback
{
	String[] columns = null;
	String userId = TheFrame.getJTextField2().getText();
	String tableName = TheFrame.getJCheckBox1().isSelected() ? TheFrame.getJTextField6().getText() : userId.contains("@") ? userId.substring(0, userId.indexOf("@")) : userId;
	File file = new File(tableName + ".txt");

	TXTFmt() throws IOException
	{
		FileOutput.fw = new FileOutputStream(file);
		FileOutput.bw = new BufferedWriter(new OutputStreamWriter(FileOutput.fw, "UTF-8"));
	}

	public void columns(String[] cols)
	{
		Log2.log("开始导出" + tableName + "的消息到\n" + file.getAbsolutePath());
	}

	public boolean newrow(String[] cols)
	{
		try
		{
			for (int i = 0; i < cols.length; i++)
			{

				if (cols[i] == null || cols[i].equals("null"))
				{
					continue;
				}
				if (i == 2 && cols[2] != null && !cols[2].equals("null"))
				{
					FileOutput.bw.write("转发理由: ");
				} else if (i == 3 && cols[3] != null && !cols[3].equals("null"))
				{
					FileOutput.bw.write("包含图片: ");
				} else if (i == 5)
				{
					FileOutput.bw.write("来自");
				}
				FileOutput.bw.write(cols[i]);
				FileOutput.bw.newLine();
			}
			FileOutput.bw.write("--------------------------------------");
			FileOutput.bw.newLine();
			FileOutput.bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public void types(String[] cols)
	{
	}
}

class CSVFmt implements Callback
{

	String[] columns = null;
	String userId = TheFrame.getJTextField2().getText();
	String tableName = TheFrame.getJCheckBox1().isSelected() ? TheFrame.getJTextField6().getText() : userId.contains("@") ? userId.substring(0, userId.indexOf("@")) : userId;
	File file = new File(tableName + ".csv");

	CSVFmt() throws IOException
	{
		FileOutput.fw = new FileOutputStream(file);
		FileOutput.bw = new BufferedWriter(new OutputStreamWriter(FileOutput.fw, "GBK"));
	}

	public void columns(String[] cols)
	{
		Log2.log("开始导出" + tableName + "的消息到\n" + file.getAbsolutePath());
		this.columns = cols;
		try
		{
			FileOutput.bw.write("编号,消息内容,转发理由,包含图片,发表时间,来自\n");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public boolean newrow(String[] cols)
	{
		// System.out.println("newrow: ");
		try
		{
			for (int i = 0; i < cols.length; i++)
			{
				if (i < cols.length - 1)
				{
					FileOutput.bw.write("\"" + cols[i] + "\",");
				} else
				{
					FileOutput.bw.write("\"" + cols[i] + "\"\n");
					// bw.newLine();
				}
			}
			FileOutput.bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public void types(String[] cols)
	{
	}

}

class HTMLFmt implements Callback
{
	String userId = TheFrame.getJTextField2().getText();
	String tableName = TheFrame.getJCheckBox1().isSelected() ? TheFrame.getJTextField6().getText() : userId.contains("@") ? userId.substring(0, userId.indexOf("@")) : userId;
	File file = new File(tableName + ".html");
	int count = 0;
	String[] cols;
	int limit;

	HTMLFmt() throws IOException
	{
		FileOutput.fw = new FileOutputStream(file);
		FileOutput.bw = new BufferedWriter(new OutputStreamWriter(FileOutput.fw, "UTF-8"));
	}

	public void columns(String[] cols)
	{
		Log2.log("开始导出" + tableName + "的消息到\n" + file.getAbsolutePath());
		limit = Integer.valueOf(TheFrame.getJTextField5().getText());
		try
		{
			FileOutput.countRows();
			FileOutput.bw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body> ");

		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean newrow(String[] cols)
	{
		try
		{
			writeFile(cols);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		count++;
		return false;
	}

	public void types(String[] cols)
	{
	}

	private void writeFile(String[] cols) throws IOException
	{
		if (count > 1 && count % limit == 0)
		{
			File file = new File(tableName + "(" + count / limit + ").html");
			FileOutput.fw = new FileOutputStream(file);
			FileOutput.bw = new BufferedWriter(new OutputStreamWriter(FileOutput.fw, "UTF-8"));
			try
			{
				FileOutput.countRows();
				FileOutput.bw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body> ");

			} catch (IOException e)
			{
				e.printStackTrace();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		String str3 = "", str2 = "";
		if (cols[2] != null && cols[2].trim().length() > 0 && !cols[2].trim().equals("null"))
		{
			str2 = cols[2] + "<br />";
		}
		// 插入图片部分
		if (cols[3] != null && cols[3].trim().length() > 0 && !cols[3].trim().equals("null"))
		{

			// 截取文件名
			String fileName = "";
			if (cols[3].contains("="))
			{
				fileName = cols[3].substring(cols[3].lastIndexOf("=") + 1);
			} else
			{
				fileName = cols[3].substring(cols[3].lastIndexOf("/") + 1);
			}

			// 查重复图片
			File outFile = null;

			if (fileName.contains("."))
			{
				outFile = new File("微博图片/" + tableName + "/" + fileName);
				if (outFile.exists())
				{
					cols[3] = "微博图片/" + tableName + "/" + fileName;
				}
			} else
			{
				outFile = new File("微博图片/" + tableName + "/" + fileName.concat(".jpg"));
				if (outFile.exists())
				{
					cols[3] = "微博图片/" + tableName + "/" + fileName.concat(".jpg");
				}

				outFile = new File("微博图片/" + tableName + "/" + fileName.concat(".gif"));
				if (outFile.exists())
				{
					cols[3] = "微博图片/" + tableName + "/" + fileName.concat(".gif");
				}
			}
			str3 = "<image src=" + cols[3] + " /><br />";

		}

		try
		{
			FileOutput.bw.write("<p><span>" + cols[0] + " </span>" + cols[1] + "<br />" + str2 + str3 + "<span>" + cols[4] + " </span><span>来自" + cols[5] + " </span></p><hr />");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			FileOutput.bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		if ((count + 1) == FileOutput.rowCount || ((count + 1) > 0 && (count + 1) % limit == 0))
		{
			try
			{
				if (FileOutput.rowCount <= limit)
				{
					FileOutput.bw.write("</body></html>");
				} else if (count / limit == 0 && FileOutput.rowCount >= limit)
				{
					FileOutput.bw.write("<a href=\"" + tableName + "(" + (count / limit + 1) + ").html\">下一页</a></body></html>");
				} else if (count / limit - 1 == 0 && (count + 1) % limit > 0) {
					FileOutput.bw.write("<a href=\"" + tableName + ".html\">上一页</a></body></html>");
				} else if (count / limit - 1 == 0)
				{
					FileOutput.bw.write("<a href=\"" + tableName + ".html\">上一页</a><a href=\"" + tableName + "(" + (count / limit + 1) + ").html\">下一页</a></body></html>");
				} else if ((count + 1) % limit > 0)
				{
					FileOutput.bw.write("<a href=\"" + tableName + "(" + (count / limit - 1) + ").html\">上一页</a></body></html>");
				} else
				{
					FileOutput.bw.write("<a href=\"" + tableName + "(" + (count / limit - 1) + ").html\">上一页</a><a href=\"" + tableName + "(" + (count / limit + 1) + ").html\">下一页</a></body></html>");
				}

				FileOutput.bw.flush();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}

class XMLFmt implements Callback
{
	String[] columns = null;
	String userId = TheFrame.getJTextField2().getText();
	String tableName = TheFrame.getJCheckBox1().isSelected() ? TheFrame.getJTextField6().getText() : userId.contains("@") ? userId.substring(0, userId.indexOf("@")) : userId;
	File file = new File(tableName + ".xml");

	XMLFmt() throws IOException
	{
		FileOutput.fw = new FileOutputStream(file);
		FileOutput.bw = new BufferedWriter(new OutputStreamWriter(FileOutput.fw, "UTF-8"));
	}

	public void columns(String[] cols)
	{
		Log2.log("开始导出" + tableName + "的消息到\n" + file.getAbsolutePath());

		try
		{
			FileOutput.bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			FileOutput.bw.newLine();
			FileOutput.bw.write("<backup>");
			FileOutput.bw.newLine();
			FileOutput.countRows();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean newrow(String[] cols)
	{
		try
		{

			FileOutput.bw.write("\t<item>");
			FileOutput.bw.newLine();
			FileOutput.bw.write("\t\t<id>" + cols[0] + "</id>");
			FileOutput.bw.newLine();
			FileOutput.bw.write("\t\t<body>" + cols[1] + "</body>");
			FileOutput.bw.newLine();
			if (cols[2] != null && cols[2].trim().length() > 0 && !cols[2].trim().equals("null"))
			{
				FileOutput.bw.write("\t\t<rt>" + cols[2] + "</rt>");
				FileOutput.bw.newLine();
			}
			if (cols[3] != null && cols[3].trim().length() > 0 && !cols[3].trim().equals("null"))
			{
				FileOutput.bw.write("\t\t<image>" + cols[3] + "</image>");
				FileOutput.bw.newLine();
			}
			FileOutput.bw.write("\t\t<datetime>" + cols[4] + "</datetime>");
			FileOutput.bw.newLine();
			FileOutput.bw.write("\t\t<method>" + cols[5] + "</method>");
			FileOutput.bw.newLine();

			FileOutput.bw.write("\t</item>");
			FileOutput.bw.newLine();

			int count = Integer.valueOf(cols[0]);

			if ((!FileOutput.reverse && count == FileOutput.rowCount) || (FileOutput.reverse && count == 1))
			{
				FileOutput.bw.write("</backup>");
				FileOutput.bw.newLine();
			}

			FileOutput.bw.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public void types(String[] cols)
	{
	}

}
