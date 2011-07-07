package org.springframework.samples.mvc.basic.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Simple Name Util(Right intercept) <br>
 * e.g.<br>
 * <br>
 * SimpleNameUtil.chompClassName("org.springframework.samples.mvc.basic.controller.UserController",".",2) = controller.UserController<br>
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-7-7<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        <p>
 */
public class SimpleNameUtil {
	private static final String DEFAULT_SEPARATOR_CHARS = ".";
	private static final int DEFAULT_CHOMP_SIZE = 1;
	private static final String BLANK_STRING = "";

	// ///////////////////////////////////////////////////////////////////////
	// Functions
	// ///////////////////////////////////////////////////////////////////////
	/**
	 * @param className
	 * @return
	 */
	public static String chompClassName(String className) {
		return chompClassName(className, DEFAULT_CHOMP_SIZE);
	}

	/**
	 * @param className
	 * @param separatorChars
	 * @return
	 */
	public static String chompClassName(String className, String separatorChars) {
		return chompClassName(className, separatorChars, DEFAULT_CHOMP_SIZE);
	}

	/**
	 * @param className
	 * @param chompSize
	 * @return
	 */
	public static String chompClassName(String className, int chompSize) {
		return chompClassName(className, DEFAULT_SEPARATOR_CHARS, chompSize);
	}

	/**
	 * @param className
	 * @param separatorChars
	 * @param chompSize
	 * @return
	 */
	public static String chompClassName(String className, String separatorChars, int chompSize) {
		if (!StringUtils.isBlank(className)) {
			if (chompSize <= 0) {
				chompSize = className.length();
			}

			List<String> handler = Arrays.asList(StringUtils.split(className, separatorChars));
			int size = handler.size();

			if (size > chompSize) {
				return StringUtils.join(handler.subList(size - chompSize, size), separatorChars);
			} else {
				return className;
			}
		} else {
			return BLANK_STRING;
		}
	}
}
