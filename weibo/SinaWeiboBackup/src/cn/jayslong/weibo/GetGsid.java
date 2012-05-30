package cn.jayslong.weibo;

import java.io.IOException;
import java.util.InputMismatchException;

import org.apache.commons.httpclient.HttpException;

public class GetGsid
{

	public String getGsid(String[] info) throws InputMismatchException, HttpException, IOException
	{
		LoadPage lp = new LoadPage();
		Log.log("开始登陆...");
		Login lg = new Login();

		String mainPage = Decoder.decode(new String(lp.getPageCode("http://weibo.cn/dpool/ttt/index.php"), "UTF8"));
		String loginPageUrl = mainPage.substring(mainPage.indexOf("http://3g.sina.com.cn/prog/wapsite/sso/login.php"), mainPage.indexOf(">登录</a>") - 1).replaceAll("&amp;", "&");
		// Log.log("loginPageUrl: "+loginPageUrl+"\n");

		String loggedPageUrl = lg.login(new String[] { info[0], info[1] }, loginPageUrl).replaceAll("&amp;", "&");
		// Log.log("loggedPageUrl: "+loggedPageUrl+"\n");
		if (loggedPageUrl.equals(loginPageUrl))
		{
			throw new InputMismatchException("用户名或密码错误");
		}
		Log.log("登陆成功,开始分析页面...");
		String loggedPage = Decoder.decode(new String(lp.getPageCode(loggedPageUrl), "UTF8"));
		// String userPageUrl =
		// loggedPage.substring(loggedPage.indexOf("如果没有自动跳转,请<a href=\"http://t.sina.cn/dpool/ttt/home.php")+19,loggedPage.indexOf("点击这里")-2).replaceAll("&amp;",
		// "&");
		String userPageUrl = loggedPage.substring(loggedPage.indexOf("<meta http-equiv=\"refresh\" content=\"3;url=http:") + 42, loggedPage.indexOf("<title>") - 5).replaceAll("&amp;", "&");

		// Log.log("userPageUrl: "+userPageUrl+"\n");

		String gsid = userPageUrl.substring(userPageUrl.indexOf("gsid=") + 5, userPageUrl.lastIndexOf("&vt=4"));
		System.out.println("gsid = " + gsid + "\n");

		return gsid;
	}

}
