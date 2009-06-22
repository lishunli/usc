package com.usc.service;

import com.usc.dao.StudentDAO;

public class pageModel
{	
	private StudentDAO sdao;
	private int totalRecords;//总记录数，从数据库中读取
	private int pageNo;//当前页
	private int pageSize; //每页显示多少	
	private int totalPages;//总页数
	
	public void setSdao(StudentDAO sdao)
	{
		this.sdao = sdao;
	}

	public int getTotalRecords()
	{
		return totalRecords;
	}
	public void setTotalRecords()
	{
		this.totalRecords = sdao.getAllRecords();
	}
	public int getPageNo()
	{
		return pageNo;
	}
	public void setPageNo(int pageNo)
	{
		if(pageNo <= 1)
			this.pageNo = 1;
		else if(pageNo >= totalPages)
			this.pageNo = totalPages;
		else this.pageNo = pageNo;
	}
	
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;//每页显示三条
	}
	
	public int getTotalPages()
	{
		return totalPages;
	}
	public void setTotalPages()
	{
		this.totalPages = (totalRecords % pageSize == 0)?(totalRecords / pageSize):(totalRecords / pageSize +1);
	}
	
	
}
