package org.usc.weibo.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Relation implements java.io.Serializable {
	private static final long serialVersionUID = 6897571766866997495L;
	private Long seqId;
	private Long leftFollowerId;
	private Long rightFollowerId;
	private Integer isTwoWay = 1;

	public Relation(Long leftFollowerId, Long rightFollowerId) {
		this.leftFollowerId = leftFollowerId;
		this.rightFollowerId = rightFollowerId;
	}
	public Relation(Long leftFollowerId, Long rightFollowerId, Integer isTwoWay) {
		this(leftFollowerId, rightFollowerId);
		this.isTwoWay = isTwoWay;
	}

}
