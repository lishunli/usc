package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.Weibo;
import weibo4j.model.Paging;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;

public class GetUserTimelineByUid {

	public static void main(String[] args) {
		String access_token = "2.00WP3ohBC9fwHB15bb2e0c297HuuzC";// args[0];
		Weibo weibo = new Weibo();
		weibo.setToken(access_token);
		Timeline tm = new Timeline();

		try {
			Paging pag = new Paging();
			pag.setSinceId(3472019988983197L);
			pag.setCount(200);

			StatusWapper status = tm.getUserTimelineByUid("1563517210", pag, 0, 0);

			for (Status s : status.getStatuses()) {
				System.out.println(s.getId() + "," + s.getCreatedAt() + "," + s.getText());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
