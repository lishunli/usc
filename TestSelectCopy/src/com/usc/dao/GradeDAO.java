package com.usc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Grade
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.usc.dao.Grade
 * @author MyEclipse Persistence Tools
 */

public class GradeDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(GradeDAO.class);
	// property constants
	public static final String GNAME = "gname";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Grade transientInstance)
	{
		log.debug("saving Grade instance");
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

	public void delete(Grade persistentInstance)
	{
		log.debug("deleting Grade instance");
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

	public Grade findById(java.lang.Integer id)
	{
		log.debug("getting Grade instance with id: " + id);
		try
		{
			Grade instance = (Grade) getHibernateTemplate().get(
					"com.usc.dao.Grade", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Grade instance)
	{
		log.debug("finding Grade instance by example");
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
		log.debug("finding Grade instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Grade as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGname(Object gname)
	{
		return findByProperty(GNAME, gname);
	}

	public List findAll()
	{
		log.debug("finding all Grade instances");
		try
		{
			String queryString = "from Grade";
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Grade merge(Grade detachedInstance)
	{
		log.debug("merging Grade instance");
		try
		{
			Grade result = (Grade) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Grade instance)
	{
		log.debug("attaching dirty Grade instance");
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

	public void attachClean(Grade instance)
	{
		log.debug("attaching clean Grade instance");
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

	public static GradeDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (GradeDAO) ctx.getBean("GradeDAO");
	}
}