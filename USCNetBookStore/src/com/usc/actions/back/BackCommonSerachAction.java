package com.usc.actions.back;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.Bean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.BookExtra;
import com.usc.daos.DigitalExtra;
import com.usc.services.back.ISystemAdmin;

/**
 * 后台普通商品搜索
 * 
 * @author MZ
 * 
 *         2009-8-28上午09:42:16
 */
public class BackCommonSerachAction extends ActionSupport
{
	private String productsName;
	private BookDAO bookDao;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private List<BookExtra> bookExtraList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraList = new ArrayList<DigitalExtra>();

	public String getProductsName()
	{
		return productsName;
	}

	public void setProductsName(String productsName)
	{
		this.productsName = productsName;
	}

	public List<BookExtra> getBookExtraList()
	{
		return bookExtraList;
	}

	public List<DigitalExtra> getDigitalExtraList()
	{
		return digitalExtraList;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception
	{
		Map request = (Map) ActionContext.getContext().get("request");
		bookExtraList.clear();
		for (Book book : bookDao.findByLikeCommonBookName(productsName == null ? "" : productsName.trim()))
		{
			for (Commodity commodity : commodityDao.findByProductsID(sysAdmin.getProductID(1, book.getBookId())))
			{
				if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
				{
					BookExtra bookExtra = new BookExtra();// 实例化扩展Book的对象
					BeanUtils.copyProperties(bookExtra, book);// 类copy
					bookExtra.setDiscount(sysAdmin.getDiscount(1, book.getBookId()));// 设置折扣
					bookExtraList.add(bookExtra);
				}
			}
			request.put("bookCommon", bookExtraList);
		}
		return SUCCESS;
	}
}
