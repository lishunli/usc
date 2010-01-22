package org.usc.daos;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.usc.beans.QueryResult;
import org.usc.utils.GenericsUtils;

@SuppressWarnings("unchecked")
public abstract class DaoSupport<T> extends MyHibernateDaoSupport implements DAO<T>
{
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	protected String entityClassName = getEntityName(this.entityClass);

	/*
	 * @see org.usc.daos.DAO#findByEntity(java.lang.Object)
	 */
	@Override
	public List<T> findByEntity(Object entiey)
	{
		/*
		 * super.getHibernateTemplate().execute(new HibernateCallback<T>() {
		 * 
		 * @Override public T doInHibernate(Session arg0) throws HibernateException, SQLException { return (T) getSession().createQuery("").list(); } });
		 */
		return super.getHibernateTemplate().findByExample(entiey);
	}

	/*
	 * @see org.usc.daos.DAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<T> findByProperty(String propertyName, Object value)
	{
		String queryString = "from " + entityClassName + " as model where model." + propertyName + "= ?";
		return super.getHibernateTemplate().find(queryString, value);
	}

	/*
	 * @see org.usc.daos.DAO#delete(java.io.Serializable[])
	 */
	@Override
	public void delete(Serializable... entityids)
	{
		for (Object id : entityids)
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
		String queryString = "select count( " + getKeyFieldName(this.entityClass) + ") from " + entityClassName;
		long count = Long.parseLong(super.getHibernateTemplate().find(queryString).get(0).toString());
		return count;
	}
	
	@Override
	public void save(Object entity)
	{
		super.getHibernateTemplate().save(entity);
	}

	/*
	 * @see org.usc.daos.DAO#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity)
	{
		super.getHibernateTemplate().update(entity);
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

	/**
	 * 获取实体的主键
	 * @param <E>
	 * @param clazz 实体类
	 * @return 主键名
	 */
	protected static <E> String getKeyFieldName(Class<E> clazz)
	{
		try
		{
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors)
			{
				Method method = propertydesc.getReadMethod();
				if(null != method && null !=method.getAnnotation(javax.persistence.Id.class))
				{
					return propertydesc.getName();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "id";
	}

}
