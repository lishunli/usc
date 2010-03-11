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
 * Latencyorderform entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.usc.daos.Latencyorderform
 * @author MyEclipse Persistence Tools
 */

public class LatencyorderformDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(LatencyorderformDAO.class);
	// property constants
	public static final String REAL_NAME = "realName";
	public static final String ADDRESS = "address";
	public static final String POST_CODE = "postCode";
	public static final String MOBILE = "mobile";
	public static final String PHONE = "phone";
	public static final String COMMODITY_NAME = "commodityName";
	public static final String QUANTITY = "quantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Latencyorderform transientInstance)
	{
		log.debug("saving Latencyorderform instance");
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

	public void delete(Latencyorderform persistentInstance)
	{
		log.debug("deleting Latencyorderform instance");
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

	public Latencyorderform findById(java.lang.Integer id)
	{
		log.debug("getting Latencyorderform instance with id: " + id);
		try
		{
			Latencyorderform instance = (Latencyorderform) getHibernateTemplate()
					.get("com.usc.daos.Latencyorderform", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Latencyorderform instance)
	{
		log.debug("finding Latencyorderform instance by example");
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
		log.debug("finding Latencyorderform instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from Latencyorderform as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRealName(Object realName)
	{
		return findByProperty(REAL_NAME, realName);
	}

	public List findByAddress(Object address)
	{
		return findByProperty(ADDRESS, address);
	}

	public List findByPostCode(Object postCode)
	{
		return findByProperty(POST_CODE, postCode);
	}

	public List findByMobile(Object mobile)
	{
		return findByProperty(MOBILE, mobile);
	}

	public List findByPhone(Object phone)
	{
		return findByProperty(PHONE, phone);
	}

	public List findByCommodityName(Object commodityName)
	{
		return findByProperty(COMMODITY_NAME, commodityName);
	}

	public List findByQuantity(Object quantity)
	{
		return findByProperty(QUANTITY, quantity);
	}

	public List findAll()
	{
		log.debug("finding all Latencyorderform instances");
		try
		{
			String queryString = "from Latencyorderform";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Latencyorderform merge(Latencyorderform detachedInstance)
	{
		log.debug("merging Latencyorderform instance");
		try
		{
			Latencyorderform result = (Latencyorderform) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Latencyorderform instance)
	{
		log.debug("attaching dirty Latencyorderform instance");
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

	public void attachClean(Latencyorderform instance)
	{
		log.debug("attaching clean Latencyorderform instance");
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

	public static LatencyorderformDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (LatencyorderformDAO) ctx.getBean("LatencyorderformDAO");
	}
}