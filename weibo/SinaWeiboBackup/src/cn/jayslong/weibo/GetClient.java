package cn.jayslong.weibo;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class GetClient
{
	private static List<HttpClient> clientContainer = new ArrayList<HttpClient>();

	public HttpClient getClient() throws NoRouteToHostException
	{
		HttpClient client = null;
		if (GetClient.clientContainer.size() == 0)
		{
			try
			{
				client = makeNewClient();
			} catch (NoRouteToHostException e)
			{
				throw e;
			}
			if (client == null)
				throw new NoRouteToHostException();
			GetClient.clientContainer.add(client);
		} else
		{
			client = GetClient.clientContainer.get(0);
		}
		return client;

	}

	public static void clearClient()
	{
		clientContainer.remove(0);
	}

	private HttpClient makeNewClient() throws NoRouteToHostException
	{

		System.setProperty("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");

		HttpClient client;
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		client = new HttpClient(connectionManager);

		DefaultHttpParams.getDefaultParams().setBooleanParameter(
				HttpMethodParams.SINGLE_COOKIE_HEADER, true);

		client.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF8");

		HttpConnectionManagerParams managerParams = client
				.getHttpConnectionManager().getParams();
		managerParams.setConnectionTimeout(10000);
		managerParams.setSoTimeout(15000);

		GetMethod getMethod = new GetMethod(
				"http://t.sina.cn");
		try
		{
			client.executeMethod(getMethod);
		} catch (NoRouteToHostException e)
		{
			throw e;
		} catch (HttpException e)
		{
			return null;
		} catch (IOException e)
		{
			return null;
		}
		// 设置UA
		client.getParams().setParameter(HttpMethodParams.USER_AGENT, "Mozilla/5.0 (X11; U; Linux i686; zh-CN; rv:1.9.1.2) Gecko/20090803 Fedora/3.5.2-2.fc11 Firefox/3.5.2");
		return client;
	}
}
