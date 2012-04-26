package org.usc.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 *
 * @author Shunli
 */
public class UploadConfigurationUtil {
	private static PropertiesConfiguration config;

	static {
		try {
			config = new PropertiesConfiguration("upload.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		config.setReloadingStrategy(new FileChangedReloadingStrategy());

	}

	public static PropertiesConfiguration getConfig() {
		return config;
	}
}
