package org.usc.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class HibernateUtil
{

	private static final SessionFactory sessionFactory;

	static
	{
		try
		{
			// 用xxx.hbm.xml形式配置实体映射
			// sessionFactory = new Configuration().configure().buildSessionFactory();
			// 用Annotation形式配置实体映射
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}