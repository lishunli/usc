package org.Oracle.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for Test entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see org.Oracle.impl.Test
  * @author MyEclipse Persistence Tools 
 */

public class TestDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(TestDAO.class);
	//property constants



    
    public void save(Test transientInstance) {
        log.debug("saving Test instance");
        try {
            getSession().save(transientInstance);
            getSession().beginTransaction().commit();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    
    
    
	public void delete(Test persistentInstance) {
        log.debug("deleting Test instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Test findById( org.Oracle.impl.TestId id) {
        log.debug("getting Test instance with id: " + id);
        try {
            Test instance = (Test) getSession()
                    .get("org.Oracle.impl.Test", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Test instance) {
        log.debug("finding Test instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.Oracle.impl.Test")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Test instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Test as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all Test instances");
		try {
			String queryString = "from Test";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Test merge(Test detachedInstance) {
        log.debug("merging Test instance");
        try {
            Test result = (Test) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Test instance) {
        log.debug("attaching dirty Test instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Test instance) {
        log.debug("attaching clean Test instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}