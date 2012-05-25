package org.usc.weibo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Shunli
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeiboContent {
	private Long id; // status id
	private String text; // 微博内容
	private String originalPic; // 原始图片
	private Long timeStamp;
	private WeiboContent retweetedContent;

//	public WeiboContent(Long id, String text, String originalPic) {
//		this.id = id;
//		this.text = text;
//		this.originalPic = originalPic;
//	}

	public WeiboContent(Long id, String text, String originalPic, Long timeStamp) {
		this.id = id;
		this.text = text;
		this.originalPic = originalPic;
		this.timeStamp = timeStamp;
	}



	// private String thumbnail_pic; // 微博内容中的图片的缩略地址
	// private String source; // 微博来源
	// private boolean isTruncated; // 保留字段
	// private long inReplyToStatusId;
	// private long inReplyToUserId;
	// private boolean isFavorited; // 保留字段，未弃用
	// private String inReplyToScreenName;
	// private double latitude = -1; // 纬度
	// private double longitude = -1; // 经度
	// private String bmiddle_pic; // 中型图片
	// private Status retweeted_status; // 转发的微博内容
	// private String mid; // mid

}
