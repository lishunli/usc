package org.usc.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usc.constant.Constants;

/**
 *
 * @author Shunli
 */
public class DynamicConfigurationUtilTest {
	@Test
	public void testGetProperty() {
		assertEquals("upload/file", UploadConfigurationUtil.getProperty(Constants.UPLOAD_FILE_PATH));
	}
}
