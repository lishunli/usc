package cn.jayslong.weibo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.httpclient.methods.GetMethod;

import SQLite.Exception;

public class DownloadImages implements Runnable
{

	private static ArrayList<String> imagePaths = new ArrayList<String>();
	private static int threadCount = 0;
	private static int pathIndex = 0;
	String userId = TheFrame.getJTextField2().getText();
	String tableName = TheFrame.getJCheckBox1().isSelected() ? TheFrame.getJTextField6().getText() : userId.contains("@") ? userId.substring(0, userId.indexOf("@")) : userId;

	@Override
	public void run()
	{
		System.out.println("图片下载线程: " + Thread.currentThread().getName() + " 启动!");
		threadCount++;
		String path = null;
		int index = 0;
		try
		{
			while ((path = imagePaths.get((index = getOnePathNum()))) != null)
			{

				downloadOnePic(path, index);
			}
		} catch (IndexOutOfBoundsException e)
		{// 指针越界说明没有任务了.
		}
		System.out.println("图片下载线程: " + Thread.currentThread().getName() + " 退出!");
		threadCount--;
	}

	public void startDownload()
	{
		Thread t = new Thread(new ImageDownloadController());
		t.start();
	}

	class ImageDownloadController implements Runnable
	{
		public void run()
		{

			// 取得全部图片地址列表保存在imagePaths
			getImagePaths();

			boolean noPic = false;

			// 启动下载线程
			if (imagePaths.size() > 0)
			{
				Log2.log("总共需要下载" + imagePaths.size() + "张图片...");
				for (int i = 0; i < imagePaths.size() && i < 5; i++)
				{
					Thread t = new Thread(new DownloadImages());
					t.start();
				}
			} else
			{
				JOptionPane.showMessageDialog(null, "没有找到可以下载的图片地址!");
				noPic = true;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			while (threadCount > 0)
			{
				try
				{
					Thread.sleep(300);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			if (!noPic)
			{
				JOptionPane.showMessageDialog(null, "全部图片下载完成! 请重新导出HTML即可浏览本地图片! ");
				Log2.log("全部" + imagePaths.size() + "张图片下载完成! 请重新导出HTML即可浏览本地图片! ");
			} else
			{
				Log2.log("没有找到可以下载的图片地址! ");
			}
			TheFrame.getJComboBox1().setEnabled(true);
			TheFrame.getJButton5().setEnabled(true);
			TheFrame.getJButton6().setEnabled(true);
			TheFrame.getDownImageButton().setEnabled(true);
			pathIndex = 0;
			imagePaths.clear();
		}
	}

	private static synchronized int getOnePathNum()
	{
		return pathIndex++;
	}

	private void downloadOnePic(String path, int index)
	{

		Log2.log("正在下载第" + (index + 1) + "张图片...");
		LoadPage lp = new LoadPage();

		// 截取文件名
		String fileName = "";
		if (path.contains("="))
		{
			fileName = path.substring(path.lastIndexOf("=") + 1);
		} else
		{
			fileName = path.substring(path.lastIndexOf("/") + 1);
		}
		// 创建文件夹
		if (!new File("微博图片/" + tableName).exists())
		{
			new File("微博图片/" + tableName).mkdirs();
		}

		// 查重复图片
		File outFile = null;

		if (fileName.contains("."))
		{
			outFile = new File("微博图片/" + tableName + "/" + fileName);

			if (outFile.exists())
			{
				Log2.log("图片: " + fileName + " 已存在! ");
				return;
			}
		} else
		{
			outFile = new File("微博图片/" + tableName + "/" + fileName.concat(".jpg"));

			if (outFile.exists())
			{
				Log2.log("图片: " + fileName.concat(".jpg") + " 已存在! ");
				return;
			}

			outFile = new File("微博图片/" + tableName + "/" + fileName.concat(".gif"));

			if (outFile.exists())
			{
				Log2.log("图片: " + fileName.concat(".gif") + " 已存在! ");
				return;
			}
		}

		// 下载部分多次重试
		int retryCounter = 0;
		while (retryCounter < 5)
		{
			try
			{
				GetMethod getMethod = lp.getGetMethod(path);
				String imageReadPath = (String) lp.getPageObject(path, getMethod, "path");
				System.out.println(imageReadPath);// TODO
				fileName = imageReadPath.substring(imageReadPath.lastIndexOf("/") + 1);
				if (!fileName.contains("."))
				{
					fileName = fileName.concat(".jpg");
				}
				outFile = new File("微博图片/" + tableName + "/" + fileName);
				OutputStream os = new FileOutputStream(outFile);
				os.write((byte[]) (lp.getPageObject(path, getMethod, "body")));
				os.close();
				Log2.log("第" + (index + 1) + "张图片下载完成!");
				return;
			} catch (java.lang.Exception e)
			{
				retryCounter++;
				Log2.log("下载图片: " + path + " 失败! 自动重试第" + retryCounter + "次");
				e.printStackTrace();
				if (retryCounter >= 5)
				{
					Log2.log("图片: " + path + " 失败多次,放弃下载!");
					break;
				}
			}
		}
	}

	private void getImagePaths()
	{
		try
		{
			FileOutput.getRemotePaths();
		} catch (Exception e)
		{
			Log2.log("获取图片本地地址出错!", e);
			e.printStackTrace();
		}
	}

	public static void addPath(String path)
	{
		imagePaths.add(path);
	}

	public static void main(String[] args)
	{
		System.out.println(new File("").getAbsolutePath());
	}
}
