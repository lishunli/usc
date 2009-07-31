package com.usc.stock;

/**
 * Created by IntelliJ IDEA. User: ming Date: 2008-6-14 Time: 9:29:13 To change
 * this template use File | Settings | File Templates. ���ڱ����Ʊ�Ļ�����Ϣ
 */
public class Stock
{
	/**
	 * ��������̼�
	 */
	private double yesterday;
	/**
	 * ����Ŀ��̼�
	 */
	private double today;
	/**
	 * ��ǰ��
	 */
	private double now;
	/**
	 * ��Ʊ����
	 */
	private String name;
	/**
	 * ��Ʊ����
	 */
	private String id;

	public Stock(double yesterday, double today, String name, String id)
	{
		this.yesterday = yesterday;
		this.today = today;
		this.name = name;
		this.id = id;
		this.now = today;
	}

	public double getYesterday()
	{
		return yesterday;
	}

	public void setYesterday(double yesterday)
	{
		this.yesterday = yesterday;
	}

	public double getToday()
	{
		return today;
	}

	public void setToday(double today)
	{
		this.today = today;
	}

	public double getNow()
	{
		return now;
	}

	public void setNow(double now)
	{
		this.now = now;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String toString()
	{
		return this.name + ":" + this.now;
	}
}
