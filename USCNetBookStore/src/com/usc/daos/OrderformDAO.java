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
 * Orderform entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Orderform
 * @author MyEclipse Persistence Tools
 */

public class OrderformDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(OrderformDAO.class);
	// property constants
	public static final String REAL_NAME = "realName";
	public static final String ADDRESS = "address";
	public static final String POST_CODE = "postCode";
	public static final String MOBILE = "mobile";
	public static final String PHONE = "phone";
	public static final String ORDER_FORM_STATE = "orderFormState";
	public static final String CARGO_LIST_ID = "cargoListId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Orderform transientInstance)
	{
		log.debug("saving Orderform instance");
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

	public void delete(Orderform persistentInstance)
	{
		log.debug("deleting Orderform instance");
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

	public Orderform findById(java.lang.Integer id)
	{
		log.debug("getting Orderform instance with id: " + id);
		try
		{
			Orderform instance = (Orderform) getHibernateTemplate().get(
					"com.usc.daos.Orderform", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderform instance)
	{
		log.debug("finding Orderform instance by example");
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
		log.debug("finding Orderform instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Orderform as model where model."
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

	public List findByOrderFormState(Object orderFormState)
	{
		return findByProperty(ORDER_FORM_STATE, orderFormState);
	}

	public List findByCargoListId(Object cargoListId)
	{
		return findByProperty(CARGO_LIST_ID, cargoListId);
	}

	public List findAll()
	{
		log.debug("finding all Orderform instances");
		try
		{
			String queryString = "from Orderform";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderform merge(Orderform detachedInstance)
	{
		log.debug("merging Orderform instance");
		try
		{
			Orderform result = (Orderform) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderform instance)
	{
		log.debug("attaching dirty Orderform instance");
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

	public void attachClean(Orderform instance)
	{
		log.debug("attaching clean Orderform instance");
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

	public static OrderformDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (OrderformDAO) ctx.getBean("OrderformDAO");
	}
}