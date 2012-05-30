package cn.jayslong.weibo;

import java.net.URLEncoder;

public class AnalysePage
{
	static String gsid = "";
	static int pageCount = 0;
	static String st = "";
	static String redirectUrl = "";

	public static void analysePage(String[] info) throws Exception
	{
		// 获得gsid
		gsid = "";
		GetGsid gg = new GetGsid();
		gsid = gg.getGsid(info);
		LoadPage lp = new LoadPage();
		// System.out.println(Decoder.decode(new String(lp.getPageCode(redirectUrl),"UTF8")).replaceAll("&amp;", "&"));

		// lp.getPageCode("http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=customize&save=1&DisplayMode=1&vt=4&gsid="+gsid);
		// String comfirmSimpleUrl = "http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=savecus&vt=4&gsid="+gsid;
		// lp.getPageCode(comfirmSimpleUrl);
		// System.out.println(comfirmedSimplePage);

		// lp.getPageCode("http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=customize&save=1&DisplayMode=2&vt=1&gsid="+gsid);
		// String comfirmFullUrl = "http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=savecus&vt=1&gsid="+gsid;
		// lp.getPageCode(comfirmFullUrl);
		// System.out.println(comfirmedFullPage);

		// 下载第一页
		String firstPageUrl = "http://weibo.cn/dpool/ttt/home.php?cat=1&vt=4&gsid=" + gsid;
		// Log.log("PageUrl: "+firstPageUrl+"\n");
		String firstPage = Decoder.decode(new String(lp.getPageCode(firstPageUrl), "UTF8").replaceAll("&amp;", "&"));
		// System.out.println(firstPage);
		st = firstPage.substring(firstPage.indexOf("mblogDeal.php?st=") + 17, firstPage.indexOf("mblogDeal.php?st=") + 21);
		System.out.println("st = " + st);
		// 判断是否修改为简体中文
		if (firstPage.contains(">顯示設定</a>") && firstPage.contains(">熱門轉發</a>"))
		{
			st = firstPage.substring(firstPage.indexOf("mblogDeal.php?st=") + 17, firstPage.indexOf("mblogDeal.php?st=") + 21);
			lp.getPageCode("http://weibo.cn/dpool/ttt/setting.php?st=" + st + "&act=customize&save=1&lang=1&vt=4&gsid=" + gsid);
			String comfirmFullUrl = "http://weibo.cn/dpool/ttt/setting.php?st=" + st + "&act=savecus&vt=4&gsid=" + gsid;
			lp.getPageCode(comfirmFullUrl);
			firstPage = new String(lp.getPageCode(firstPageUrl), "UTF8");
			Controller.changedMode3 = true;
			Log.log("修改简繁显示设置");
		}
		// http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=customize&save=1&lang=1&vt=4&gsid=3_58a436b6091ae9713dbe3c24254de59134
		// http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=savecus&vt=4&gsid=3_58a436b6091ae9713dbe3c24254de59134

		// 判断是否修改成彩版
		if (firstPage.contains("\"http://www.wapforum.org/DTD/wml_1.1.xml\">"))
		{
			st = firstPage.substring(firstPage.indexOf("mblogDeal.php?st=") + 17, firstPage.indexOf("mblogDeal.php?st=") + 21);
			lp.getPageCode("http://weibo.cn/dpool/ttt/setting.php?st=" + st + "&act=customize&save=1&DisplayMode=2&vt=1&gsid=" + gsid);
			String comfirmFullUrl = "http://weibo.cn/dpool/ttt/setting.php?st=" + st + "&act=savecus&vt=1&gsid=" + gsid;
			lp.getPageCode(comfirmFullUrl);
			firstPage = new String(lp.getPageCode(firstPageUrl), "UTF8");
			Controller.changedMode = true;
			Log.log("修改界面显示模式");
		}

		// 判断是否默认不显示图片
		if (firstPage.contains(">显示图片</a>"))
		{
			st = firstPage.substring(firstPage.indexOf("mblogDeal.php?st=") + 17, firstPage.indexOf("mblogDeal.php?st=") + 21);
			lp.getPageCode("http://weibo.cn/dpool/ttt/setting.php?st=" + st + "&act=customize&ShowMblogPic=1&save=1&vt=4&gsid=" + gsid);
			String comfirmFullUrl = "http://weibo.cn/dpool/ttt/setting.php?st=" + st + "&act=savecus&amp;vt=4&gsid=" + gsid;
			lp.getPageCode(comfirmFullUrl);
			firstPage = new String(lp.getPageCode(firstPageUrl), "UTF8");
			Controller.changedMode2 = true;
			Log.log("修改图片显示设置");
		}
		// http://t.sina.cn/dpool/ttt/setting.php?st=1de3&act=customize&ShowMblogPic=1&save=1&vt=4&gsid=3_58a436b6091ae9713dbe3c24254de59134
		// href="setting.php?st=1de3&amp;act=savecus&amp;vt=4&amp;gsid=3_58a436b6091ae9713dbe3c24254de59134

		// 为推消息做准备
		Post.firstPage = firstPage;

		// 如果下载好友的就做这一步
		if (Controller.friend)
		{
			firstPageUrl = new GetRedirectedUrl().getRedirectedUrl("http://weibo.cn/dpool/ttt/domain.php?n=" + URLEncoder.encode(Controller.friendName, "UTF8") + "&page=1") + "&gsid=" + gsid;
			System.out.println("firstPageUrl = " + firstPageUrl);
			firstPage = Decoder.decode(new String(lp.getPageCode(firstPageUrl), "UTF8").replaceAll("&amp;", "&"));
			// System.out.println("Friends firstPage = "+ firstPage);
			String urlStr;
			try {
				urlStr = firstPage.substring(firstPage.indexOf("uid=") + 4, firstPage.indexOf("uid=") + 20);
			} catch (StringIndexOutOfBoundsException e) {
				throw new IllegalArgumentException();
			}
			Controller.friendUid = urlStr.split("&")[0];
		}

		// 获取页数
		pageCount = 0;
		if (firstPage.contains("value=\"跳页\" />&nbsp;1/"))
		{
			pageCount = Integer.valueOf(firstPage.substring(firstPage.indexOf("value=\"跳页\" />&nbsp;1/") + 21, firstPage.indexOf("页</div>", firstPage.indexOf("value=\"跳页\" />&nbsp;1/") + 21)));
		} else
		{
			System.out.println("没有找到跳页 两个字诶.");
		}
		Log.log("pageCount: " + pageCount + "\n");
	}
	public static void main(String[] args) throws Exception
	{
	}
}
