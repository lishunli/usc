package weibo4j.examples.comment;

import weibo4j.Comments;
import weibo4j.Weibo;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Comment;
import weibo4j.model.WeiboException;

public class CreateComment {

	public static void main(String[] args) {
		String access_token = "2.00WP3ohBC9fwHBbead892d05kL4p2C";//args[0];
		Weibo weibo = new Weibo();
		weibo.setToken(access_token);
		String comments = "test OAuth2 In Sina Weibo again";//args[1];
		String id = "3479044915883667"; //args[2];
		Comments cm = new Comments();
		try {
			Comment comment = cm.createComment(comments, id);
			Log.logInfo(comment.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
