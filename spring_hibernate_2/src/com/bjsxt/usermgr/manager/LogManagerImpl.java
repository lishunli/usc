package com.bjsxt.usermgr.manager;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.usermgr.model.Log;


public class LogManagerImpl extends HibernateDaoSupport implements LogManager {

	public void addLog(Log log) {
		this.getHibernateTemplate().save(log);
	}
}
