package com.usc.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.usc.util.Users;

public class userManagerImpl extends HibernateDaoSupport implements userManager
{

	public void addUser(Users user)
	{
		try
		{
			this.getHibernateTemplate().save(user);
		} catch (Exception e)
		{
			// 记录日志,log4j等......
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@SuppressWarnings("unchecked")
	public boolean checkUser(final Users user)
	{
		List itemList = new ArrayList();
		itemList = this.getHibernateTemplate().executeFind(
				new HibernateCallback()
				{

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException
					{
						return session.createQuery(
								"from Users a where a.uname = ?").setParameter(
								0, user.getUname()).list();

					}
				});
		if (itemList.size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	public boolean checkLogin(final Users user)
	{
		List itemList = new ArrayList();
		itemList = this.getHibernateTemplate().executeFind(
				new HibernateCallback()
				{

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException
					{
						return session
								.createQuery("from Users a where a.uname = ? and a.upass = ? ")
								.setParameter(0, user.getUname())
								.setParameter(1, user.getUpass())
								.list();

					}
				});
		if (itemList.size() > 0)
			return true;
		else
			return false;
	}

}
