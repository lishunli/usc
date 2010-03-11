package com.usc.daos;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Commodity entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Commodity
 * @author MyEclipse Persistence Tools
 */

public class CommodityDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(CommodityDAO.class);
	// property constants
	public static final String DISCOUNT = "discount";
	public static final String SALE_FLAG = "saleFlag";
	public static final String  PRODUCTSID ="productsID";
	
	protected void initDao()
	{
		// do nothing
	}

	public void save(Commodity transientInstance)
	{
		log.debug("saving Commodity instance");
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

	public void delete(Commodity persistentInstance)
	{
		log.debug("deleting Commodity instance");
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

	public Commodity findById(java.lang.Integer id)
	{
		log.debug("getting Commodity instance with id: " + id);
		try
		{
			Commodity instance = (Commodity) getHibernateTemplate().get(
					"com.usc.daos.Commodity", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commodity instance)
	{
		log.debug("finding Commodity instance by example");
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
		log.debug("finding Commodity instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Commodity as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDiscount(Object discount)
	{
		return findByProperty(DISCOUNT, discount);
	}
	
	public List<Commodity> findByProductsID(Object productsID)
	{
		return findByProperty(PRODUCTSID, productsID);
	}

	public List findBySaleFlag(Object saleFlag)
	{
		return findByProperty(SALE_FLAG, saleFlag);
	}

	public List findAll()
	{
		log.debug("finding all Commodity instances");
		try
		{
			String queryString = "from Commodity";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commodity merge(Commodity detachedInstance)
	{
		log.debug("merging Commodity instance");
		try
		{
			Commodity result = (Commodity) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commodity instance)
	{
		log.debug("attaching dirty Commodity instance");
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

	public void attachClean(Commodity instance)
	{
		log.debug("attaching clean Commodity instance");
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

	public static CommodityDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (CommodityDAO) ctx.getBean("CommodityDAO");
	}
}