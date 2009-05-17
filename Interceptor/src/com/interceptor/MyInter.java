package com.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class MyInter implements Interceptor
{

	public void afterTransactionBegin(Transaction arg0)
	{
		// TODO Auto-generated method stub

	}

	public void afterTransactionCompletion(Transaction arg0)
	{
		// TODO Auto-generated method stub

	}

	public void beforeTransactionCompletion(Transaction arg0)
	{
		// TODO Auto-generated method stub

	}

	public int[] findDirty(Object arg0, Serializable arg1, Object[] arg2,
			Object[] arg3, String[] arg4, Type[] arg5)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEntity(String arg0, Serializable arg1)
			throws CallbackException
	{
		System.out.println(arg0.toString());
		return arg0;
	}

	public String getEntityName(Object arg0) throws CallbackException
	{
		System.out.println(arg0.getClass().getName());
		return arg0.getClass().getName();
	}

	public Object instantiate(String arg0, EntityMode arg1, Serializable arg2)
			throws CallbackException
	{
		// TODO Auto-generated method stub
		
		return null;
	}

	public Boolean isTransient(Object arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void onCollectionRecreate(Object arg0, Serializable arg1)
			throws CallbackException
	{
		// TODO Auto-generated method stub

	}

	public void onCollectionRemove(Object arg0, Serializable arg1)
			throws CallbackException
	{
		// TODO Auto-generated method stub

	}

	public void onCollectionUpdate(Object arg0, Serializable arg1)
			throws CallbackException
	{
		// TODO Auto-generated method stub

	}

	public void onDelete(Object arg0, Serializable arg1, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException
	{
		// TODO Auto-generated method stub

	}

	public boolean onFlushDirty(Object arg0, Serializable arg1, Object[] arg2,
			Object[] arg3, String[] arg4, Type[] arg5) throws CallbackException
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onLoad(Object arg0, Serializable arg1, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException
	{
		// TODO Auto-generated method stub
		return false;
	}

	public String onPrepareStatement(String arg0)
	{
		System.out.println(arg0.toString());
		return arg0;
	}

	public boolean onSave(Object arg0, Serializable arg1, Object[] arg2,
			String[] arg3, Type[] arg4) throws CallbackException
	{
		System.out.println("onSave is used");
		System.out.println(arg0.toString());
		return false;
	}

	public void postFlush(Iterator arg0) throws CallbackException
	{
		// TODO Auto-generated method stub

	}

	public void preFlush(Iterator arg0) throws CallbackException
	{
		// TODO Auto-generated method stub

	}

}
