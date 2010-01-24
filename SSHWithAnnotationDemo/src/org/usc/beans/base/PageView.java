package org.usc.beans.base;

import java.util.List;

public class PageView<T>
{
	/** 分页数据 **/
	private List<T> records;
	/** 页码开始索引和结束索引 **/
	private PageIndex pageIndex;
	/** 总页数 **/
	private int totalPage = 1;
	/** 每页显示记录数 **/
	private int maxResult = 10;
	/** 当前页 **/
	private int currentPage = 1;
	/** 总记录数 **/
	private int totalRecord;
	/** 页码数量 **/
	private int pageCode = 2;

	/** 要获取记录的开始索引 **/
	public int getFirstResult()
	{
		return (this.currentPage - 1) * this.maxResult;
	}

	public int getPageCode()
	{
		return pageCode;
	}

	public void setPageCode(int pageCode)
	{
		this.pageCode = pageCode;
	}

	public PageView(int maxResult, int currentPage)
	{
		this.maxResult = maxResult;
		this.currentPage = (currentPage <= 0 ? 1 : currentPage);
	}

	public PageView(int currentPage)
	{
		this.currentPage = (currentPage <= 0 ? 1 : currentPage);
	}
	
	public void setQueryResult(QueryResult<T> qr)
	{
		setTotalRecord(qr.getTotalRecord());
		setRecords(qr.getResultList());
	}

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord % this.maxResult == 0 ? this.totalRecord / this.maxResult : this.totalRecord / this.maxResult + 1);
	}

	public List<T> getRecords()
	{
		return records;
	}

	public void setRecords(List<T> records)
	{
		this.records = records;
	}

	public PageIndex getPageIndex()
	{
		return pageIndex;
	}

	public int getTotalPage()
	{
		return totalPage;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
		this.pageIndex = PageIndex.getPageIndex(pageCode, currentPage, totalPage);
	}

	public int getMaxResult()
	{
		return maxResult;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}
}
