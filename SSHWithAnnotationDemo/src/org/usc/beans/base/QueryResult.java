package org.usc.beans.base;

import java.util.List;

public class QueryResult<T>
{
	private List<T> resultList;
	private int totalRecord;

	public List<T> getResultList()
	{
		return resultList;
	}

	public void setResultList(List<T> resultList)
	{
		this.resultList = resultList;
	}

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}
}
