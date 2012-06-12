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
         assertEquals("0 0/10 * * * ?", Config.getProperty("sns_sync_job_cron"));
        assertEquals("/usr/local/lishunli/logs/", Constants.LOG_DIR);
    }
}
