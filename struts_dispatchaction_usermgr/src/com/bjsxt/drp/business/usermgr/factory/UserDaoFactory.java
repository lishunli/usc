package com.bjsxt.drp.business.usermgr.factory;

import com.bjsxt.drp.business.usermgr.dao.UserDao;
import com.bjsxt.drp.business.usermgr.dao.UserDao4MySqlImpl;

/**
 * �����࣬����̬װ��UserDao4MySqlImpl�� 
 */
public class UserDaoFactory {
	
	private static UserDaoFactory instance;
	
	private UserDao userDao;
	
	private UserDaoFactory() {
		
		//
		//ע��:���Դ������ļ��ж�̬װ��UserDao4MySqlImplʵ����,����������
		//
		userDao = new UserDao4MySqlImpl();
	}
	
	public static synchronized UserDaoFactory getInstance() {
		if (instance == null) {
			instance = new UserDaoFactory();
		}
		return instance;
	}
	
	/**
	 * ����UserDao����
	 * @return UserDao UserDao�ӿ�
	 */
	public UserDao createUserDao() {
		return userDao;
	}
}
