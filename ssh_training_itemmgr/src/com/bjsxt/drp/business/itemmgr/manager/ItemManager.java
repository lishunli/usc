package com.bjsxt.drp.business.itemmgr.manager;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bjsxt.drp.business.itemmgr.model.Item;
import com.bjsxt.drp.business.util.AppException;
import com.bjsxt.drp.business.util.HibernateUtils;
import com.bjsxt.drp.business.util.PageModel;

/**
 * ���Ϲ����࣬���õ���ģʽʵ��
 * @author Administrator
 *
 */
public interface ItemManager {

	/**
	 * �������
	 * @param item item����
	 */
	public void addItem(Item item);

	/**
	 * �޸�����
	 * @param item item����
	 */
	public void modifyItem(Item item);

	/**
	 * ɾ������
	 * @param itemNoList ���ϴ��뼯��
	 */
	public void deleteItem(String[] itemNoList);

	/**
	 * ����������ѯ������Ϣ
	 * @param queryStr ��ѯ����
	 * @return item����ļ���
	 */
	public PageModel findAllItem(int pageNo, int pageSize, String queryStr);
	
	/**
	 * ����Id��ѯ����
	 * @param item item����
	 */
	public Item findItemById(String itemNo);
}