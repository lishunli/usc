package org.usc.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 读取Ibatis3配置文件并获取SqlSessionFactory和SqlSession
 * 
 * @author ShunLi
 * @Time 2010-1-1
 */
public class SqlMapUtils
{
	private static final Logger logger = LogManager.getLogger(SqlMapUtils.class);

	private static final String CONFIG_FILE_PATH = "org/usc/confs/SqlmapConfiguration.xml";

	private SqlSessionFactory sqlSessionFactory = null;
	private SqlSession session = null;
	private static SqlMapUtils instance = null;

	/**
	 * iBATIS 2中的SqlMapClient被SqlSession所替代， 而iBATIS2
	 * 中的静态类SqlMapClientBuilder也被SqlSessionFactoryBuilder所替代，
	 * 变为了非静态的，此外最重要的是iBATIS3中需要使用openSession()方法来
	 * 返回SqlSession的实例，至于上述代码中build方法的第二参数 “development_mysql”是环境配置ID
	 */
	private SqlMapUtils()
	{
		Reader reader = null;
		try
		{
			reader = Resources.getResourceAsReader(CONFIG_FILE_PATH);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development_mysql");
			session = sqlSessionFactory.openSession();
		}
		catch (IOException e)
		{
			logger.fatal("IO Exception occured while reading the Configuration File \n" + e);
		}
		catch (Exception e)
		{
			logger.fatal("Exception occured.");
			e.printStackTrace();
		}
		finally
		{

			try
			{
				if (reader != null)
				{
					reader.close();
					reader = null;
				}
			}
			catch (Exception e)
			{
				logger.fatal("Close reader failed.\n" + e);
			}
		}
	}

	/**
	 * 单例模式获取对象的实例
	 * 
	 * @return 返回 SqlMapUtils 的实例
	 */
	public static synchronized SqlMapUtils getInstance()
	{
		if (instance == null)
		{
			synchronized (SqlMapUtils.class)
			{
				instance = new SqlMapUtils();
			}
			System.out.println("123111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111dd");
		}

		return instance;
	}

	/**
	 * 
	 * @return
	 */
	public SqlSession getSession()
	{
		if (session == null)
		{
			throw new RuntimeException("Create SqlSession failed.");
		}

		return session;
	}

}
