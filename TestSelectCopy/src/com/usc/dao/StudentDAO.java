package com.usc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.dao.Student
 * @author MyEclipse Persistence Tools
 */

public class StudentDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(StudentDAO.class);
	// property constants
	public static final String SNO = "sno";
	public static final String SNAME = "sname";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String GNAME = "gname";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Student transientInstance)
	{
		log.debug("saving Student instance");
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

	public void delete(Student persistentInstance)
	{
		log.debug("deleting Student instance");
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

	public Student findById(java.lang.String id)
	{
		log.debug("getting Student instance with id: " + id);
		try
		{
			Student instance = (Student) getHibernateTemplate().get(
					"com.usc.dao.Student", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Student instance)
	{
		log.debug("finding Student instance by example");
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
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findBySno(Object sno)
	{
		return findByProperty(SNO, sno);
	}
	
	public List findBySname(Object sname)
	{
		return findByProperty(SNAME, sname);
	}

	public List findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age)
	{
		return findByProperty(AGE, age);
	}

	public List findByGname(Object gname)
	{
		return findByProperty(GNAME, gname);
	}

	public List findAll()
	{
		log.debug("finding all Student instances");
		try
		{
			String queryString = "from Student";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Student merge(Student detachedInstance)
	{
		log.debug("merging Student instance");
		try
		{
			Student result = (Student) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance)
	{
		log.debug("attaching dirty Student instance");
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

	public void attachClean(Student instance)
	{
		log.debug("attaching clean Student instance");
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

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}