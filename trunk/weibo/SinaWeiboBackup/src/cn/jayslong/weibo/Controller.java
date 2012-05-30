/**
 * @Title: Controller.java
 * @Package cn.jayslong.weibo
 * @Description:
 * @author Aloong
 * @date 2010-11-11 上午02:23:03
 * @version V1.0
 */

package cn.jayslong.weibo;

import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Controller implements Runnable
{

	static Map<Integer, String> PageMap = Collections.synchronizedSortedMap(new TreeMap<Integer, String>());
	static private int doneNum = 1;
	static private int donePage = 1;
	static int threadCount = 0;
	static String dbPath = "weibo.db";
	static String[] info = new String[] {};
	static boolean changedMode = false;
	static boolean changedMode2 = false;
	static boolean changedMode3 = false;
	static boolean friend = false;
	static String friendName = "";
	static String friendUid = "";
	static int lostCount = 0;
	static int imageCount = 0;
	static int reCount = 0;
	static int atCount = 0;
	static long startTime;
	static String date = "2011-9-30";
	static String version = "2.7";
	static String myUid = "1146018874";

	synchronized static int getDownLoadTask()
	{
		if (AnalysePage.pageCount == 0)
		{
			AnalysePage.pageCount = -1;
			return 1;
		}
		if (doneNum <= AnalysePage.pageCount)
		{
			return doneNum++;
		}
		return 0;
	}

	synchronized static int getStoreTask()
	{
		while (donePage <= AnalysePage.pageCount || AnalysePage.pageCount <= 0)
		{
			if (AnalysePage.pageCount == -2)
			{
				break;
			}
			if (PageMap.get(donePage) != null)
			{
				if (AnalysePage.pageCount <= 0)
				{
					AnalysePage.pageCount = -2;
				}
				return donePage++;
			}
		}
		return 0;
	}

	public void startDownload(String[] info)
	{
		Controller.info = info;
		if (TheFrame.getJCheckBox1().isSelected()) {
			friend = true;
			friendName = TheFrame.getJTextField6().getText().trim();
		} else
		{
			friend = false;
		}
		startTime = new Date().getTime();
		Thread t = new Thread(new Controller());
		t.start();
	}

	public void run()
	{
		System.getProperties().put("file.encoding", "UTF8");

		try
		{
			AnalysePage.analysePage(info);
		} catch (InputMismatchException e)
		{
			Log.log("用户名或密码错误,请重试!\n");
			JOptionPane.showMessageDialog(TheFrame.getJPanel1(), "用户名或密码错误,请重试!");
			doClear();
			return;
		} catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(TheFrame.getJPanel1(), "貌似您填错了好友的帐号!");
			doClear();
			return;
		} catch (Exception e) {
			Log.log("网络连接错误.\n", e);
		}

		// 5个线程
		for (int i = 0; i < 5 && i < AnalysePage.pageCount + 1; i++)
		{
			Thread t = new Thread(new DownloadThread());
			t.start();
		}

		Thread t1 = new Thread(new WriteDbThread());
		t1.start();

		do
		{
			try
			{
				Thread.sleep(300);
			} catch (InterruptedException e)
			{
				Log.log("线程睡眠错误.\n", e);
			}
		} while (threadCount != 0);

		// 推消息
		try
		{
			FileOutput.countRows();
		} catch (SQLite.Exception e1)
		{
			e1.printStackTrace();
		}

		if (Controller.friend)
		{
			int result = JOptionPane.showConfirmDialog(null, "是否@" + Controller.friendName + " 告诉他你备份了他了微博?", "提示", JOptionPane.YES_NO_OPTION);
			if (result == 0)
			{
				Post.post("我刚刚使用#微博备份#工具备份了@" + Controller.friendName + " 的" + FileOutput.rowCount + "条微博,可以导出成文本,网页,Excel,XML等多种格式,可以保存全部图片.工具地址: http://sinaurl.cn/h4D3S4 作者@周小伦Aloong " + date + "更新" + version + "版!");
			} else
			{
				Post.post("我刚刚使用#微博备份#工具备份了某个帐号的全部微博,可以导出成文本,网页,Excel,XML等多种格式,可以保存全部图片.工具地址: http://sinaurl.cn/h4D3S4 作者@周小伦Aloong " + date + "更新" + version + "版!");
			}
		} else
		{
			Post.post("我刚刚使用#微博备份#工具备份了我的" + FileOutput.rowCount + "条微博,可以导出成文本,网页,Excel,XML等多种格式,可以保存全部图片.工具地址: http://sinaurl.cn/h4D3S4 作者@周小伦Aloong " + date + "更新" + version + "版!");
		}

		followMe();

		Log.log("任务完成!\n-------------------------------");
		String name = Controller.friend ? ("@" + Controller.friendName + " ") : "您";
		Log.log("小统计★本次任务用时:" + (new Date().getTime() - startTime) / 1000 + "秒\n总共为您备份了" + name + "的" + FileOutput.rowCount + "条微博,其中有:\n(" + atCount + ")条@和(" + reCount + ")条转发!\n还有(" + imageCount + ")条带有图片!\n最后恭喜您,一共有(" + lostCount + ")条微博离奇失踪~\n请点击导出按钮进行导出~");

		doClear();
	}

	private void doClear()
	{
		if (changedMode3)
		{
			LoadPage lp = new LoadPage();
			try
			{
				lp.getPageCode("http://weibo.cn/dpool/ttt/setting.php?st=" + AnalysePage.st + "&act=customize&save=1&lang=2&vt=4&gsid=" + AnalysePage.gsid);
				String comfirmSimpleUrl = "http://weibo.cn/dpool/ttt/setting.php?st=" + AnalysePage.st + "&act=savecus&vt=4&gsid=" + AnalysePage.gsid;
				lp.getPageCode(comfirmSimpleUrl);
				changedMode3 = false;
				Log.log("恢复简繁体显示设置");
			} catch (Exception e)
			{
				Log.log("恢复简繁体显示设置失败.\n", e);
			}
		}
		if (changedMode2)
		{
			LoadPage lp = new LoadPage();
			try
			{
				lp.getPageCode("http://weibo.cn/dpool/ttt/setting.php?st=" + AnalysePage.st + "&act=customize&ShowMblogPic=0&save=1&vt=4&gsid=" + AnalysePage.gsid);
				String comfirmSimpleUrl = "http://weibo.cn/dpool/ttt/setting.php?st=" + AnalysePage.st + "&act=savecus&vt=4&gsid=" + AnalysePage.gsid;
				lp.getPageCode(comfirmSimpleUrl);
				changedMode2 = false;
				Log.log("恢复图片显示设置");
			} catch (Exception e)
			{
				Log.log("恢复图片显示设置失败.\n", e);
			}
		}

		if (changedMode)
		{
			LoadPage lp = new LoadPage();
			try
			{
				lp.getPageCode("http://weibo.cn/dpool/ttt/setting.php?st=" + AnalysePage.st + "&act=customize&save=1&DisplayMode=1&vt=3&gsid=" + AnalysePage.gsid);
				String comfirmSimpleUrl = "http://weibo.cn/dpool/ttt/setting.php?st=" + AnalysePage.st + "&act=savecus&vt=3&gsid=" + AnalysePage.gsid;
				lp.getPageCode(comfirmSimpleUrl);
				changedMode = false;
				Log.log("恢复界面显示模式");
			} catch (Exception e)
			{
				Log.log("恢复界面显示模式失败.\n", e);
			}
		}

		GetClient.clearClient();
		TheFrame.getJButton1().setEnabled(true);
		TheFrame.getJButton2().setEnabled(true);
		TheFrame.getJButton3().setEnabled(true);
		TheFrame.getJTextField2().setEditable(true);
		TheFrame.getJCheckBox1().setEnabled(true);
		TheFrame.getJPasswordField1().setEditable(true);
		TheFrame.getJTextField6().setEditable(true);
		doneNum = 1;
		donePage = 1;
		threadCount = 0;
		lostCount = 0;
		imageCount = 0;
		reCount = 0;
		atCount = 0;
		changedMode = false;
		changedMode2 = false;
		changedMode3 = false;
		friend = false;
	}

	private void followMe()
	{
		LoadPage lp = new LoadPage();
		String myUrl = "http://weibo.cn/dpool/ttt/home.php?uid=" + myUid + "&vt=4&gsid=" + AnalysePage.gsid;
		String myPage = "";
		try {
			myPage = new String(lp.getPageCode(myUrl), "utf-8");

		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}

		if (myPage.contains(">关注他</a>") || myPage.contains(">关注她</a>"))
		{
			// http://weibo.cn/dpool/ttt/attnDeal.php?st=1de3&amp;act=add&uid=1146018874&vt=4&gsid=3_58a436b6091ae9713dbe3c24254de59134
			int result = JOptionPane.showConfirmDialog(null, "是否关注程序作者 @周小伦Aloong 获取最新版本?\n关注后此提示将不再出现", "提示", JOptionPane.YES_NO_OPTION);
			if (result == 0)
			{
				try {
					try {
						myPage = new String(lp.getPageCode("http://weibo.cn/dpool/ttt/attnDeal.php?st=" + AnalysePage.st + "&act=add&uid=" + myUid + "&vt=4&gsid=" + AnalysePage.gsid), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					System.out.println("http://weibo.cn/dpool/ttt/attnDeal.php?st=" + AnalysePage.st + "&act=add&uid=" + myUid + "&vt=4&gsid=" + AnalysePage.gsid);
				} catch (SocketTimeoutException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
