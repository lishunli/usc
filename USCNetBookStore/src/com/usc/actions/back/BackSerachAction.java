package com.usc.actions.back;

import java.util.List;
import java.util.Map;

import org.apache.struts2.components.If;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;

/**
 * 后台模糊搜索
 * 
 * @author MZ
 * 
 *         2009-8-28上午09:43:59
 */
public class BackSerachAction extends ActionSupport
{
	private String productsName;
	private BookDAO bookDao;
	private DigitalDAO digitalDao;

	public String getProductsName()
	{
		return productsName;
	}

	public void setProductsName(String productsName)
	{
		this.productsName = productsName;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	@Override
	public void validate()
	{
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception
	{
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("bookSerach",  bookDao.findByLikeBookName(productsName == null ? "" : productsName.trim()));// 未发布的图书模糊查找，
		
		return SUCCESS;
		
	}

}
