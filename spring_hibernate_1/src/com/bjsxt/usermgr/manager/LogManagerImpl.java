package com.bjsxt.usermgr.manager;

import com.bjsxt.usermgr.model.Log;
import com.bjsxt.usermgr.util.HibernateUtils;

public class LogManagerImpl implements LogManager {

	public void addLog(Log log) {
		HibernateUtils.getSessionFactory().getCurrentSession().save(log);
	}

}
