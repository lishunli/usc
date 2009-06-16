package com.bjsxt.drp.business.usermgr.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.drp.business.usermgr.dao.UserDao;
import com.bjsxt.drp.business.usermgr.factory.UserDaoFactory;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.business.util.DB;

/**
 * ���û������ɾ�Ĳ�Ĺ����࣬���õ���ģʽʵ��
 * @author Administrator
 *
 */
public class UserManager {
	
	private static UserManager instance = new UserManager();
	
	private UserDao userDao = null;
	
	private UserManager() {		
		userDao = UserDaoFactory.getInstance().createUserDao();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	/**
	 * �����û�
	 * @param user user����
	 */
	public void addUser(User user) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			userDao.addUser(conn, user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
	
	/**
	 * �����û������ѯ
	 * @param userId �û�����
	 * @return user����
	 */
	public User findUserById(String userId) {
		User user = null;
		try {
			user = userDao.findUserById(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * ��ѯ�����û�
	 * @return user�����б�
	 */
	public List findAllUserList() {
		List userList = new ArrayList();
		try {
			userList = userDao.findAllUserList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	} 
	
	/**
	 * ����UserId�ļ��Ͻ���ɾ��
	 * @param userIds userId�ļ���
	 */
	public void deleteUsers(String[] userIdList) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			userDao.deleteUsers(conn, userIdList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
	
	/**
	 * �޸��û�
	 * @param user user����
	 */
	public void modifyUser(User user) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			userDao.modifyUser(conn, user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
}
