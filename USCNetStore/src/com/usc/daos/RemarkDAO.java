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
 * Remark entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Remark
 * @author MyEclipse Persistence Tools
 */

public class RemarkDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(RemarkDAO.class);
	// property constants
	public static final String REMARK_CONTENTS = "remarkContents";
	public static final String REMARK_FLAG = "remarkFlag";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Remark transientInstance)
	{
		log.debug("saving Remark instance");
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

	public void delete(Remark persistentInstance)
	{
		log.debug("deleting Remark instance");
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

	public Remark findById(java.lang.Integer id)
	{
		log.debug("getting Remark instance with id: " + id);
		try
		{
			Remark instance = (Remark) getHibernateTemplate().get(
					"com.usc.daos.Remark", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Remark instance)
	{
		log.debug("finding Remark instance by example");
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
		log.debug("finding Remark instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Remark as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRemarkContents(Object remarkContents)
	{
		return findByProperty(REMARK_CONTENTS, remarkContents);
	}

	public List findByRemarkFlag(Object remarkFlag)
	{
		return findByProperty(REMARK_FLAG, remarkFlag);
	}

	public List findAll()
	{
		log.debug("finding all Remark instances");
		try
		{
			String queryString = "from Remark";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Remark merge(Remark detachedInstance)
	{
		log.debug("merging Remark instance");
		try
		{
			Remark result = (Remark) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Remark instance)
	{
		log.debug("attaching dirty Remark instance");
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

	public void attachClean(Remark instance)
	{
		log.debug("attaching clean Remark instance");
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

	public static RemarkDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (RemarkDAO) ctx.getBean("RemarkDAO");
	}
}