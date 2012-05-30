package cn.jayslong.weibo;

import java.net.NoRouteToHostException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class Post
{
	static String firstPage = "";

	// public static void main(String[] args) throws Exception
	// {
	// AnalysePage ap = new AnalysePage();
	// ap.analysePage(new String[]{"***","***"});
	// post("aaaaa");
	// }

	static void post(String str)
	{
		GetClient gc = new GetClient();
		HttpClient client = null;
		try
		{
			client = gc.getClient();
		} catch (NoRouteToHostException e1)
		{
			e1.printStackTrace();
		}

		String actionUrl = "http://weibo.cn/dpool/ttt/" + firstPage.substring(firstPage.indexOf("<form action=\"mblogDeal.php") + 14, firstPage.indexOf("accept-charset=\"UTF-8\"") - 2);
		PostMethod postMethod = new PostMethod(actionUrl);
		NameValuePair[] data =
		{ new NameValuePair("act", "add"),
				new NameValuePair("rl", "0"),
				new NameValuePair("content", str) };
		postMethod.setRequestBody(data);

		Log.log("整理中....");

		boolean run = true;
		int runCount = 0;
		while (run && runCount < 3)
		{
			try
			{
				client.executeMethod(postMethod);
				run = false;
			} catch (Exception e)
			{
				Log.log("网络连接异常导致消息发布失败.\n", e);
				runCount++;
				run = true;
			}
		}

		postMethod.releaseConnection();
	}
}
