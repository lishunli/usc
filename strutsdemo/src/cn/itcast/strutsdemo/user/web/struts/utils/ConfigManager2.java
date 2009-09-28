package cn.itcast.strutsdemo.user.web.struts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager2 {

	
	private String saveDir = null;

	public ConfigManager2(String configPath)
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

	public String getSaveDir()
	{
		return saveDir;
	}
}
