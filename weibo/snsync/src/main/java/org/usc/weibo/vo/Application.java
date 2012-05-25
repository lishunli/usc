package org.usc.weibo.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Application implements java.io.Serializable {
	private static final long serialVersionUID = -3145819054572660288L;

	private Long seqId;
	private String appId;
	private String oauthConsumerKey;
	private String oauthConsumerSecret;
	private String provider;

}
