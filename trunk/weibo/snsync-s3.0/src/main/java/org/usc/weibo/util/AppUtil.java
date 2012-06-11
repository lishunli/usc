package org.usc.weibo.util;

import org.apache.commons.lang.StringUtils;
import org.usc.weibo.vo.Provider;

/**
 *
 * @author Shunli
 */
public class AppUtil {
	public static Provider getProvider(String appId) {
		if (!StringUtils.isBlank(appId)) {
			for (Provider provider : Provider.values()) {
				String prefix = provider.getPrefix();
				if (prefix.length() > appId.length()) {
					return null;
				}
				if (appId.regionMatches(true, 0, prefix, 0, prefix.length())) {
					return provider;
				}
			}
		}

		return null;
	}
}
