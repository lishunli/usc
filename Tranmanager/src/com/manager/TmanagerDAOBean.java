package com.manager;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pojo.Tp;

public @Stateless
class TmanagerDAOBean implements TmanagerDAO
{

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void ModifyTP(String newname, boolean error) throws Exception
	{
		Query query = em.createQuery("select p from Tp p");
		List result = query.getResultList();
		if (result != null)
		{
			for (int i = 0; i < result.size(); i++)
			{
				Tp product = (Tp) result.get(i);
				product.setPname(newname + i);
				em.merge(product);// ����
			}
			if (error && result.size() > 0)
				throw new TransException("�׳�Ӧ������");
			//��Ԥ�����쳣
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertTP(String name, Float price, boolean error)
	{
		try
		{
			for (int i = 0; i < 3; i++)
			{
				Tp product = new Tp();
				product.setPname(name + i);
				product.setPrice(price * (i + 1));
				// ����ʵ��bean,����Ҫ���������
				em.persist(product);
			}
			if (error)
				new Float("kkk"); // ����һ�������Χ");

		} catch (Exception e)
		{
			throw new RuntimeException("Ӧ���׳�����ʱ����,Ϊ��ʹ����ع����ⲿ��Ҫ�� try/catch");
			//����ʱ���쳣

		}

	}
}
