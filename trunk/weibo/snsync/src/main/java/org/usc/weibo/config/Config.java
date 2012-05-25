package org.usc.weibo.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
	protected static final Properties prop = new Properties();

	static {
		try {
			InputStream in = Config.class.getResourceAsStream("/youxiweibo-config.properties");
			if (in != null) {
				prop.load(in);
				in.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
