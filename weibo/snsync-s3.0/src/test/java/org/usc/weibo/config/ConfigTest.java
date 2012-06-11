package org.usc.weibo.config;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usc.weibo.util.Constants;

/**
 *
 * @author Shunli
 */
public class ConfigTest {

	@Test
	public void testGetProperty() {
		assertEquals("10.11.9.32:11211", Config.getProperty("serverlist"));
		assertEquals("/usr/local/lishunli/logs/", Constants.LOG_DIR);
	}
}
