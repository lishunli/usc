package com.bjsxt.drp.business.usermgr.dao;

import java.sql.Connection;
import java.util.List;

import com.bjsxt.drp.business.usermgr.model.User;

/**
 * �û���ɾ�Ĳ�Dao��ӿ�
 */
public interface UserDao {
	
	/**
	 * �����û�
	 * @param conn
	 * @param user user����  
	 */
	public void addUser(Connection conn, User user);
	
	/**
	 * ����userId�ļ���ɾ���û�
	 * @param conn
	 * @param userIdList  userId�ļ���
	 */
	public void deleteUsers(Connection conn, String[] userIdList);
	
	/**
	 * �޸��û�
	 * @param conn
	 * @param user user����  
	 */
	public void modifyUser(Connection conn, User user);
	
	/**
	 * �����û�id��ѯ�û�
	 * @param userId �û�id
	 * @return  user����  
	 */
	public User findUserById(String userId);
	
	/**
	 * ��ѯ�����û�
	 * @return user�����б�
	 */
	public List findAllUserList();
}
