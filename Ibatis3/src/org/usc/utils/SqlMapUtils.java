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
	/**
	 * 日志管理器
	 */
	private static final Logger logger = LogManager.getLogger(SqlMapUtils.class);

	/**
	 * SqlmapConfiguration配置文件路径
	 */
	private static final String CONFIG_FILE_PATH = "org/usc/confs/SqlmapConfiguration.xml";

	/**
	 * SqlSessionFactory
	 */
	private SqlSessionFactory sqlSessionFactory = null;
	/**
	 * SqlSession
	 */
	private SqlSession session = null;
	/**
	 * 静态的实例化对象
	 */
	private static SqlMapUtils instance = null;

	/**
	 * iBATIS 2中的SqlMapClient被SqlSession所替代， 而iBATIS2
	 * 中的静态类SqlMapClientBuilder也被SqlSessionFactoryBuilder所替代，
	 * 变为了非静态的，此外最重要的是iBATIS3中需要使用openSession()方法来
	 * 返回SqlSession的实例，至于上述代码中build方法的第二参数 “development_mysql”是环境配置ID
	 */
	/**
	 * 私有的构造
	 */
	private SqlMapUtils()
	{
		Reader reader = null;
		try
		{
			reader = Resources.getResourceAsReader(CONFIG_FILE_PATH);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			/**
			 * 需要注意的是如果TransactionType设置JDBC的话，iBATIS 3默认Auto Commit为false,
			 * 所以在执行完持久化操作后，需要调用session.commit()方法来提交事务，或是首先
			 * 调用session.getConnection().setAutoCommit(true)来设置Auto Commit策略
			 */
			session.getConnection().setAutoCommit(true);
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
		}

		return instance;
	}

	/**
	 * 获得SqlSession
	 * 
	 * @return SqlSession
	 */
	public SqlSession getSession()
	{
		if (session == null)
		{
			throw new RuntimeException("Create SqlSession failed.");
		}

		return session;
	}

	// public static void main(String[] args)
	// {
	// SqlSession session = SqlMapUtils.getInstance().getSession();
	//
	// }

}
