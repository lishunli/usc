package com.usc.service;

import com.usc.dao.StudentDAO;

public class pageModel
{	
	private StudentDAO sdao;
	private int totalRecords;//�ܼ�¼���������ݿ��ж�ȡ
	private int pageNo;//��ǰҳ
	private int pageSize; //ÿҳ��ʾ����	
	private int totalPages;//��ҳ��
	
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
		this.pageSize = pageSize;//ÿҳ��ʾ����
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
