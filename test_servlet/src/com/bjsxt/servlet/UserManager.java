package com.bjsxt.servlet;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	public List findUserByName(String name) {
		List userList = new ArrayList();
		userList.add("数据一");
		userList.add("数据二");
		return userList;
	} 
}
