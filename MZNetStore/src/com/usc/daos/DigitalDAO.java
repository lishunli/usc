package com.usc.daos;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Digital entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Digital
 * @author MyEclipse Persistence Tools
 */

public class DigitalDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(DigitalDAO.class);
	// property constants
	public static final String DIGITAL_NAME = "digitalName";
	public static final String PUBLISHED_PRICE = "publishedPrice";
	public static final String MANUFACTURER = "manufacturer";
	public static final String BRAND = "brand";
	public static final String MODEL_NUMBER = "modelNumber";
	public static final String PARAMETER = "parameter";
	public static final String BARCODE = "barcode";
	public static final String PHOTO = "photo";
	public static final String DESCRIPTION = "description";
	public static final String SPECIAL_EXPLANATION = "specialExplanation";
	public static final String PRODUCTS_PFLAG = "productsPflag";

	protected void initDao()
	{
		// do nothing
	}
	
	
	
/*	public Digital findByTypeEntityId(int productTypeID ,int entityID)
	{
		String queryString= "from Digital as d where d.productTypeID=productTypeID and d.digitalId=entityID and d.productsPflag=1";
		return (Digital)getHibernateTemplate().find(queryString).iterator().next();
	}
	*/
	

	public void save(Digital transientInstance)
	{
		log.debug("saving Digital instance");
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

	public void delete(Digital persistentInstance)
	{
		log.debug("deleting Digital instance");
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

	public Digital findById(java.lang.Integer id)
	{
		log.debug("getting Digital instance with id: " + id);
		try
		{
			Digital instance = (Digital) getHibernateTemplate().get(
					"com.usc.daos.Digital", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Digital instance)
	{
		log.debug("finding Digital instance by example");
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
		log.debug("finding Digital instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Digital as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDigitalName(Object digitalName)
	{
		return findByProperty(DIGITAL_NAME, digitalName);
	}

	
	/**
	 * ������Ƶ�ģ�����
	 * @param bookName
	 * @return
	 */

	public List<Digital> findByLikeDigitalName(String digitalName)
	{
		String queryString="from Digital as d where d.productsPflag = 0 and d.digitalName like '%"+digitalName+"%'";
		return getHibernateTemplate().find(queryString);
	}
	
	/**
	 * ������Ƶ�ģ�����
	 * �Ѿ������Ĳ�Ʒ��Ҳ����ͨ��Ʒ��ģ�����
	 * @param bookName
	 * @return
	 */

	public List<Digital> findByLikeCommonDigitalName(String digitalName)
	{
		String queryString="from Digital as d where d.productsPflag = 1 and d.digitalName like '%"+digitalName+"%'";
		return getHibernateTemplate().find(queryString);
	}
	
	/**
	 * ����ĸ߼�����
	 * @param author
	 * @return
	 */
	
	public List<Digital> AdvancedSearchDigital(String digitalName,String brand)
	{
		
		String queryString="from Digital as d where d.productsPflag = 1 and d.digitalName like '%"+digitalName+"%' and d.brand like '%"+brand+"%'";
		return getHibernateTemplate().find(queryString);
		
	}
	
	public List findByPublishedPrice(Object publishedPrice)
	{
		return findByProperty(PUBLISHED_PRICE, publishedPrice);
	}

	public List findByManufacturer(Object manufacturer)
	{
		return findByProperty(MANUFACTURER, manufacturer);
	}

	public List findByBrand(Object brand)
	{
		return findByProperty(BRAND, brand);
	}

	public List findByModelNumber(Object modelNumber)
	{
		return findByProperty(MODEL_NUMBER, modelNumber);
	}

	public List findByParameter(Object parameter)
	{
		return findByProperty(PARAMETER, parameter);
	}

	public List<Digital> findByBarcode(Object barcode)
	{
		return findByProperty(BARCODE, barcode);
	}

	public List findByPhoto(Object photo)
	{
		return findByProperty(PHOTO, photo);
	}

	public List findByDescription(Object description)
	{
		return findByProperty(DESCRIPTION, description);
	}

	public List findBySpecialExplanation(Object specialExplanation)
	{
		return findByProperty(SPECIAL_EXPLANATION, specialExplanation);
	}

	public List findByProductsPflag(Object productsPflag)
	{
		return findByProperty(PRODUCTS_PFLAG, productsPflag);
	}

	public List<Digital> findAll()
	{
		log.debug("finding all Digital instances");
		try
		{
			String queryString = "from Digital";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Digital merge(Digital detachedInstance)
	{
		log.debug("merging Digital instance");
		try
		{
			Digital result = (Digital) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Digital instance)
	{
		log.debug("attaching dirty Digital instance");
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

	public void attachClean(Digital instance)
	{
		log.debug("attaching clean Digital instance");
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

	public static DigitalDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (DigitalDAO) ctx.getBean("DigitalDAO");
	}
}