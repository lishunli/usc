package com.usc.daos;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shoppingcart entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.usc.daos.Shoppingcart
 * @author MyEclipse Persistence Tools
 */

public class ShoppingcartDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(ShoppingcartDAO.class);
	// property constants
	public static final String SHOPPING_PRICE = "shoppingPrice";
	public static final String QUANTITY = "quantity";

	protected void initDao()
	{
		// do nothing
	}

	public void update(Shoppingcart shoppingcart,int  quantity)
	{
		shoppingcart.setQuantity(quantity);
		getHibernateTemplate().update(shoppingcart);
	}
	
/*	public Shoppingcart findByIdName(Integer commodityId,String customName)
	{
		String queryString = "from Shoppingcart as s where s.commodityId=commodityId and s.customName='"+customName+"'";
	return (Shoppingcart)getHibernateTemplate().find(queryString).get(1);

	}*/
	
	public List<Shoppingcart> findByCustomName(String customName)
	{
		String queryString = "from Shoppingcart as s where s.customName=?";
		return getHibernateTemplate().find(queryString,customName);
	}
	
	
	
	public void save(Shoppingcart transientInstance)
	{
		log.debug("saving Shoppingcart instance");
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

	public void delete(Shoppingcart persistentInstance)
	{
		log.debug("deleting Shoppingcart instance");
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

	public Shoppingcart findById(java.lang.Integer id)
	{
		log.debug("getting Shoppingcart instance with id: " + id);
		try
		{
			Shoppingcart instance = (Shoppingcart) getHibernateTemplate().get(
					"com.usc.daos.Shoppingcart", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shoppingcart instance)
	{
		log.debug("finding Shoppingcart instance by example");
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
		log.debug("finding Shoppingcart instance with property: "
				+ propertyName + ", value: " + value);
		try
		{
			String queryString = "from Shoppingcart as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
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
		log.debug("finding all Shoppingcart instances");
		try
		{
			String queryString = "from Shoppingcart";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shoppingcart merge(Shoppingcart detachedInstance)
	{
		log.debug("merging Shoppingcart instance");
		try
		{
			Shoppingcart result = (Shoppingcart) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shoppingcart instance)
	{
		log.debug("attaching dirty Shoppingcart instance");
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

	public void attachClean(Shoppingcart instance)
	{
		log.debug("attaching clean Shoppingcart instance");
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

	public static ShoppingcartDAO getFromApplicationContext(
			ApplicationContext ctx)
	{
		return (ShoppingcartDAO) ctx.getBean("ShoppingcartDAO");
	}
}