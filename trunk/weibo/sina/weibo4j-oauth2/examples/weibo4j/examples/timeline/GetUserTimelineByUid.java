package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.Weibo;
import weibo4j.model.Paging;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetUserTimelineByUid {

	public static void main(String[] args) {
		String access_token = "2.00WP3ohBC9fwHB1b76c3a9fb0ak_8x";// args[0];
		Weibo weibo = new Weibo();
		weibo.setToken(access_token);

		try {
			Paging pag = new Paging();
			pag.setSinceId(3481085788427823L);
			pag.setCount(100);

			Timeline tm = new Timeline();
			StatusWapper status = tm.getUserTimelineByUid("1563517210", pag, 0, 0);

			for (Status s : status.getStatuses()) {
				System.out.println(s.getId() + "," + s.getCreatedAt() + "," + s.getText());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
