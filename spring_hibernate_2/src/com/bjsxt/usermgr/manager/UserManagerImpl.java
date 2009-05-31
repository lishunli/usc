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
		log.setType("��ȫ��־");
		log.setDetail(user.getName()+"����ϵͳ");
		log.setTime(new Date());
		logManager.addLog(log);//ͨ��spring��ע��
//		throw new java.lang.RuntimeException();//�׳�����ʱ���쳣�Żع������ǿ��������׳�ʲô�쳣�ع����׳�ʲô�쳣���ع�
	}

//	public void addUser(User user)throws Exception
//	{
//		this.getHibernateTemplate().save(user);
//		Log log = new Log();
//		log.setType("��ȫ��־");
//		log.setDetail("xxx����ϵͳ");
//		log.setTime(new Date());
//		logManager.addLog(log);
//		throw new Exception();
//	}
	
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}
}
