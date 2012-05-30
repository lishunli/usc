package cn.jayslong.weibo;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class GetRedirectedUrl {
	public static void main(String[] args) throws Exception
	{
		GetRedirectedUrl gru = new GetRedirectedUrl();
		System.out.println(gru.getRedirectedUrl("http://weibo.cn/dpool/ttt/fProxy.php?u=6e85cd22jw1dlm72rkwfwg"));
		LoadPage lp = new LoadPage();
		String code = new String(lp.getPageCode("http://weibo.cn/dpool/ttt/fProxy.php?u=6e85cd22jw1dlm72rkwfwg"), "GBK");
		System.out.println(code);
	}

	public String getRedirectedUrl(String url) throws SocketTimeoutException
	{
		GetClient gc = new GetClient();
		HttpClient client = null;
		boolean run = true;
		int runCount = 0;
		while (run && runCount < 3)
		{
			try
			{
				client = gc.getClient();
				run = false;
			} catch (NoRouteToHostException e1)
			{
				Log.log("网络连接错误..请检查网络连接.\n" + url + "\n", e1);
				runCount++;
				run = true;
			}
		}
		GetMethod getMethod = new GetMethod(url);
		// getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
		// new DefaultHttpMethodRetryHandler());

		run = true;
		runCount = 0;
		while (run && runCount < 3)
		{
			try
			{
				client.executeMethod(getMethod);
				run = false;
			} catch (java.net.NoRouteToHostException e)
			{
				Log.log("网络中断,请检查网络连接..\n" + url + "\n", e);
				runCount++;
				run = true;
			} catch (HttpException e)
			{
				Log.log("网络异常,请检查网络连接..\n" + url + "\n", e);
				runCount++;
				run = true;
			} catch (java.net.SocketTimeoutException e)
			{
				// throw e;
				Log.log("网络连接超时,自动重试" + (runCount + 1) + "次..\n" + url + "\n", e);
				runCount++;
				run = true;
				if (runCount >= 3)
				{
					throw e;
				}
			} catch (IOException e)
			{
				Log.log("网络读写异常,请检查网络连接..\n" + url + "\n", e);
				runCount++;
				run = true;
			} finally
			{
				getMethod.releaseConnection();
			}
		}

		int statuscode = getMethod.getStatusCode();
		System.out.println(statuscode);
		// if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY)
		// || (statuscode == HttpStatus.SC_MOVED_PERMANENTLY)
		// || (statuscode == HttpStatus.SC_SEE_OTHER)
		// || (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT))
		{
			// 读取新的URL地址
			Header header = getMethod.getResponseHeader("location");
			if (header != null)
			{
				String newuri = header.getValue();
				if ((newuri == null) || (newuri.equals("")))
				{
					newuri = url;
				}
				return newuri;
			} else
				System.out.println("Invalid redirect");
		}
		return url;
	}
}
