package com.usc.daos;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shiplist entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Shiplist
 * @author MyEclipse Persistence Tools
 */

public class ShiplistDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(ShiplistDAO.class);
	// property constants
	public static final String SHIPPER_MANAGER = "shipperManager";
	public static final String SHIP_LIST_STATE = "shipListState";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Shiplist transientInstance)
	{
		log.debug("saving Shiplist instance");
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

	public void delete(Shiplist persistentInstance)
	{
		log.debug("deleting Shiplist instance");
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

	public Shiplist findById(java.lang.Integer id)
	{
		log.debug("getting Shiplist instance with id: " + id);
		try
		{
			Shiplist instance = (Shiplist) getHibernateTemplate().get(
					"com.usc.daos.Shiplist", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shiplist instance)
	{
		log.debug("finding Shiplist instance by example");
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
		log.debug("finding Shiplist instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Shiplist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShipperManager(Object shipperManager)
	{
		return findByProperty(SHIPPER_MANAGER, shipperManager);
	}

	public List findByShipListState(Object shipListState)
	{
		return findByProperty(SHIP_LIST_STATE, shipListState);
	}

	public List findAll()
	{
		log.debug("finding all Shiplist instances");
		try
		{
			String queryString = "from Shiplist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shiplist merge(Shiplist detachedInstance)
	{
		log.debug("merging Shiplist instance");
		try
		{
			Shiplist result = (Shiplist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shiplist instance)
	{
		log.debug("attaching dirty Shiplist instance");
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

	public void attachClean(Shiplist instance)
	{
		log.debug("attaching clean Shiplist instance");
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

	public static ShiplistDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (ShiplistDAO) ctx.getBean("ShiplistDAO");
	}
}