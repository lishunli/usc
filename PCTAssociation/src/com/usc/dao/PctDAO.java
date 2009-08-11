package com.usc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Pct
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.usc.dao.Pct
 * @author MyEclipse Persistence Tools
 */

public class PctDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(PctDAO.class);
	// property constants
	public static final String PCTID = "pctid";
	public static final String PCTNAME = "pctname";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Pct transientInstance)
	{
		log.debug("saving Pct instance");
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

	public void delete(Pct persistentInstance)
	{
		log.debug("deleting Pct instance");
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

	public Pct findById(java.lang.Integer id)
	{
		log.debug("getting Pct instance with id: " + id);
		try
		{
			Pct instance = (Pct) getHibernateTemplate().get("com.usc.dao.Pct",
					id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pct instance)
	{
		log.debug("finding Pct instance by example");
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
		log.debug("finding Pct instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Pct as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPctid(Object pctid)
	{
		return findByProperty(PCTID, pctid);
	}

	public List findByPctname(Object pctname)
	{
		return findByProperty(PCTNAME, pctname);
	}

	public List findAll()
	{
		log.debug("finding all Pct instances");
		try
		{
			String queryString = "from Pct";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pct merge(Pct detachedInstance)
	{
		log.debug("merging Pct instance");
		try
		{
			Pct result = (Pct) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pct instance)
	{
		log.debug("attaching dirty Pct instance");
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

	public void attachClean(Pct instance)
	{
		log.debug("attaching clean Pct instance");
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

	public static PctDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (PctDAO) ctx.getBean("PctDAO");
	}
}