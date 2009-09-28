package com.usc.util;

import java.util.List;

import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Use
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.usc.util.Use
 * @author MyEclipse Persistence Tools
 */

public class UseDAO extends HibernateDaoSupport
{
	
	private static final Log log = LogFactory.getLog(UseDAO.class);
	// property constants
	public static final String PASSWORD = "password";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Use transientInstance)
	{
		log.debug("saving Use instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Use persistentInstance)
	{
		log.debug("deleting Use instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public Use findById(java.lang.String id)
	{
		log.debug("getting Use instance with id: " + id);
		try
		{
			Use instance = (Use) getHibernateTemplate().get("com.usc.util.Use",
					id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Use instance)
	{
		log.debug("finding Use instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Use instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Use as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPassword(Object password)
	{
		return findByProperty(PASSWORD, password);
	}

	public List findAll()
	{
		log.debug("finding all Use instances");
		try
		{
			String queryString = "from Use";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Use merge(Use detachedInstance)
	{
		log.debug("merging Use instance");
		try
		{
			Use result = (Use) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Use instance)
	{
		log.debug("attaching dirty Use instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Use instance)
	{
		log.debug("attaching clean Use instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UseDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (UseDAO) ctx.getBean("UseDAO");
	}
}