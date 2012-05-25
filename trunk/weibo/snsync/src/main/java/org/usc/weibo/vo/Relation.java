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
	private Integer isTwoWay = 0;
}
