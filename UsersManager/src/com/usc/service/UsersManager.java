package com.usc.service;

import com.usc.dao.User;
/**
 * �ӿڣ����ڷ���
 * ����ͨ��������ʵ��һ���ĺ����ݿ�����Ĺ���
 * @author MZ
 *
 */
public interface UsersManager
{
	public void addUser(User user);//����û�
	public String encoderByMd5(String password);//MD5����
	public boolean checkUser(User user);//�ж��û��Ƿ����
	public boolean checkUserName(String username);//�ж��û����Ƿ����
}
