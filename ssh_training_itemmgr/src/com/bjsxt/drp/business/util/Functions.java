package com.bjsxt.drp.business.util;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * DRP������
 * ע�⿪�������ⷽ�������Ǿ�̬��
 * @author Administrator
 *
 */
public class Functions {
	
	private static SessionFactory sessionFactory;
	
	/**
	 * �����������Ľ��
	 * @return ItemCategory����ļ���
	 */
	public static List getItemCategoryList() {
		List itemCategoryList = null; 
		try {
			HibernateTemplate ht = new HibernateTemplate(sessionFactory);
			return ht.find("from ItemCategory a order by a.id");
		}catch(Exception e) {
			//��¼��־,log4j��......
			e.printStackTrace();
		}
		return itemCategoryList;
	}

	/**
	 * �����������Ľ��
	 * @return ItemCategory����ļ���
	 */
	public static List getItemUnitList() {
		List itemUnitList = null; 
		try {
			HibernateTemplate ht = new HibernateTemplate(sessionFactory);
			return ht.find("from ItemUnit a order by a.id");
		}catch(Exception e) {
			//��¼��־,log4j��......
			e.printStackTrace();
		}
		return itemUnitList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		Functions.sessionFactory = sessionFactory;
	}
}
