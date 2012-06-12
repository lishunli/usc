package org.usc.weibo.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ShunLi
 */
@Setter
@Getter
@NoArgsConstructor
public class SyncRecord implements Serializable {
	private static final long serialVersionUID = 966746459169463528L;

	private Long seqId;
	private Long followerId;
	private Long weiboId;
	private String inputDay;

	public SyncRecord(Long followerId, Long weiboId, String inputDay) {
		this.followerId = followerId;
		this.weiboId = weiboId;
		this.inputDay = inputDay;
	}

}
