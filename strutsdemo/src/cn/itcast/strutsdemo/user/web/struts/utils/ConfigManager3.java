package cn.itcast.strutsdemo.user.web.struts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager3 {
	/*private ConfigManager(){}
	private  static ConfigManager instance  = new ConfigManager();
	public static ConfigManager getInstance()
	{
		return instance;
	}*/
	
	private static String saveDir = null;


	static
	{
		Properties config = new Properties();
			try {
				InputStream configStream =ConfigManager3.class.getResourceAsStream("/itcast.properties");
				config.load(configStream);
				saveDir = config.getProperty("savedir");
				configStream.close();
				File saveFileDir = new File(saveDir);
				if(!saveFileDir.exists())
				{				
					saveFileDir.mkdirs();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static String getSaveDir()
	{
		return saveDir;
	}
}
