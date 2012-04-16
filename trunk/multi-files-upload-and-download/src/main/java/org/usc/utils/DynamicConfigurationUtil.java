package org.usc.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 *
 * @author Shunli
 */
public class DynamicConfigurationUtil {
    private static PropertiesConfiguration config;

    static {
        try {
            config = new PropertiesConfiguration("upload.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        config.setReloadingStrategy(new FileChangedReloadingStrategy());

    }

    public static String getProperty(String key) {
        return config.getString(key);

    }

    public static String getProperty(String key, String defaults) {
        return config.getString(key, defaults);
    }

}
