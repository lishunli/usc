package com.usc.services.back.Impl;

import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 系统管理员System administrator 提供系统管理员的接口的实现
 * 
 * @author MZ
 * 
 */
public class SystemAdminImpl implements ISystemAdmin
{
	private Book book;// 图书，通过Spring注入
	private Digital digital;// 数码，通过Spring注入
	private BookDAO bookDao;// 图书DAO，通过Spring注入
	private DigitalDAO digitalDao;// 数码DAO，通过Spring注入
	private ProductsDAO productDao;// 产品DAO，通过Spring注入
	private OperatorDAO operDao;// 操作员DAO，通过Spring注入
	private SaleDAO saleDao;// 促销DAO，通过Spring注入
	private CommodityDAO commodityDao;// 商品DAO，通过Spring注入

	public void setBook(Book book)
	{
		this.book = book;
	}

	public void setDigital(Digital digital)
	{
		this.digital = digital;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
	}

	public void setProductDao(ProductsDAO productDao)
	{
		this.productDao = productDao;
	}

	public void setOperDao(OperatorDAO operDao)
	{
		this.operDao = operDao;
	}

	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	/**
	 * 根据操作员姓名来唯一获得ID
	 */
	public int getOperatorID(String operatorName)
	{
		for (Operator oper : operDao.findByOperatorName(operatorName))
		{
			return oper.getOperatorId();
		}
		return 0;
	}

	/**
	 * 根据产品类型ID和实物ID来获得产品ID
	 */
	public int getProductID(int productTypeID, int entityID)
	{
		for (Products pro : productDao.findByEntityId(entityID))
		{
			if (pro.getProductTypeId() == productTypeID)
				return pro.getProductsId();
		}
		return 0;
	}

	/**
	 * 根据产品类型ID和实物ID来设置产品发布标志位
	 */
	public void setProductPFlag(int productTypeID, int entityID, int flag)
	{
		if (1 == productTypeID)
		{
			book = bookDao.findById(entityID);// 找到book
			book.setProductsPflag(flag);// 设置发布标志位
			bookDao.merge(book);// 更新book
		} else if (2 == productTypeID)
		{
			digital = digitalDao.findById(entityID);// 找到数码
			digital.setProductsPflag(flag);// 设置发布标志位
			digitalDao.merge(digital);// 更新数码
		}
	}

	/**
	 * 根据产品类型ID和实物ID来获取折扣
	 */
	public float getDiscount(int productTypeID, int entityID)
	{
		/**
		 * 1.通过实物ID和分类ID找到产品ID 2.通过产品ID在商品表中找到商品 3.返回商品的折扣
		 */

		for (Commodity commodity : commodityDao.findByProductsID(this
				.getProductID(productTypeID, entityID)))
		{
			return commodity.getDiscount();
		}
		return 0;
	}

	/**
	 * 根据产品类型ID和实物ID来获取优先级
	 */
	public int getPriority(int productTypeID, int entityID)
	{
		/**
		 * 1.通过实物ID和分类ID找到产品ID 2.通过产品ID在商品表中找到商品 3.通过商品ID在促销表中找到促销商品
		 * 4.返回促销商品的优先级
		 */
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				return sale.getPriority();
			}
		}
		return 0;
	}

	/**
	 * 根据产品类型ID和实物ID来获取促销价
	 */
	public float getSalePrice(int productTypeID, int entityID)
	{
		/**
		 * 1.通过实物ID和分类ID找到产品ID 2.通过产品ID在商品表中找到商品 3.通过商品ID在促销表中找到促销商品
		 * 4.返回促销商品的促销价
		 */
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				return sale.getSalePrice();
			}
		}
		return 0;
	}

	/**
	 * 保存促销商品，要注意此时会对优先级进行处理
	 */
	public void saveSale(Sale s)
	{
		for (Sale sale : saleDao.findByPriority(s.getPriority()))// 在促销表中有找到该优先级
		{
			sale.setPriority(getMaxPriority() + 1);
			saleDao.merge(sale);
		}
		saleDao.save(s);
	}

	/**
	 * 根据产品类型ID和实物ID来设置商品促销标志位和从促销表里删除
	 */
	public void setsaleFlag(int productTypeID, int entityID, int flag)
	{
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			commodity.setSaleFlag(flag);// 设置促销商品标志位
			commodityDao.merge(commodity);// 更新
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				saleDao.delete(sale);// 从促销表里删除
			}
		}
	}

	/**
	 * 获得最大的优先级+1
	 */
	public int getMaxPriority()
	{
		int MaxPriority = 0;
		for (Sale sale : saleDao.findAll())
		{
			if (sale.getPriority() > MaxPriority)
				MaxPriority = sale.getPriority();
		}
		return MaxPriority;
	}

	/**
	 * 根据产品类型ID和实物ID来获得商品ID
	 */
	public int getCommodityID(int productTypeID, int entityID)
	{
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				productTypeID, entityID)))
		{
			return commodity.getCommodityId();
		}
		return 0;
	}

	// 由商品ID获得定价
	public float getPublishedPrice(int commodityID)
	{
		int productId = commodityDao.findById(commodityID).getProductsID();
		int ProductTypeID = productDao.findById(productId).getProductTypeId();
		int EntityID = productDao.findById(productId).getEntityId();
		if (ProductTypeID == 1)
		{
			Book book = (Book) bookDao.findById(EntityID);
			return book.getPublishedPrice();
		} else
		{
			Digital digital = (Digital) digitalDao.findById(EntityID);
			return digital.getPublishedPrice();
		}
	}

	// 又商品Id取得商品名
	public String getCommodityName(int commodityID)
	{
		int productId = commodityDao.findById(commodityID).getProductsID();
		int ProductTypeID = productDao.findById(productId).getProductTypeId();
		int EntityID = productDao.findById(productId).getEntityId();
		if (ProductTypeID == 1)
		{
			Book book = (Book) bookDao.findById(EntityID);
			return book.getBookName();
		} else
		{
			Digital digital = (Digital) digitalDao.findById(EntityID);
			return digital.getDigitalName();
		}
	}

	/**
	 * 折扣 优先级 修改促销表
	 */
	public void mergeSale(int type, int entityID, float salePrice, int priority)
	{

		/**
		 * 1.通过实物ID和分类ID找到产品ID 2.通过产品ID在商品表中找到商品 3.通过商品ID在促销表中找到促销商品
		 * 4.修改促销商品的促销价和优先级
		 */
		for (Commodity commodity : commodityDao.findByProductsID(getProductID(
				type, entityID)))
		{
			for (Sale sale : saleDao.findByCommodityId(commodity
					.getCommodityId()))
			{
				if (!saleDao.findByPriority(priority).isEmpty())// 在促销表中有找到该优先级
				{
					for (Sale s : saleDao.findByPriority(priority))
					{
						s.setPriority(getMaxPriority() + 1);
						saleDao.merge(s);
					}
				}
				sale.setSalePrice(salePrice);
				sale.setPriority(priority);
				saleDao.merge(sale);
			}

		}
	}

}
