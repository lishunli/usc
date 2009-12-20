package org.usc.tankwar.client;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr
{
	static Properties p = new Properties();
	static
	{
		try
		{
			p.load(PropertyMgr.class.getClassLoader().getResourceAsStream(
					"config/tank.properties"));

		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}

	public static String getProperty(String key)
	{

		return p.getProperty(key);
	}
}
