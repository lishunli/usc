package org.usc.weibo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Shunli
 */
public class WeiboUtil {
	public final static String DOUBLE_BYTE_PATTERN = "[^\\x00-\\xff]";
	public final static String ABBREVIATE_SUFFIX = "...";

	public static int length(String text) {
		int length = 0;
		if (!StringUtils.isBlank(text)) {
			// double-byte
			Pattern p = Pattern.compile(DOUBLE_BYTE_PATTERN);
			Matcher m = p.matcher(text);

			int doubleByteNumber = 0;
			while (m.find()) {
				doubleByteNumber++;
			}
			int singleByteNumber = text.length() - doubleByteNumber;

			return doubleByteNumber + singleByteNumber / 2 + singleByteNumber % 2;
		}

		return length;
	}

	public static String abbreviate(String text, int maxWidth) {
		StringBuffer sb = new StringBuffer("");

		if (!StringUtils.isBlank(text)) {
			if (length(text) <= maxWidth) {
				sb.append(text);
			} else {
				int doubleByteNumber = 0, singleByteNumber = ABBREVIATE_SUFFIX.length();

				for (char c : text.toCharArray()) {
					if (String.valueOf(c).matches(DOUBLE_BYTE_PATTERN)) {
						doubleByteNumber++;
					} else {
						singleByteNumber++;
					}

					if (doubleByteNumber + singleByteNumber / 2 + singleByteNumber % 2 <= maxWidth) {
						sb.append(c);
					}
				}

				sb.append(ABBREVIATE_SUFFIX);
			}

		}

		return sb.toString();
	}
}
