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
 * Suggestion entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Suggestion
 * @author MyEclipse Persistence Tools
 */

public class SuggestionDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(SuggestionDAO.class);
	// property constants
	public static final String COLUMN_NAME = "columnName";
	public static final String SUGGESTION_CONTENTS = "suggestionContents";
	public static final String SUGGESTION_FLAG = "suggestionFlag";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Suggestion transientInstance)
	{
		log.debug("saving Suggestion instance");
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

	public void delete(Suggestion persistentInstance)
	{
		log.debug("deleting Suggestion instance");
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

	public Suggestion findById(java.lang.Integer id)
	{
		log.debug("getting Suggestion instance with id: " + id);
		try
		{
			Suggestion instance = (Suggestion) getHibernateTemplate().get(
					"com.usc.daos.Suggestion", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Suggestion instance)
	{
		log.debug("finding Suggestion instance by example");
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
		log.debug("finding Suggestion instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Suggestion as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByColumnName(Object columnName)
	{
		return findByProperty(COLUMN_NAME, columnName);
	}

	public List findBySuggestionContents(Object suggestionContents)
	{
		return findByProperty(SUGGESTION_CONTENTS, suggestionContents);
	}

	public List findBySuggestionFlag(Object suggestionFlag)
	{
		return findByProperty(SUGGESTION_FLAG, suggestionFlag);
	}

	public List findAll()
	{
		log.debug("finding all Suggestion instances");
		try
		{
			String queryString = "from Suggestion";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Suggestion merge(Suggestion detachedInstance)
	{
		log.debug("merging Suggestion instance");
		try
		{
			Suggestion result = (Suggestion) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Suggestion instance)
	{
		log.debug("attaching dirty Suggestion instance");
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

	public void attachClean(Suggestion instance)
	{
		log.debug("attaching clean Suggestion instance");
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

	public static SuggestionDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (SuggestionDAO) ctx.getBean("SuggestionDAO");
	}
}