package com.bjsxt.usermgr.manager;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.usermgr.model.Log;
import com.bjsxt.usermgr.model.User;


public class UserManagerImpl extends HibernateDaoSupport implements UserManager {
	
	private LogManager logManager;
	
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
		Log log = new Log();
		log.setType("安全日志");
		log.setDetail(user.getName()+"进入系统");
		log.setTime(new Date());
		logManager.addLog(log);//通过spring来注入
//		throw new java.lang.RuntimeException();//抛出运行时的异常才回滚，但是可以配置抛出什么异常回滚，抛出什么异常不回滚
	}

//	public void addUser(User user)throws Exception
//	{
//		this.getHibernateTemplate().save(user);
//		Log log = new Log();
//		log.setType("安全日志");
//		log.setDetail("xxx进入系统");
//		log.setTime(new Date());
//		logManager.addLog(log);
//		throw new Exception();
//	}
	
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}
}
