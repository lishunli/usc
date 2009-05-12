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
				em.merge(product);// 更新
			}
			if (error && result.size() > 0)
				throw new TransException("抛出应用例外");
			//可预见的异常
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
				// 调用实体bean,构建要插入的数据
				em.persist(product);
			}
			if (error)
				new Float("kkk"); // 制造一个例外包围");

		} catch (Exception e)
		{
			throw new RuntimeException("应用抛出运行时例外,为了使事务回滚，外部不要用 try/catch");
			//运行时的异常

		}

	}
}
