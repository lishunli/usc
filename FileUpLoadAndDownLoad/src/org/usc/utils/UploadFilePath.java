package org.usc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class UploadFilePath
{
	public static  Properties p = new Properties();
	static
	{
		try
		{
			p.load(UploadFilePath.class.getClassLoader().getResourceAsStream("upload.properties"));//��������ļ�
		} catch (IOException e)
		{
			//e.printStackTrace();
		}
	}
	
}
