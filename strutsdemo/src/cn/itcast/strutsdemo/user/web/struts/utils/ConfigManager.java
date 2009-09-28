package cn.itcast.strutsdemo.user.web.struts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	/*private ConfigManager(){}
	private  static ConfigManager instance  = new ConfigManager();
	public static ConfigManager getInstance()
	{
		return instance;
	}*/
	
	private static String saveDir = null;


	public static String getSaveDir(String configPath)
	{
		if(saveDir==null)
		{
			Properties config = new Properties();
			try {
				FileInputStream fis = new FileInputStream(configPath);
				config.load(fis);
				saveDir = config.getProperty("savedir");
				fis.close();
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
		return saveDir;
	}
}
