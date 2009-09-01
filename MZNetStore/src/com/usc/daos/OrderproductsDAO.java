package com.usc.daos;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderproducts entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.usc.daos.Orderproducts
 * @author MyEclipse Persistence Tools
 */

public class OrderproductsDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(OrderproductsDAO.class);
	// property constants
	public static final String COMMODITY_ID = "commodityId";
	public static final String SHOPPING_PRICE = "shoppingPrice";
	public static final String QUANTITY = "quantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Orderproducts transientInstance)
	{
		log.debug("saving Orderproducts instance");
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

	public void delete(Orderproducts persistentInstance)
	{
		log.debug("deleting Orderproducts instance");
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

	public Orderproducts findById(java.lang.Integer id)
	{
		log.debug("getting Orderproducts instance with id: " + id);
		try
		{
			Orderproducts instance = (Orderproducts) getHibernateTemplate()
					.get("com.usc.daos.Orderproducts", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderproducts instance)
	{
		log.debug("finding Orderproducts instance by example");
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
		log.debug("finding Orderproducts instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from Orderproducts as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCommodityId(Object commodityId)
	{
		return findByProperty(COMMODITY_ID, commodityId);
	}

	public List findByShoppingPrice(Object shoppingPrice)
	{
		return findByProperty(SHOPPING_PRICE, shoppingPrice);
	}

	public List findByQuantity(Object quantity)
	{
		return findByProperty(QUANTITY, quantity);
	}

	public List findAll()
	{
		log.debug("finding all Orderproducts instances");
		try
		{
			String queryString = "from Orderproducts";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderproducts merge(Orderproducts detachedInstance)
	{
		log.debug("merging Orderproducts instance");
		try
		{
			Orderproducts result = (Orderproducts) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderproducts instance)
	{
		log.debug("attaching dirty Orderproducts instance");
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

	public void attachClean(Orderproducts instance)
	{
		log.debug("attaching clean Orderproducts instance");
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

	public static OrderproductsDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (OrderproductsDAO) ctx.getBean("OrderproductsDAO");
	}
}