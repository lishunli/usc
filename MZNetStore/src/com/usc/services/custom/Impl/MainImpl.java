package com.usc.services.custom.Impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.BookExtra;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.DigitalExtra;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;
import com.usc.services.custom.IMain;

public class MainImpl implements IMain
{
	private BookDAO bookdao;
	private DigitalDAO digitaldao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private SaleDAO saleDao;
	private List<DigitalExtra> digitalExtraCommonList = new ArrayList<DigitalExtra>();
	private List<DigitalExtra> digitalExtraSaleList = new ArrayList<DigitalExtra>();
	private List<BookExtra> bookExtraCommonList = new ArrayList<BookExtra>();
	private List<BookExtra> bookExtraSaleList = new ArrayList<BookExtra>();

	public void setBookdao(BookDAO bookdao)
	{
		this.bookdao = bookdao;
	}

	public void setDigitaldao(DigitalDAO digitaldao)
	{
		this.digitaldao = digitaldao;
	}

	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}

	public List<BookExtra> AdvancedBookSearchCommon(String bookName,
			String author, String isbn, String publisher)
	{
		bookExtraCommonList.clear();
		for (Book book : bookdao.AdvancedBookSearch(bookName, author, isbn,
				publisher))
		{
			if (0 == commodityDao.findById(
					sysAdmin.getCommodityID(1, book.getBookId())).getSaleFlag())
			{
				BookExtra bookExtra = new BookExtra();
				try
				{
					BeanUtils.copyProperties(bookExtra, book);
				} catch (IllegalAccessException e)
				{
				} catch (InvocationTargetException e)
				{
				}
				bookExtra
						.setDiscount(sysAdmin.getDiscount(1, book.getBookId()));
				bookExtra.setPrivilegePrice(bookExtra.getPublishedPrice()
						* bookExtra.getDiscount() / 100);
				bookExtraCommonList.add(bookExtra);
			}
		}
		return bookExtraCommonList;
	}

	public List<BookExtra> AdvancedBookSearchSale(String bookName,
			String author, String isbn, String publisher)
	{
		bookExtraSaleList.clear();
		for (Book book : bookdao.AdvancedBookSearch(bookName, author, isbn,
				publisher))
		{
			if (1 == commodityDao.findById(
					sysAdmin.getCommodityID(1, book.getBookId())).getSaleFlag())
			{
				for (Sale sale : saleDao.findByCommodityId(commodityDao
						.findById(sysAdmin.getCommodityID(1, book.getBookId()))
						.getCommodityId()))
				{
					BookExtra bookExtra = new BookExtra();
					try
					{
						BeanUtils.copyProperties(bookExtra, book);
					} catch (IllegalAccessException e)
					{
					} catch (InvocationTargetException e)
					{
					}
					bookExtra.setSalePrice(sale.getSalePrice());
					bookExtra.setPriority(sale.getPriority());
					bookExtra.setPrivilegePrice(bookExtra.getSalePrice());
					bookExtraSaleList.add(bookExtra);
				}
			}

		}
		return bookExtraSaleList;
	}

	public List<DigitalExtra> AdvancedSearchDigitalCommon(String digitalName,
			String brand)
	{
		digitalExtraCommonList.clear();
		for (Digital digital : digitaldao.AdvancedSearchDigital(digitalName,
				brand))
		{
			if (0 == commodityDao.findById(
					sysAdmin.getCommodityID(2, digital.getDigitalId()))
					.getSaleFlag())
			{
				DigitalExtra digitalExtra = new DigitalExtra();

				try
				{
					BeanUtils.copyProperties(digitalExtra, digital);
				} catch (IllegalAccessException e)
				{
				} catch (InvocationTargetException e)
				{
				}

				digitalExtra.setDiscount(sysAdmin.getDiscount(2, digital
						.getDigitalId()));
				digitalExtra.setPrivilegePrice(digitalExtra.getPublishedPrice()
						* digitalExtra.getDiscount() / 100);
				digitalExtraCommonList.add(digitalExtra);
			}
		}
		return digitalExtraCommonList;
	}

	public List<DigitalExtra> AdvancedSearchDigitalSale(String digitalName,
			String brand)
	{
		digitalExtraSaleList.clear();
		for (Digital digital : digitaldao.AdvancedSearchDigital(digitalName,
				brand))
		{
			if (1 == commodityDao.findById(
					sysAdmin.getCommodityID(2, digital.getDigitalId()))
					.getSaleFlag())
			{
				for (Sale sale : saleDao.findByCommodityId(commodityDao
						.findById(
								sysAdmin.getCommodityID(2, digital
										.getDigitalId())).getCommodityId()))
				{
					DigitalExtra digitalExtra = new DigitalExtra();
					try
					{
						BeanUtils.copyProperties(digitalExtra, digital);
					} catch (IllegalAccessException e)
					{
					} catch (InvocationTargetException e)
					{
					}
					digitalExtra.setSalePrice(sale.getSalePrice());
					digitalExtra.setPriority(sale.getPriority());
					digitalExtra.setPrivilegePrice(digitalExtra.getSalePrice());
					digitalExtraSaleList.add(digitalExtra);
				}
			}
		}
		return digitalExtraSaleList;
	}

	public List<BookExtra> BookCommonInfo(int typeId, int bookId)
	{
		bookExtraCommonList.clear();
		if (0 == commodityDao
				.findById(
						sysAdmin.getCommodityID(1, bookdao.findById(bookId)
								.getBookId())).getSaleFlag())
		{
			BookExtra bookExtra = new BookExtra();
			try
			{
				BeanUtils.copyProperties(bookExtra, bookdao.findById(bookId));
			} catch (IllegalAccessException e)
			{
			} catch (InvocationTargetException e)
			{
			}
			bookExtra.setDiscount(sysAdmin.getDiscount(1, bookdao.findById(
					bookId).getBookId()));
			bookExtra.setPrivilegePrice(bookExtra.getPublishedPrice()
					* bookExtra.getDiscount() / 100);
			bookExtraCommonList.add(bookExtra);
		}
		return bookExtraCommonList;
	}

	public List<BookExtra> BookSaleInfo(int typeId, int bookId)
	{
		bookExtraSaleList.clear();
		if (1 == commodityDao
				.findById(
						sysAdmin.getCommodityID(1, bookdao.findById(bookId)
								.getBookId())).getSaleFlag())
		{
			for (Sale sale : saleDao.findByCommodityId(commodityDao.findById(
					sysAdmin.getCommodityID(1, bookdao.findById(bookId)
							.getBookId())).getCommodityId()))
			{
				BookExtra bookExtra = new BookExtra();
				try
				{
					BeanUtils.copyProperties(bookExtra, bookdao
							.findById(bookId));
				} catch (IllegalAccessException e)
				{
				} catch (InvocationTargetException e)
				{
				}
				bookExtra.setSalePrice(sale.getSalePrice());
				bookExtra.setPriority(sale.getPriority());
				bookExtra.setPrivilegePrice(bookExtra.getSalePrice());
				bookExtraSaleList.add(bookExtra);
			}
		}

		return bookExtraSaleList;
	}

	public List<DigitalExtra> DigitalCommonInfo(int typeId, int digitalId)
	{
		digitalExtraCommonList.clear();
		if (0 == commodityDao.findById(
				sysAdmin.getCommodityID(2, digitaldao.findById(digitalId)
						.getDigitalId())).getSaleFlag())
		{
			DigitalExtra digitalExtra = new DigitalExtra();

			try
			{
				BeanUtils.copyProperties(digitalExtra, digitaldao
						.findById(digitalId));
			} catch (IllegalAccessException e)
			{
			} catch (InvocationTargetException e)
			{
			}

			digitalExtra.setDiscount(sysAdmin.getDiscount(2, digitaldao
					.findById(digitalId).getDigitalId()));
			digitalExtra.setPrivilegePrice(digitalExtra.getPublishedPrice()
					* digitalExtra.getDiscount() / 100);
			digitalExtraCommonList.add(digitalExtra);
		}
		return digitalExtraCommonList;
	}

	public List<DigitalExtra> DigitalSaleInfo(int typeId, int digitalId)
	{
		digitalExtraSaleList.clear();
		if (1 == commodityDao.findById(
				sysAdmin.getCommodityID(2, digitaldao.findById(digitalId)
						.getDigitalId())).getSaleFlag())
		{
			for (Sale sale : saleDao.findByCommodityId(commodityDao.findById(
					sysAdmin.getCommodityID(2, digitaldao.findById(digitalId)
							.getDigitalId())).getCommodityId()))
			{
				DigitalExtra digitalExtra = new DigitalExtra();
				try
				{
					BeanUtils.copyProperties(digitalExtra, digitaldao
							.findById(digitalId));
				} catch (IllegalAccessException e)
				{
				} catch (InvocationTargetException e)
				{
				}
				digitalExtra.setSalePrice(sale.getSalePrice());
				digitalExtra.setPriority(sale.getPriority());
				digitalExtra.setPrivilegePrice(digitalExtra.getSalePrice());
				digitalExtraSaleList.add(digitalExtra);
			}
		}
		return digitalExtraSaleList;
	}

}
