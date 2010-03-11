package com.usc.daos;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Stock
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.usc.daos.Stock
 * @author MyEclipse Persistence Tools
 */

public class StockDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(StockDAO.class);
	// property constants
	public static final String STOCK_QUANTITY = "stockQuantity";
	public static final String FACT_STOCK_QUANTITY = "factStockQuantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Stock transientInstance)
	{
		log.debug("saving Stock instance");
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

	public void delete(Stock persistentInstance)
	{
		log.debug("deleting Stock instance");
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

	public Stock findById(java.lang.Integer id)
	{
		log.debug("getting Stock instance with id: " + id);
		try
		{
			Stock instance = (Stock) getHibernateTemplate().get(
					"com.usc.daos.Stock", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stock instance)
	{
		log.debug("finding Stock instance by example");
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
		log.debug("finding Stock instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Stock as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStockQuantity(Object stockQuantity)
	{
		return findByProperty(STOCK_QUANTITY, stockQuantity);
	}

	public List findByFactStockQuantity(Object factStockQuantity)
	{
		return findByProperty(FACT_STOCK_QUANTITY, factStockQuantity);
	}

	public List findAll()
	{
		log.debug("finding all Stock instances");
		try
		{
			String queryString = "from Stock";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stock merge(Stock detachedInstance)
	{
		log.debug("merging Stock instance");
		try
		{
			Stock result = (Stock) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stock instance)
	{
		log.debug("attaching dirty Stock instance");
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

	public void attachClean(Stock instance)
	{
		log.debug("attaching clean Stock instance");
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

	public static StockDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (StockDAO) ctx.getBean("StockDAO");
	}
}