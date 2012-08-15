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
    private String id; // status id
    private String text; // 微博内容
    private String originalPic; // 原始图片
    private Long timeStamp;
    private WeiboContent retweetedContent;

    public WeiboContent(String id, String text, String originalPic, Long timeStamp) {
        this.id = id;
        this.text = text;
        this.originalPic = originalPic;
        this.timeStamp = timeStamp;
    }

}
