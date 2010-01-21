package org.usc.daos;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.usc.beans.QueryResult;
import org.usc.utils.GenericsUtils;

@SuppressWarnings("unchecked")
public abstract class DaoSupport<T> extends MyHibernateDaoSupport implements DAO<T>
{
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());

	/*
	 * @see org.usc.daos.DAO#findAll()
	 */
	@Override
	public List<T> findAll()
	{
		return super.getHibernateTemplate().find("from " + getEntityName(entityClass));
	}

	

	/* 
	 * @see org.usc.daos.DAO#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable... entityids)
	{
		for(Object id : entityids)
		{
			super.getHibernateTemplate().delete(find((Serializable) id));
		}
	}


	/* 
	 * @see org.usc.daos.DAO#find(java.io.Serializable)
	 */
	@Override
	public T find(Serializable entityId)
	{
		return (T) super.getHibernateTemplate().get(entityClass, entityId);
	}


	/* 
	 * @see org.usc.daos.DAO#getCount()
	 */
	@Override
	public long getCount()
	{
		return findAll().size();
	}

	/* 
	 * @see org.usc.daos.DAO#getScrollData(int, int, java.lang.String, java.lang.Object[], java.util.LinkedHashMap)
	 */
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderby)
	{
		
		return null;
	}


	/* 
	 * @see org.usc.daos.DAO#getScrollData(int, int, java.lang.String, java.lang.Object[])
	 */
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams)
	{
		
		return null;
	}


	/* 
	 * @see org.usc.daos.DAO#getScrollData(int, int, java.util.LinkedHashMap)
	 */
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby)
	{
		
		return null;
	}


	/* 
	 * @see org.usc.daos.DAO#getScrollData(int, int)
	 */
	@Override
	public QueryResult<T> getScrollData(int firstindex, int maxresult)
	{
		
		return null;
	}


	/* 
	 * @see org.usc.daos.DAO#getScrollData()
	 */
	@Override
	public QueryResult<T> getScrollData()
	{
		
		return null;
	}


	/* 
	 * @see org.usc.daos.DAO#save(java.lang.Object)
	 */
	@Override
	public void save(Object entity)
	{
	}


	/* 
	 * @see org.usc.daos.DAO#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity)
	{
	}
	
	/**
	 * 获取实体的名称
	 * 
	 * @param <E>
	 * @param clazz
	 *            实体类
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz)
	{
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if (entity.name() != null && !"".equals(entity.name()))
		{
			entityname = entity.name();
		}
		return entityname;
	}

	protected static <E> String getCountField(Class<E> clazz)
	{
		String out = "o";
		try
		{
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors)
			{
				Method method = propertydesc.getReadMethod();
				if (method != null && method.isAnnotationPresent(EmbeddedId.class))
				{
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o." + propertydesc.getName() + "." + (!ps[1].getName().equals("class") ? ps[1].getName() : ps[0].getName());
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return out;
	}


}
