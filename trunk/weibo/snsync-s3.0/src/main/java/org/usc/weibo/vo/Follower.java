package org.usc.weibo.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Follower implements java.io.Serializable {
	private static final long serialVersionUID = 4330874688024714057L;
	private Long seqId;
	private String userId;
	private String appId;
	private String userName;
	private String token;
	private String verifier;
	private String lastId;
	private Long lastTimeStamp;
}
