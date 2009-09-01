package com.usc.actions.back;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 撤销发布
 * 
 * @author MZ
 *
 * 2009-8-28上午09:44:40
 */
public class UnPublisheAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	
	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	private Commodity commodity;// 商品对象，通过Spring注入
	private CommodityDAO commodityDao;// 商品对象DAO，通过Spring注入
	public int getEntityID()
	{
		return entityID;
	}
	public void setEntityID(int entityID)
	{
		this.entityID = entityID;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
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
		sysAdmin.setProductPFlag(type, entityID, 0);//设置产品发布标志位0
		/**
		 * 删除已发布的产品从商品表中
		 */
		/**
		 * 1.根据类型和实物ID来找到产品ID
		 * 2.通过产品ID找到商品ID（应该唯一）
		 * 3.删除该商品
		 */
		for(Commodity commodity : commodityDao.findByProductsID(sysAdmin.getProductID(type, entityID)))
		{
			commodityDao.delete(commodity);
		}
		return SUCCESS;
	}

	
}
