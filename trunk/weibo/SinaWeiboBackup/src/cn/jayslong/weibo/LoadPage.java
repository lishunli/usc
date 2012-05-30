package cn.jayslong.weibo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class LoadPage
{
	HttpClient client = null;

	// 使用已经Execute的GetMethod获取内容
	public Object getObjectFromGetMethod(String url, GetMethod getMethod, String query) throws SocketTimeoutException, SocketException
	{
		boolean run = true;
		int runCount = 0;
		while (run && runCount < 3)
		{
			try
			{
				run = false;
				if (query.equals("headers")) {
					return getMethod.getResponseHeaders();
				} else if (query.equals("body"))
				{
					return getMethod.getResponseBody();
				} else if (query.equals("path"))
				{
					return getMethod.getPath();
				} else
				{
					return null;
				}

			} catch (java.net.NoRouteToHostException e)
			{
				Log.log("网络中断,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} catch (HttpException e)
			{
				Log.log("网络异常,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} catch (java.net.SocketTimeoutException e)
			{
				// throw e;
				Log.log("网络连接超时,自动重试" + (runCount + 1) + "次..\n" + url, e);
				runCount++;
				run = true;
			} catch (SocketException e)
			{
				Log.log("网络连接被重置,自动重试" + (runCount + 1) + "次..\n" + url, e);
				runCount++;
				run = true;
			} catch (IOException e)
			{
				Log.log("网络读写异常,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} finally
			{
				getMethod.releaseConnection();
			}
		}
		Log.log("下载页面失败!!!!!!!\n" + url);
		return null;
	}

	public Object getPageObject(String url, GetMethod getMethod, String query) throws SocketTimeoutException, SocketException
	{
		boolean run = true;
		int runCount = 0;
		while (run && runCount < 3)
		{
			try
			{
				client.executeMethod(getMethod);
				run = false;
				if (query.equals("headers")) {
					return getMethod.getResponseHeaders();
				} else if (query.equals("body"))
				{
					return getMethod.getResponseBody();
				} else if (query.equals("path"))
				{
					return getMethod.getPath();
				} else
				{
					return null;
				}

			} catch (java.net.NoRouteToHostException e)
			{
				Log.log("网络中断,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} catch (HttpException e)
			{
				Log.log("网络异常,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} catch (java.net.SocketTimeoutException e)
			{
				// throw e;
				Log.log("网络连接超时,自动重试" + (runCount + 1) + "次..\n" + url, e);
				runCount++;
				run = true;
			} catch (SocketException e)
			{
				Log.log("网络连接被重置,自动重试" + (runCount + 1) + "次..\n" + url, e);
				runCount++;
				run = true;
			} catch (IOException e)
			{
				Log.log("网络读写异常,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} finally
			{
				getMethod.releaseConnection();
			}
		}
		Log.log("下载页面失败!!!!!!!\n" + url);
		return null;
	}

	public Header[] getPageHeader(String url) throws SocketTimeoutException, SocketException
	{

		return (Header[]) getPageObject(url, getGetMethod(url), "header");
	}

	public byte[] getPageBody(String url) throws SocketTimeoutException, SocketException
	{
		return (byte[]) getPageObject(url, getGetMethod(url), "body");
	}

	public GetMethod getGetMethod(String url)
	{
		GetClient gc = new GetClient();
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
				Log.log("网络连接错误..请检查网络连接.\n" + url, e1);
				runCount++;
				run = true;
			}
		}
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		return getMethod;
	}

	public GetMethod getExecutedGetMethod(String url)
	{
		GetMethod getMethod = getGetMethod(url);

		boolean run = true;
		int runCount = 0;
		while (run && runCount < 3)
		{
			try
			{
				client.executeMethod(getMethod);
				run = false;

			} catch (java.net.NoRouteToHostException e)
			{
				Log.log("网络中断,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} catch (HttpException e)
			{
				Log.log("网络异常,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			} catch (java.net.SocketTimeoutException e)
			{
				// throw e;
				Log.log("网络连接超时,自动重试" + (runCount + 1) + "次..\n" + url, e);
				runCount++;
				run = true;
			} catch (SocketException e)
			{
				Log.log("网络连接被重置,自动重试" + (runCount + 1) + "次..\n" + url, e);
				runCount++;
				run = true;
			} catch (IOException e)
			{
				Log.log("网络读写异常,请检查网络连接..\n" + url, e);
				runCount++;
				run = true;
			}
		}

		return getMethod;
	}

	public Object[] getPageHeaderAndBody(String url) throws SocketTimeoutException, SocketException
	{
		GetMethod getMethod = getGetMethod(url);
		return new Object[] { getPageObject(url, getMethod, "header"), getPageObject(url, getMethod, "body") };
	}

	public byte[] getPageCode(String url) throws SocketTimeoutException, SocketException
	{
		return getPageBody(url);
	}

	public static void main(String[] args) throws SocketTimeoutException, SocketException, UnsupportedEncodingException {
		LoadPage lp = new LoadPage();
		System.out.println(new String(lp.getPageCode("http://weibo.cn/dpool/ttt/fProxy.php?u=6e85cd22jw1dlm72rkwfwg"), "utf-8"));
	}
	// public byte[] InputStreamToByte(InputStream iStrm) throws IOException
	// {
	// ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
	// int ch;
	// while ((ch = iStrm.read()) != -1)
	// {
	// bytestream.write(ch);
	// }
	// byte imgdata[] = bytestream.toByteArray();
	// bytestream.close();
	// return imgdata;
	// }
}