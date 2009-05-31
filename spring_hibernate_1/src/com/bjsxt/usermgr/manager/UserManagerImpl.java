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
			 * 1��getCurrentSession()��openSession()������
	* ����getCurrentSession()������session��󶨵���ǰ�߳��У�������openSession()
	  ������session�򲻻�
	* ����getCurrentSession()������session��commit��rollbackʱ���Զ��رգ�������openSession()
	  ������session�����ֶ��ر�
			 */
			
			session.beginTransaction();
			
			session.save(user);

//			Integer.parseInt("asdfsdfsfsd");
			Log log = new Log();
			log.setType("��ȫ��־");
			log.setDetail(user.getName()+"����ϵͳ");
			log.setTime(new Date());
			
			LogManager logManager = new LogManagerImpl();
			logManager.addLog(log);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
//			session.close();//session��commit��rollbackʱ���Զ��ر�
//			HibernateUtils.closeSession(session);
		}
	}
}
