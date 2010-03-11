package com.usc.actions.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.BookExtra;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.DigitalExtra;
import com.usc.daos.ProductsDAO;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 首页面的初始化操作，获得加载页面的数据
 * 
 * @author MZ
 * 
 *         2009-8-28下午03:34:19
 */
public class InitAction extends ActionSupport
{
	private BookDAO bookDao;
	private DigitalDAO digitalDao;
	private ISystemAdmin sysAdmin;
	private CommodityDAO commodityDao;
	private ProductsDAO productDao;
	private SaleDAO saleDao;
	
	private List<BookExtra> bookExtraCommonList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraCommonList = new ArrayList<DigitalExtra>();
	private List<BookExtra> bookExtraSaleList = new ArrayList<BookExtra>();
	private List<DigitalExtra> digitalExtraSaleList = new ArrayList<DigitalExtra>();

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

	public void setProductDao(ProductsDAO productDao)
	{
		this.productDao = productDao;
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
		for (Book book : bookDao.findByLikeCommonBookName(""))
		{
			for (Commodity commodity : commodityDao.findByProductsID(sysAdmin
					.getProductID(1, book.getBookId())))
			{
				if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
				{
					BookExtra bookExtra = new BookExtra();// 实例化扩展Book的对象
					BeanUtils.copyProperties(bookExtra, book);// 类copy
					bookExtra.setDiscount(sysAdmin.getDiscount(1, book
							.getBookId()));// 设置折扣
					bookExtra.setPrivilegePrice(bookExtra.getDiscount()
							* bookExtra.getPublishedPrice() / 100);// 设置会员价
					bookExtraCommonList.add(bookExtra);
				} 
			}
		}
		

		for (Digital digital : digitalDao.findByLikeCommonDigitalName(""))
		{
			for (Commodity commodity : commodityDao.findByProductsID(sysAdmin
					.getProductID(2, digital.getDigitalId())))
			{
				if (commodity.getSaleFlag() == 0)// 发布，但不是促销商品
				{
					DigitalExtra digitalExtra = new DigitalExtra();
					BeanUtils.copyProperties(digitalExtra, digital);
					digitalExtra.setDiscount(sysAdmin.getDiscount(2,
							digitalExtra.getDigitalId()));// 设置折扣
					digitalExtra.setPrivilegePrice(digitalExtra.getDiscount()
							* digitalExtra.getPublishedPrice() / 100);// 设置会员价
					digitalExtraCommonList.add(digitalExtra);
				} 
			}
		}
		/**
		 * 根据优先级顺序查找所有的促销商品
		 */
		for(Sale sale :saleDao.findAllBySort())
		{
			/**
			 * 0.设置优先级和促销价和会员价
			 * 1.根据促销表获得商品ID
			 * 2.根据商品ID来查找商品表，获得产品ID
			 * 3.根据产品ID来获得实物ID和分类类型ID
			 * 4.判断分类类型ID，在查找相应的表，获得book or digital 对象信息，并类copy
			 * 
			 */
			if(1 == productDao.findById(commodityDao.findById(sale.getCommodityId()).getProductsID()).getProductTypeId())
			{
				BookExtra bookExtra = new BookExtra();// 实例化扩展Book的对象
				bookExtra.setSalePrice(sale.getSalePrice());//设置优先级和促销价和会员价
				bookExtra.setPrivilegePrice(bookExtra.getSalePrice());//设置优先级和促销价和会员价
				bookExtra.setPriority(sale.getPriority());//设置优先级和促销价和会员价
				BeanUtils.copyProperties(bookExtra, bookDao.findById(productDao.findById(commodityDao.findById(sale.getCommodityId()).getProductsID()).getEntityId()));
				bookExtraSaleList.add(bookExtra);
			}
			else if(2 == productDao.findById(commodityDao.findById(sale.getCommodityId()).getProductsID()).getProductTypeId())
			{
				DigitalExtra digitalExtra = new DigitalExtra();
				digitalExtra.setSalePrice(sale.getSalePrice());
				digitalExtra.setPrivilegePrice(digitalExtra.getSalePrice());
				digitalExtra.setPriority(sale.getPriority());
				BeanUtils.copyProperties(digitalExtra,digitalDao.findById(productDao.findById(commodityDao.findById(sale.getCommodityId()).getProductsID()).getEntityId()));
				digitalExtraSaleList.add(digitalExtra);
			}
			
		}
		
		request.put("bookCommonInit", bookExtraCommonList);
		request.put("bookSaleInit", bookExtraSaleList);
		request.put("digitalCommonInit", digitalExtraCommonList);
		request.put("digitalSaleInit", digitalExtraSaleList);
		return null;
	}
}
