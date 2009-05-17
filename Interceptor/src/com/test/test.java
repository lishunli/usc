package com.test;

import org.hibernate.Session;

import com.pojo.Users;
import com.util.HibernateSessionFactory;

public class test
{
	public static void main(String[] args)
	{
		Session session =HibernateSessionFactory.getSession();
		
		Users user = new Users();
		user.setUname("ÀîË³Àû");
		user.setUpass("lishunli");
	
		session.saveOrUpdate(user);
		session.beginTransaction().commit();
		session.close();
		
	}

}
