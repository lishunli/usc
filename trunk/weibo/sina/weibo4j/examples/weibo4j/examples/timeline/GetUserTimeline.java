/**
 *
 */
package weibo4j.examples.timeline;

import java.util.List;

import weibo4j.Paging;
import weibo4j.Status;
import weibo4j.Weibo;
import weibo4j.WeiboException;

/**
 * @author sina
 *
 */
public class GetUserTimeline {

	/**
	 * 获取用户发布的微博信息列表
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
		try {
			Weibo weibo = new Weibo();
			weibo.setToken(args[0], args[1]);
			Paging pag = new Paging();
			pag.setSinceId(1L);
			pag.setCount(1000);
			// 获取24小时内前20条用户的微博信息;args[2]:用户ID
			List<Status> statuses = weibo.getUserTimeline("1641796771", pag);
			for (Status status : statuses) {
//				status.getRetweeted_status();
				System.out.println(status);
//				System.out.println(status.getUser().getName() + ":" + status.getId() + ":" +
//						status.getText() + status.getOriginal_pic());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
