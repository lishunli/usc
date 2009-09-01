package com.usc.actions.back;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.services.back.ISystemAdmin;
import com.usc.services.back.Impl.SystemAdminImpl;

/**
 * 发布产品
 * 
 * @author MZ
 *
 * 2009-8-28上午09:44:23
 */
public class PublisheAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	private float discount;// 折扣

	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	private Commodity commodity;// 商品对象，通过Spring注入
	private CommodityDAO commodityDao;// 商品对象DAO，通过Spring注入

	// System.out.println("bookId:"+bookId+"type:"+type+"discount:"+discount);


	public int getType()
	{
		return type;
	}

	public int getEntityID()
	{
		return entityID;
	}

	public void setEntityID(int entityID)
	{
		this.entityID = entityID;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public float getDiscount()
	{
		return discount;
	}

	public void setDiscount(float discount)
	{
		this.discount = discount;
	}

	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}

	public void setCommodity(Commodity commodity)
	{
		this.commodity = commodity;
	}

	public void setCommodityDao(CommodityDAO commodityDao)
	{
		this.commodityDao = commodityDao;
	}

	@Override
	public String execute() throws Exception
	{
		sysAdmin.setProductPFlag(type, entityID, 1);//设置产品发布标志位1
		commodity.setDiscount(discount);//设置折扣
		commodity.setOperatorID(sysAdmin.getOperatorID(ActionContext.getContext().getSession().get("manger").toString()));//设置操作员ID
		commodity.setProductsID(sysAdmin.getProductID(type, entityID));//设置产品ID
		commodity.setPublisheTime(new Date());//设置产品发布时间为当前系统时间
		commodity.setSaleFlag(0);//促销商品标志位，默认为0，1的话就是促销商品
		commodityDao.save(commodity);//添加到商品表中
		return SUCCESS;
	}
}
