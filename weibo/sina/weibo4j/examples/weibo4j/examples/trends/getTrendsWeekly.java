package weibo4j.examples.trends;

import java.util.List;

import weibo4j.Paging;
import weibo4j.Trends;
import weibo4j.Weibo;
import weibo4j.WeiboException;

public class getTrendsWeekly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
		Paging paging = new Paging();
		paging.setCount(20);
		paging.setPage(1);
		try {
			Weibo weibo = new Weibo();
			weibo.setToken(args[0], args[1]);
			List<Trends> trendsWeekly = weibo.getTrendsWeekly(0);
			System.out.println("=======按周返回热门话题=======");
			System.out.println(trendsWeekly);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
