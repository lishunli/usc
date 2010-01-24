package org.usc.daos;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 基础HibernateDaoSupport，主要是为了注入SessionFactory
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-1-17<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class BaseHibernateDaoSupport extends HibernateDaoSupport
{
	@Resource(name = "sessionFactory")
	// 为父类HibernateDaoSupport注入sessionFactory的值
	public void setSuperSessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
}
