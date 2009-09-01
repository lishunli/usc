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
 * 2009-8-28上午09:42:16
 */
public class BackCommonSerachAction extends ActionSupport
{
	private String type;
	private String productsName;
	private BookDAO bookDao;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private List<BookExtra> bookExtraList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraList = new ArrayList<DigitalExtra>();

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

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

	@Override
	public String execute() throws Exception
	{
		if (null != type)
		{
			Map request = (Map) ActionContext.getContext().get("request");
			bookExtraList.clear();
			digitalExtraList.clear();
			if ("图书".equals(type.trim()))
			{
				for (Book book : bookDao.findByLikeCommonBookName(productsName
						.trim()))
				{
					for (Commodity commodity : commodityDao
							.findByProductsID(sysAdmin.getProductID(1, book
									.getBookId())))
					{
						if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
						{
							BookExtra bookExtra = new BookExtra();//实例化扩展Book的对象
							BeanUtils.copyProperties(bookExtra, book);//类copy
							bookExtra.setDiscount(sysAdmin.getDiscount(1, book
									.getBookId()));//设置折扣
							bookExtraList.add(bookExtra);
						}
					}
				}
				request.put("bookCommon", bookExtraList);
			} else if ("数码".equals(type.trim()))
			{
				for (Digital digital : digitalDao
						.findByLikeCommonDigitalName(productsName.trim()))
				{
					for (Commodity commodity : commodityDao
							.findByProductsID(sysAdmin.getProductID(2, digital
									.getDigitalId())))
					{
						if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
						{
							DigitalExtra digitalExtra = new DigitalExtra();
							BeanUtils.copyProperties(digitalExtra, digital);
							digitalExtra.setDiscount(sysAdmin.getDiscount(2,
									digitalExtra.getDigitalId()));//设置折扣
							digitalExtraList.add(digitalExtra);
						}
					}
				}
				request.put("digitalCommon", digitalExtraList);
			}
		}
		return SUCCESS;
	}
}
