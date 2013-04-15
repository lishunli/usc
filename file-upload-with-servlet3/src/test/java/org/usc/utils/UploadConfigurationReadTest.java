package org.usc.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class UploadConfigurationReadTest {
    @Ignore
    @Test
    public void testUploadConfigurationRead() {
        UploadConfigurationRead uploadCR = UploadConfigurationRead.getInstance();
        assertEquals("喔喔错误了", "upload", uploadCR.getConfigItem("uploadFilePath"));
    }
}
