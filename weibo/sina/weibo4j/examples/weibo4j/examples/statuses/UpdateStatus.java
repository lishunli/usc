/**
 *
 */
package weibo4j.examples.statuses;

import java.io.File;

import weibo4j.Status;
import weibo4j.Weibo;

/**
 * @author sina
 *
 */
public class UpdateStatus {

	/**
	 * 发布一条微博信息
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
		System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
		System.setProperty("weibo4j.source", "1033549550");
		try {
			Weibo weibo = new Weibo();
			weibo.setToken(args[0], args[1]);
			// weibo.uploadStatus("看过《生活大爆炸  第五季》 ★★★★ http://url.cn/39dFGq ,1","http://app.qpic.cn/mblogpic/04927e6ddc156c4055c8/2000");//
			Status status =weibo.updateStatus("I'm back3!");
			System.out.println(status.getId() + " : " + status.getText() + "  " + status.getCreatedAt());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
