package com.usc.service;

import com.usc.dao.User;
/**
 * 接口，用于服务
 * 可以通过子类来实现一定的和数据库操作的功能
 * @author MZ
 *
 */
public interface UsersManager
{
	public void addUser(User user);//添加用户
	public String encoderByMd5(String password);//MD5加密
	public boolean checkUser(User user);//判断用户是否存在
	public boolean checkUserName(String username);//判断用户名是否存在
}
