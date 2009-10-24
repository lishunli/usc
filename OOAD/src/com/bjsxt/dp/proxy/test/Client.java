package com.bjsxt.dp.proxy.test;

import com.bjsxt.dp.proxy.InvocationHandler;
import com.bjsxt.dp.proxy.Proxy;
import com.bjsxt.dp.proxy.TimeHandler;

public class Client {
	public static void main(String[] args) throws Exception {
		UserMgr mgr = new UserMgrImpl();
		InvocationHandler h = new TransactionHandler(mgr);
		//TimeHandler h2 = new TimeHandler(h);
		UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class,h);
		u.addUser();
	}
}
