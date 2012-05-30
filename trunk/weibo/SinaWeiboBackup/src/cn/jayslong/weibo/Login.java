package cn.jayslong.weibo;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class Login
{
	public String login(String[] info, String url) throws HttpException, IOException
	{
		GetClient gc = new GetClient();
		HttpClient client = null;
		client = gc.getClient();

		LoadPage lp = new LoadPage();
		String loginPage = Decoder.decode(new String(lp.getPageCode(url), "UTF8").replaceAll("&amp;", "&"));

		// System.out.println("loginPage = "+loginPage);

		String postUrl = "http://3g.sina.com.cn/prog/wapsite/sso/" + loginPage.substring(loginPage.indexOf("<form action=\"") + 14, loginPage.indexOf("\" method=\"post\">") - 1);

		/*
		 * <input type="password" name="password_5022" size="30" value=""/><br/> <input type="checkbox" name="remember" checked="checked"
		 * />记住登录状态，需支持并打开手机的cookie功能。<br/> <input type="hidden" name="backURL" value="http://t.sina.cn/dpool/ttt/home.php" /> <input type="hidden"
		 * name="backTitle" value="新浪微博" /> <input type="hidden" name="backURL" value="http://t.sina.cn/dpool/ttt/home.php" /> <input type="hidden" name="vk"
		 * value="5022_82a3_1812221990" /> <input type="submit" name="submit" value="登录" /><br/>
		 */
		String passwordName = loginPage.substring(loginPage.indexOf("type=\"password\" name=\"") + 22, loginPage.indexOf("\"", loginPage.indexOf("type=\"password\" name=\"") + 22));
		System.out.println(passwordName);
		String randomKey = "vk";
		String randomValue = loginPage.substring(loginPage.indexOf("name=\"vk\" value=\"") + 17, loginPage.indexOf("\"", loginPage.indexOf("name=\"vk\" value=\"") + 17));
		// randomValue = randomValue.substring(0, randomValue.indexOf("\""));

		System.out.println("randomKey = " + randomKey + "\trandomValue = " + randomValue);

		System.out.println("mobile = " + info[0] + "\tpassword = " + info[1]);
		System.out.println("postUrl = " + postUrl);
		PostMethod postMethod = new PostMethod(postUrl);
		NameValuePair[] data =
		{ new NameValuePair("mobile", info[0]),// 用户名
				new NameValuePair(passwordName, info[1]),// 密码
				new NameValuePair("remember", "checked"),
				new NameValuePair(randomKey, randomValue),
				new NameValuePair("backURL", "http://t.sina.cn/dpool/ttt/home.php"),
				new NameValuePair("backTitle", "新浪微博"),
				new NameValuePair("backURL", "http://t.sina.cn/dpool/ttt/home.php"),
				new NameValuePair("submit", "登录") };
		postMethod.setRequestBody(data);

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
				Log.log("网络连接异常导致登录失败.\n", e);
				runCount++;
				run = true;
			}
		}
		// String pageCode = postMethod.getResponseBodyAsString();

		// http://login.sina.cn/prog/wapsite/sso/login_succ.php?url=http%3A%2F%2Fweibo.cn%2Fdpool%2Fttt%2Fhome.php%3Fgsid%3D3_58a436b6091ae9713dbe3c24254de59134%26vt%3D4&vt=4&r=1

		int statuscode = postMethod.getStatusCode();
		postMethod.releaseConnection();

		System.out.println("statuscode = " + statuscode);
		if ((statuscode == HttpStatus.SC_MOVED_TEMPORARILY)
				|| (statuscode == HttpStatus.SC_MOVED_PERMANENTLY)
				|| (statuscode == HttpStatus.SC_SEE_OTHER)
				|| (statuscode == HttpStatus.SC_TEMPORARY_REDIRECT))
		{
			// 读取新的URL地址
			Header header = postMethod.getResponseHeader("location");
			if (header != null)
			{
				String newuri = header.getValue();
				if ((newuri == null) || (newuri.equals("")))
					newuri = "/";
				GetMethod redirect = new GetMethod(newuri);

				// System.out.println("newuri = "+newuri);
				// client.executeMethod(redirect);
				run = true;
				runCount = 0;
				while (run && runCount < 3)
				{
					try
					{
						client.executeMethod(redirect);
						String tempPage = Decoder.decode(new String(redirect.getResponseBody(), "UTF8")).replaceAll("&amp;", "&");
						// System.out.println("tempPage = "+tempPage);
						AnalysePage.redirectUrl = tempPage.substring(tempPage.indexOf("请<a href=") + 10, tempPage.indexOf("\">点击这里"));
						System.out.println("AnalysePage.redirectUrl = " + AnalysePage.redirectUrl);
						run = false;
					} catch (Exception e)
					{
						Log.log("网络连接异常导致登录跳转失败.\n", e);
						runCount++;
						run = true;
					}
				}

				redirect.releaseConnection();
				return newuri;
			} else
				System.out.println("Invalid redirect");
		}
		return url;
	}

	/*
	 * public static void main(String[] args) throws HttpException, IOException { String[] info = new String[]{"***","***"}; LoadPage lp = new LoadPage(); Login
	 * lg = new Login(); String mainPage = new String(lp.getPageCode("http://t.sina.cn")); String loginPageUrl
	 * =mainPage.substring(mainPage.indexOf("http://3g.sina.com.cn/prog/wapsite/sso/login.php"),mainPage.indexOf(" id=\"top")-1).replaceAll("&amp;", "&");
	 * System.out.println("loginPageUrl: "+loginPageUrl+"\n");
	 * 
	 * String loggedPageUrl = lg.login(new String[]{info[0],info[1]},loginPageUrl).replaceAll("&amp;", "&");
	 * System.out.println("loggedPageUrl: "+loggedPageUrl+"\n"); System.out.println(new String(lp.getPageCode(loggedPageUrl))); }
	 */
}