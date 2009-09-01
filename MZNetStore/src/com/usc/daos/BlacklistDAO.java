package com.usc.daos;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Blacklist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Blacklist
 * @author MyEclipse Persistence Tools
 */

public class BlacklistDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(BlacklistDAO.class);
	// property constants
	public static final String UN_ORDER_TIMES = "unOrderTimes";
	public static final String UN_REMARK_TIMES = "unRemarkTimes";
	public static final String UN_ACCEPT_TIMES = "unAcceptTimes";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Blacklist transientInstance)
	{
		log.debug("saving Blacklist instance");
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

	public void delete(Blacklist persistentInstance)
	{
		log.debug("deleting Blacklist instance");
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

	public Blacklist findById(java.lang.Integer id)
	{
		log.debug("getting Blacklist instance with id: " + id);
		try
		{
			Blacklist instance = (Blacklist) getHibernateTemplate().get(
					"com.usc.daos.Blacklist", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Blacklist instance)
	{
		log.debug("finding Blacklist instance by example");
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
		log.debug("finding Blacklist instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Blacklist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUnOrderTimes(Object unOrderTimes)
	{
		return findByProperty(UN_ORDER_TIMES, unOrderTimes);
	}

	public List findByUnRemarkTimes(Object unRemarkTimes)
	{
		return findByProperty(UN_REMARK_TIMES, unRemarkTimes);
	}

	public List findByUnAcceptTimes(Object unAcceptTimes)
	{
		return findByProperty(UN_ACCEPT_TIMES, unAcceptTimes);
	}

	public List findAll()
	{
		log.debug("finding all Blacklist instances");
		try
		{
			String queryString = "from Blacklist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Blacklist merge(Blacklist detachedInstance)
	{
		log.debug("merging Blacklist instance");
		try
		{
			Blacklist result = (Blacklist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Blacklist instance)
	{
		log.debug("attaching dirty Blacklist instance");
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

	public void attachClean(Blacklist instance)
	{
		log.debug("attaching clean Blacklist instance");
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

	public static BlacklistDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (BlacklistDAO) ctx.getBean("BlacklistDAO");
	}
}