package com.usc.actions.custom;

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
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.BookExtra;
import com.usc.daos.DigitalExtra;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;
import com.usc.services.back.ISystemAdmin;

/**
 * ��̨��ͨ��Ʒ����
 * 
 * @author MZ
 * 
 */
public class FuzzySearchAction extends ActionSupport
{
	private int s;
	private String Search;
	private BookDAO bookDao;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private SaleDAO saleDao;
	private List<BookExtra> bookExtraCommonList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraCommonList = new ArrayList<DigitalExtra>();
	private List<BookExtra> bookExtraSaleList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraSaleList = new ArrayList<DigitalExtra>();

	public String getSearch()
	{
		return Search;
	}

	public void setSearch(String search)
	{
		Search = search;
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

	public int getS()
	{
		return s;
	}

	public void setS(int s)
	{
		this.s = s;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}

	@Override
	public String execute() throws Exception
	{
		Map request = (Map) ActionContext.getContext().get("request");
		bookExtraCommonList.clear();
		digitalExtraCommonList.clear();
		bookExtraSaleList.clear();
		digitalExtraSaleList.clear();
		if (s == 1)
		{
			for (Book book : bookDao.findByLikeCommonBookName(Search.trim()))
			{
				if (0 == commodityDao.findById(
						sysAdmin.getCommodityID(1, book.getBookId()))
						.getSaleFlag())
				{
					BookExtra bookExtra = new BookExtra();
					BeanUtils.copyProperties(bookExtra, book);
					bookExtra.setDiscount(sysAdmin.getDiscount(1, book
							.getBookId()));
					bookExtra.setPrivilegePrice(bookExtra.getPublishedPrice()
							* bookExtra.getDiscount() / 100);
					bookExtraCommonList.add(bookExtra);
				} else
				{
					for (Sale sale : saleDao
							.findByCommodityId(commodityDao
									.findById(
											sysAdmin.getCommodityID(1, book
													.getBookId()))
									.getCommodityId()))
					{
						BookExtra bookExtra = new BookExtra();
						BeanUtils.copyProperties(bookExtra, book);
						bookExtra.setSalePrice(sale.getSalePrice());
						bookExtra.setPriority(sale.getPriority());
						bookExtra.setPrivilegePrice(bookExtra.getSalePrice());
						bookExtraSaleList.add(bookExtra);
					}
				}
				request.put("bookCommonInit", bookExtraCommonList);
				request.put("bookSaleInit", bookExtraSaleList);
			}
		} else if (s == 2)
		{

			for (Digital digital : digitalDao
					.findByLikeCommonDigitalName(Search.trim()))
			{
				if (0 == commodityDao.findById(
						sysAdmin.getCommodityID(2, digital.getDigitalId()))
						.getSaleFlag())
				{
					DigitalExtra digitalExtra = new DigitalExtra();

					BeanUtils.copyProperties(digitalExtra, digital);

					digitalExtra.setDiscount(sysAdmin.getDiscount(2, digital
							.getDigitalId()));
					digitalExtra.setPrivilegePrice(digitalExtra
							.getPublishedPrice()
							* digitalExtra.getDiscount() / 100);
					digitalExtraCommonList.add(digitalExtra);
				} else
				{
					for (Sale sale : saleDao.findByCommodityId(commodityDao
							.findById(
									sysAdmin.getCommodityID(2, digital
											.getDigitalId())).getCommodityId()))
					{
						DigitalExtra digitalExtra = new DigitalExtra();
						BeanUtils.copyProperties(digitalExtra, digital);
						digitalExtra.setSalePrice(sale.getSalePrice());
						digitalExtra.setPriority(sale.getPriority());
						digitalExtra.setPrivilegePrice(digitalExtra
								.getSalePrice());
						digitalExtraSaleList.add(digitalExtra);
					}
				}
			}
			request.put("digitalCommonInit", digitalExtraCommonList);
			request.put("digitalSaleInit", digitalExtraSaleList);
		}
		return SUCCESS;
	}
}
