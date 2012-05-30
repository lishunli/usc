/**    
 * @Title: DownloadThread.java 
 * @Package cn.jayslong.weibo 
 * @Description:  
 * @author Aloong 
 * @date 2010-11-11 上午03:05:58 
 * @version V1.0 
 */

package cn.jayslong.weibo;

public class DownloadThread implements Runnable
{

	@Override
	public void run()
	{
		Controller.threadCount++;

		int pageNum = 0;
		boolean run = true;
		boolean runAgain = false;
		int reCount = 0;
		String sourceCode = "";
		String url = "";

		while (run)
		{

			pageNum = Controller.getDownLoadTask();
			if (Controller.friend)
			{
				url = "http://t.sina.cn/dpool/ttt/home.php?uid=" + Controller.friendUid + "&page=" + pageNum + "&gsid=" + AnalysePage.gsid;// 靠,浏览器地址栏上怎么不显示gsid啊
			} else
			{
				url = "http://t.sina.cn/dpool/ttt/home.php?cat=1&page="
						+ pageNum + "&mp=" + pageNum + "&gsid=" + AnalysePage.gsid;
			}
			if (pageNum == -1)
			{
				continue;
			}
			if (pageNum == 0)
			{
				break;
			}
			reCount = 0;
			do
			{
				LoadPage lp = new LoadPage();
				try
				{
					sourceCode = new String(lp.getPageCode(url), "UTF8");
					runAgain = false;
					// System.out.println(sourceCode);
					if (!(sourceCode.contains("来自") || sourceCode.contains("來自")))
					{
						runAgain = true;
						reCount++;
						if (reCount > 10)
						{
							runAgain = false;
							Log.log("第" + pageNum + "个页面下载失败!!!");
						}
						Thread.sleep(1000);
					}
				} catch (Exception e)
				{
					runAgain = true;
				}
			} while (runAgain);
			Log.log("下载完成第" + pageNum + "页");
			Controller.PageMap.put(pageNum, sourceCode);

		}
		System.out.println("下载线程: " + Thread.currentThread().getName() + " 退出!");
		Controller.threadCount--;
	}
}
