package com.usc.daos;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Operator entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Operator
 * @author MyEclipse Persistence Tools
 */

public class OperatorDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(OperatorDAO.class);
	// property constants
	public static final String OPERATOR_NAME = "operatorName";
	public static final String OPERATOR_PASS = "operatorPass";
	public static final String OPERATOR_SEX = "operatorSex";
	public static final String OPERATOR_TYPE = "operatorType";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Operator transientInstance)
	{
		log.debug("saving Operator instance");
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

	public void delete(Operator persistentInstance)
	{
		log.debug("deleting Operator instance");
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

	public Operator findById(java.lang.Integer id)
	{
		log.debug("getting Operator instance with id: " + id);
		try
		{
			Operator instance = (Operator) getHibernateTemplate().get(
					"com.usc.daos.Operator", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Operator instance)
	{
		log.debug("finding Operator instance by example");
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
		log.debug("finding Operator instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Operator as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Operator> findByOperatorName(Object operatorName)
	{
		return findByProperty(OPERATOR_NAME, operatorName);
	}

	public List findByOperatorPass(Object operatorPass)
	{
		return findByProperty(OPERATOR_PASS, operatorPass);
	}

	public List findByOperatorSex(Object operatorSex)
	{
		return findByProperty(OPERATOR_SEX, operatorSex);
	}

	public List findByOperatorType(Object operatorType)
	{
		return findByProperty(OPERATOR_TYPE, operatorType);
	}

	public List findAll()
	{
		log.debug("finding all Operator instances");
		try
		{
			String queryString = "from Operator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Operator merge(Operator detachedInstance)
	{
		log.debug("merging Operator instance");
		try
		{
			Operator result = (Operator) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Operator instance)
	{
		log.debug("attaching dirty Operator instance");
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

	public void attachClean(Operator instance)
	{
		log.debug("attaching clean Operator instance");
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

	public static OperatorDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (OperatorDAO) ctx.getBean("OperatorDAO");
	}
}