package com.usc.manager;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.usc.util.Use;
import com.usc.util.UseDAO;

public class usermanagerImpl extends HibernateDaoSupport implements usermanager
{
	private UseDAO  dao;
	
	public void setDao(UseDAO dao)
	{
		this.dao = dao;
	}

		
	
	public void addUser(Use use)
	{
//		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
//		UseDAO dao = (UseDAO)factory.getBean("UseDAO");
		dao.save(use);
//		try
//		{
//			this.getHibernateTemplate().save(use);
//		} catch (Exception e)
//		{
//			// 记录日志,log4j等......
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
		
	}

}
