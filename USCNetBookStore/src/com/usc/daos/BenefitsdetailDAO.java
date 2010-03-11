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
 * Benefitsdetail entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.usc.daos.Benefitsdetail
 * @author MyEclipse Persistence Tools
 */

public class BenefitsdetailDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(BenefitsdetailDAO.class);
	// property constants
	public static final String LAST = "last";
	public static final String CURRENT = "current";
	public static final String EXPLANATION = "explanation";
	public static final String TYPE = "type";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Benefitsdetail transientInstance)
	{
		log.debug("saving Benefitsdetail instance");
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

	public void delete(Benefitsdetail persistentInstance)
	{
		log.debug("deleting Benefitsdetail instance");
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

	public Benefitsdetail findById(java.lang.Integer id)
	{
		log.debug("getting Benefitsdetail instance with id: " + id);
		try
		{
			Benefitsdetail instance = (Benefitsdetail) getHibernateTemplate()
					.get("com.usc.daos.Benefitsdetail", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Benefitsdetail instance)
	{
		log.debug("finding Benefitsdetail instance by example");
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
		log.debug("finding Benefitsdetail instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from Benefitsdetail as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLast(Object last)
	{
		return findByProperty(LAST, last);
	}

	public List findByCurrent(Object current)
	{
		return findByProperty(CURRENT, current);
	}

	public List findByExplanation(Object explanation)
	{
		return findByProperty(EXPLANATION, explanation);
	}

	public List findByType(Object type)
	{
		return findByProperty(TYPE, type);
	}

	public List findAll()
	{
		log.debug("finding all Benefitsdetail instances");
		try
		{
			String queryString = "from Benefitsdetail";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Benefitsdetail merge(Benefitsdetail detachedInstance)
	{
		log.debug("merging Benefitsdetail instance");
		try
		{
			Benefitsdetail result = (Benefitsdetail) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Benefitsdetail instance)
	{
		log.debug("attaching dirty Benefitsdetail instance");
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

	public void attachClean(Benefitsdetail instance)
	{
		log.debug("attaching clean Benefitsdetail instance");
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

	public static BenefitsdetailDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (BenefitsdetailDAO) ctx.getBean("BenefitsdetailDAO");
	}
}