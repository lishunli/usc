package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.Weibo;
import weibo4j.model.Status;

public class UploadByImgUrl {
	public static void main(String args[]) {
		try {
			Weibo weibo = new Weibo();
			weibo.setToken("2.00WP3ohBC9fwHB1b76c3a9fb0ak_8x");
			try {
				Timeline tl = new Timeline();
				Status status = tl.uploadStatus("中文测试2", "http://t2.qpic.cn/mblogpic/9726b4eaf9d8d9ec8188/2000");

				System.out.println("Successfully upload the status to [" + status.getText() + "].");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
			System.out.println("Failed to read the system input.");
		}
	}
}
