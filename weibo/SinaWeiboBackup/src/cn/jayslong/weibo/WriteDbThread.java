/**    
 * @Title: WriteDbThread.java 
 * @Package cn.jayslong.weibo 
 * @Description: 
 * @author Aloong 
 * @date 2010-11-11 上午03:06:28 
 * @version V1.0 
 */

package cn.jayslong.weibo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.IllegalBlockSizeException;

import SQLite.Database;
import SQLite.Exception;

public class WriteDbThread implements Runnable
{
	static Database db = new Database();
	// List<String> record = new ArrayList<String>();
	String pageCode = "";
	int pageNum;
	String tableName = Controller.friend ? Controller.friendName : Controller.info[0].contains("@") ? Controller.info[0]
			.substring(0, Controller.info[0].indexOf("@")) : Controller.info[0];
	boolean run = true;
	int runCount = 0;
	int writeCount = 0;
	String sql = "";

	@Override
	public void run()
	{
		Controller.threadCount++;
		try
		{
			db.open(Controller.dbPath, 0666);
		} catch (Exception e)
		{
			Log.log("数据库文件打开失败,无法写入数据库", e);
		}
		// id, 内容(转发), 转发理由, 图片地址 , 时间, 通过
		String tableCreate = "create table '"
				+ tableName
				+ "'(id integer primary key, content text, rt text, image text, time datetime, via text)";
		// excute(pageCode);
		String dropTable = "drop table '" + tableName + "'";

		try
		{
			WriteDbThread.excute(dropTable);
		} catch (SQLite.Exception e)
		{
			Log.log("同名表格不存在,直接新建表格..\n");
		}

		try
		{
			WriteDbThread.excute(tableCreate);
		} catch (SQLite.Exception e)
		{
			Log.log("新建表格出错..\n");
		}

		boolean isBlankPage = false;
		do
		{
			pageNum = Controller.getStoreTask();
			if (pageNum == 0)
			{
				break;
			}
			pageCode = Controller.PageMap.get(pageNum);
			Controller.PageMap.remove(pageNum);
			// System.out.println("pagecode: "+pageCode+"\n");
			List<String[]> sqlStrings = new ArrayList<String[]>();

			run = true;
			runCount = 0;
			while (run && runCount < 3)
			{
				try
				{
					sqlStrings = WriteDbThread.dealCode(pageCode);
					if (sqlStrings.size() != 10 && pageNum < AnalysePage.pageCount)
					{
						Controller.lostCount += (10 - sqlStrings.size());
						Log.log("在第" + pageNum + "页有" + (10 - sqlStrings.size()) + "条消息失踪了..");
					}
					run = false;
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
					isBlankPage = true;
					Controller.lostCount += 10;
					Log.log("第" + pageNum + "页完全失踪,自动跳过");
					break;
				} catch (Exception e1)
				{
					Log.log("页面解码错误" + "\n", e1);
					runCount++;
					run = true;
				}
			}

			if (isBlankPage)
			{
				isBlankPage = false;
				continue;
			}

			// String sql = "";
			for (String[] s : sqlStrings)
			{
				sql = sql + "insert into [" + tableName + "] values (" + s[0]
						+ ",'" + s[1].trim() + "','" + s[2].trim() + "','" + s[3] + "','"
						+ s[4] + "','" + s[5] + "');";
			}
			writeCount++;

			// 累计10条进行一次数据写入//改为1条貌似比较快,但是感觉伤硬盘啊.写数据时候疯狂创建临时文件.//不搞什么缓存了,直接写最快!
			// if (writeCount >= 10 || writeCount>=pageNum || pageNum==AnalysePage.pageCount)
			// {
			try
			{
				WriteDbThread.excute(sql);
				sql = "";
				writeCount = 0;
			} catch (SQLite.Exception e)
			{
				Log.log("SQL插入语句执行异常..\n" + sql + "\n", e);
			}
			// }
			// try
			// {
			// WriteDbThread.excute(sql);
			// } catch (SQLite.Exception e)
			// {
			// Log.log("SQL插入语句执行异常..\n" + sql + "\n", e);
			// }

			Log.log("写入完成第" + pageNum + "页");

		} while (pageNum != 0);

		Controller.threadCount--;
	}

	public static List<String[]> dealCode(String pageCode) throws Exception, IllegalBlockSizeException
	{
		Pattern p;
		Matcher m;
		List<String[]> sqlStrings = new ArrayList<String[]>();
		// System.out.println(pageCode);<div class="s"></div><div class="pa" id="pagelist">
		try
		{
			pageCode = pageCode
					.substring(
							pageCode.indexOf("\">筛选</a></div>") + 14,
							pageCode.indexOf("<div class=\"s\"></div><div class=\"pa\" id=\"pagelist\">"));
		} catch (StringIndexOutOfBoundsException e)
		{
			System.out.println(pageCode);// TODO
			// <div class="hm">
			try {
				pageCode = pageCode
						.substring(
								pageCode.indexOf("\">筛选</a></div>") + 14,
								pageCode.indexOf(">下页</a>"));
			} catch (StringIndexOutOfBoundsException e1) {
				throw new IllegalBlockSizeException();
			}
		}
		String[] records = pageCode.split("<div class=\"s\"></div>");
		for (int i = 0; i < records.length; i++)
		{
			// id, 内容(转发), 转发理由, 图片地址 , 时间, 通过
			String[] line = new String[]
			{ "null", "null", "null", "null", "null", "null" };
			records[i] = records[i]
					.replaceAll(
							"<span class=\"cmt\">原文转发\\[\\d+\\]</span>.*?class=\"cc\">原文评论\\[\\d+\\]</a></div>",
							"");
			records[i] = records[i].replaceAll(
					">转发\\[\\d+\\]</a>.*?class=\"cc\">删除</a>", ">");
			records[i] = records[i].replaceAll(
					">转发\\[\\d+\\]</a>.*?class=\"cc\">评论\\[\\d+\\]</a>", ">");
			// records[i] = records[i].replaceAll("<a href=\"http://.+?sinaimg\\.cn/woriginal/.+?\\?\">","");

			// 处理图片地址
			p = Pattern.compile(
					"<a href=\"http://.+?sinaimg\\.cn/woriginal/.+?\">" +
							"|<a href=\"http://wp\\d+\\.sina\\.cn/woriginal/.+?\">",
					Pattern.DOTALL);
			m = p.matcher(records[i]);

			if (m.find())
			{
				Controller.imageCount++;
				line[3] = m.group();
				line[3] = line[3].substring(9, line[3].length() - 2)
						.replaceAll("'", "''");
			} else
			{
				p = Pattern.compile(
						"<a href=\"/dpool/ttt/fProxy.php\\?u=\\w+?&amp",
						Pattern.DOTALL);
				m = p.matcher(records[i]);
				if (m.find())
				{
					Controller.imageCount++;
					line[3] = m.group();
					line[3] = "http://weibo.cn" + line[3].substring(9, line[3].length() - 4)
							.replaceAll("'", "''");
				}
			}
			records[i] = records[i].replaceAll("\">原图</a>", ">");

			// System.out.println("++++++++++true+++++++++++"+image);
			String[] recordSplit = records[i]
					.split("<span class=\"ct\">|<span class=\"cmt\">转发理由:</span>");
			for (int j = 0; j < recordSplit.length; j++)
			{
				recordSplit[j] = recordSplit[j].replaceAll("<[^>]*>", "")
						.replaceAll("&nbsp;", " ").replaceAll("\\s+", " ")
						+ "\n";
			}
			if (recordSplit[0].startsWith("@"))
			{
				Controller.atCount++;
			}
			if (recordSplit.length == 2)
			{
				line[1] = recordSplit[0].replaceAll("'", "''").replaceAll("收藏更多-->", "");
			} else
			{
				Controller.reCount++;
				line[1] = recordSplit[0].replaceAll("'", "''").replaceAll("收藏更多-->", "");
				line[2] = recordSplit[1].replaceAll("'", "''").replaceAll("收藏更多-->", "");
			}
			String[] timeVia = recordSplit[recordSplit.length - 1].split(" 来自");
			line[4] = timeFormat(timeVia[0].replaceAll("'", "''"));
			line[5] = timeVia[1].replaceAll("'", "''");
			// System.out.println("\n\n\n\n\n");
			sqlStrings.add(line);

		}

		return sqlStrings;
	}

	public static void excute(String sql) throws SQLite.Exception
	{
		try
		{
			db.exec(sql, null);
		} catch (SQLite.Exception e)
		{
			throw e;
		} catch (java.lang.Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String timeFormat(String str)
	{

		if (str.trim().matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}"))
		{
			return str.trim().replaceAll("\\s+", " ");
		} else if (str.trim().matches("\\d{2}月\\d{2}日\\s+\\d{2}:\\d{2}")) {
			GregorianCalendar g = new GregorianCalendar();
			int year = (int) g.get(Calendar.YEAR);
			return "" + year + "-" + str.trim().replaceAll("月", "-").replaceAll("日", "").replaceAll("\\s+", " ") + ":00";
		} else if (str.trim().matches("\\d+分钟前"))
		{
			int min = Integer.valueOf(str.trim().replaceAll("分钟前", ""));
			Calendar now = Calendar.getInstance();
			now.set(Calendar.DATE, now.get(Calendar.MINUTE) - min);
			Date tasktime = now.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.format(tasktime);
		} else if (str.trim().matches("今天\\s+\\d{2}:\\d{2}"))
		{
			Calendar now = Calendar.getInstance();
			Date tasktime = now.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(tasktime) + str.replaceAll("今天", "").replaceAll("\\s+", " ") + ":00";
		}
		Log.log("时间转换失败: " + str);
		return null;
	}

	public static void main(String[] args) throws java.lang.Exception
	{
		// AnalysePage.analysePage(new String[]
		// { "***", "***" });
		int pageNum = 1;
		String firstPageUrl = "http://t.sina.cn/dpool/ttt/home.php?cat=1&page="
				+ pageNum + "&mp=" + pageNum + "&gsid=" + AnalysePage.gsid;
		LoadPage lp = new LoadPage();
		String firstPage = new String(lp.getPageCode(firstPageUrl));

		WriteDbThread.dealCode(firstPage);
	}

}
