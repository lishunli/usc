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
 * Custom entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.usc.daos.Custom
 * @author MyEclipse Persistence Tools
 */

public class CustomDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(CustomDAO.class);
	// property constants
	public static final String CUSTOM_PASS = "customPass";
	public static final String EMAIL = "email";
	public static final String REAL_NAME = "realName";
	public static final String SEX = "sex";
	public static final String ADDRESS = "address";
	public static final String POST_CODE = "postCode";
	public static final String MOBILE = "mobile";
	public static final String PHONE = "phone";
	public static final String CONSUMPTION = "consumption";
	public static final String UCURRENCY = "ucurrency";
	public static final String BENEFITS = "benefits";
	public static final String VIP_FLAG = "vipFlag";
	public static final String ACTIVE_FLAG = "activeFlag";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Custom custom)
	{
		log.debug("saving Custom instance");
		try
		{
			getHibernateTemplate().save(custom);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	
	public List findByName(String customName)
	{
		String queryString ="from Custom as c where c.customName = ?";
		return getHibernateTemplate().find(queryString,customName);
	}
	
	
	
	
	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding Custom instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from Custom as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCustomName(Object customName)
	{
		return findByProperty("customName", customName);
	}
	
	public List findByEmail(Object email)
	{
		return findByProperty(EMAIL, email);
	}

	
	public void changeCustomInfo(Custom custom,String realName,String sex,String address,String postCode,String mobile,String phone)
	{
		custom.setRealName(realName);
		custom.setSex(sex);
		custom.setAddress(address);
		custom.setPostCode(postCode);
		custom.setMobile(mobile);
		custom.setPhone(phone);
		//String queryString = "update custom set realName = '"+realName+"',sex = sex,address = '"+address+"',postCode  ='"+postCode+"',mobile = '"+mobile+"',phone = '"+phone+"' where  =customName='"+customName+"'";
	   getHibernateTemplate().update(custom);
	}
	
	public void changeCustomPassword(Custom custom,String newPassword)
	{
		custom.setCustomPass(newPassword);
		getHibernateTemplate().update(custom);
	}
	

	public void changeCustomEmail(Custom custom,String email)
	{
		custom.setEmail(email);
		getHibernateTemplate().update(custom);
	}


	
	public void UTransfor(Custom custom1,String custom2Name,float Unumber)
	{
		custom1.setUcurrency(custom1.getUcurrency()-Unumber);
		Custom custom2 = (Custom)this.findByName(custom2Name).iterator().next();
		custom2.setUcurrency(custom2.getUcurrency()+Unumber);
		getHibernateTemplate().update(custom1);
		getHibernateTemplate().update(custom2);
	}
	
	public void BswapU(Custom custom,float number)
	{
		custom.setBenefits(custom.getBenefits()-number);
		custom.setUcurrency(custom.getUcurrency()+number*1/10);
		getHibernateTemplate().update(custom);
	}

	/*public void delete(Custom persistentInstance)
	{
		log.debug("deleting Custom instance");
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

	public Custom findById(java.lang.String id)
	{
		log.debug("getting Custom instance with id: " + id);
		try
		{
			Custom instance = (Custom) getHibernateTemplate().get(
					"com.usc.daos.Custom", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Custom instance)
	{
		log.debug("finding Custom instance by example");
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

	

	public List findByRealName(Object realName)
	{
		return findByProperty(REAL_NAME, realName);
	}

	public List findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
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

	public List findByConsumption(Object consumption)
	{
		return findByProperty(CONSUMPTION, consumption);
	}

	public List findByUcurrency(Object ucurrency)
	{
		return findByProperty(UCURRENCY, ucurrency);
	}

	public List findByBenefits(Object benefits)
	{
		return findByProperty(BENEFITS, benefits);
	}

	public List findByVipFlag(Object vipFlag)
	{
		return findByProperty(VIP_FLAG, vipFlag);
	}

	public List findByActiveFlag(Object activeFlag)
	{
		return findByProperty(ACTIVE_FLAG, activeFlag);
	}

	public List findAll()
	{
		log.debug("finding all Custom instances");
		try
		{
			String queryString = "from Custom";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Custom merge(Custom detachedInstance)
	{
		log.debug("merging Custom instance");
		try
		{
			Custom result = (Custom) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Custom instance)
	{
		log.debug("attaching dirty Custom instance");
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

	public void attachClean(Custom instance)
	{
		log.debug("attaching clean Custom instance");
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

	public static CustomDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (CustomDAO) ctx.getBean("CustomDAO");
	}*/
}