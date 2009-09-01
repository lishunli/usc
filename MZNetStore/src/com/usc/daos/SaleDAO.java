package com.usc.daos;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Sale
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.usc.daos.Sale
 * @author MyEclipse Persistence Tools
 */

public class SaleDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(SaleDAO.class);
	// property constants
	public static final String SALE_PRICE = "salePrice";
	public static final String PRIORITY = "priority";
	public static final String COMMODITYID="commodityId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Sale transientInstance)
	{
		log.debug("saving Sale instance");
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

	public void delete(Sale persistentInstance)
	{
		log.debug("deleting Sale instance");
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

	public Sale findById(java.lang.Integer id)
	{
		log.debug("getting Sale instance with id: " + id);
		try
		{
			Sale instance = (Sale) getHibernateTemplate().get(
					"com.usc.daos.Sale", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sale instance)
	{
		log.debug("finding Sale instance by example");
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
		log.debug("finding Sale instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Sale as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySalePrice(Object salePrice)
	{
		return findByProperty(SALE_PRICE, salePrice);
	}
	/**
	 * 根据商品ID找促销商品
	 * @param commodityId
	 * @return
	 */
	public List<Sale> findByCommodityId(Object commodityId)
	{
		return findByProperty(COMMODITYID, commodityId);
	}

	
	public List<Sale> findByPriority(Object priority)
	{
		return findByProperty(PRIORITY, priority);
	}

	public List<Sale> findAll()
	{
		log.debug("finding all Sale instances");
		try
		{
			String queryString = "from Sale";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 促销商品按优先级进行查找全部（优先级小数的为高优先级）
	 * @param detachedInstance
	 * @return
	 */
	public List<Sale> findAllBySort()
	{
		log.debug("finding all Sale instances");
		try
		{
			String queryString = "from Sale as s Order by s.priority";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Sale merge(Sale detachedInstance)
	{
		log.debug("merging Sale instance");
		try
		{
			Sale result = (Sale) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sale instance)
	{
		log.debug("attaching dirty Sale instance");
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

	public void attachClean(Sale instance)
	{
		log.debug("attaching clean Sale instance");
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

	public static SaleDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (SaleDAO) ctx.getBean("SaleDAO");
	}
}