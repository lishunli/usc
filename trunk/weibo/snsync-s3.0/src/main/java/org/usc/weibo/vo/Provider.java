package org.usc.weibo.vo;

/**
 *
 * @author Shunli
 */
public enum Provider {
	TENCENT("01"), SINA("02");

	private String prefix;

	public String getPrefix() {
		return prefix;
	}

	private Provider(String prefix) {
		this.prefix = prefix;
	}
}
