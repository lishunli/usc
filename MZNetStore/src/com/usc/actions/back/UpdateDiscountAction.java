package com.usc.actions.back;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 修改产品折扣
 * 
 * @author MZ
 *
 * 2009-8-28上午09:45:00
 */
public class UpdateDiscountAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	private float discount;// 折扣

	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	private Commodity commodity;// 商品对象，通过Spring注入
	private CommodityDAO commodityDao;// 商品对象DAO，通过Spring注入


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
		/**
		 * 1.获得产品ID
		 * 2.通过产品ID获得商品（应该唯一）
		 * 3.设置此商品的折扣
		 * 4.修改此商品
		 */
		for(Commodity commodity : commodityDao.findByProductsID(sysAdmin.getProductID(type, entityID)))
		{
			commodity.setDiscount(discount);
			commodityDao.merge(commodity);
		}
		return SUCCESS;
	}

}
