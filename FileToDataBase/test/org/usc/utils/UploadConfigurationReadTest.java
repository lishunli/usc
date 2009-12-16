package org.usc.utils;

import org.junit.Test;
import static org.junit.Assert.*;


public class UploadConfigurationReadTest
{	
	@Test
	public void testUploadConfigurationRead()
	{
		UploadConfigurationRead uploadCR = UploadConfigurationRead.getInstance();
		assertEquals("‡∏‡∏¥ÌŒÛ¡À", "upload",uploadCR.getConfigItem("uploadFilePath") );
	}
}
