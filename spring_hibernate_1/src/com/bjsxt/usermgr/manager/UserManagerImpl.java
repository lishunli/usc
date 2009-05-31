package com.bjsxt.usermgr.manager;

import java.util.Date;

import org.hibernate.Session;

import com.bjsxt.usermgr.model.Log;
import com.bjsxt.usermgr.model.User;
import com.bjsxt.usermgr.util.HibernateUtils;

public class UserManagerImpl implements UserManager {

	public void addUser(User user) {
		Session session = null;
		try {
//			session = HibernateUtils.getSession();
			session = HibernateUtils.getSessionFactory().getCurrentSession();
			/**
			 * 1、getCurrentSession()与openSession()的区别？
	* 采用getCurrentSession()创建的session会绑定到当前线程中，而采用openSession()
	  创建的session则不会
	* 采用getCurrentSession()创建的session在commit或rollback时会自动关闭，而采用openSession()
	  创建的session必须手动关闭
			 */
			
			session.beginTransaction();
			
			session.save(user);

//			Integer.parseInt("asdfsdfsfsd");
			Log log = new Log();
			log.setType("安全日志");
			log.setDetail(user.getName()+"进入系统");
			log.setTime(new Date());
			
			LogManager logManager = new LogManagerImpl();
			logManager.addLog(log);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
//			session.close();//session在commit或rollback时会自动关闭
//			HibernateUtils.closeSession(session);
		}
	}
}
