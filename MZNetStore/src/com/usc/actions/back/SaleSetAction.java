package com.usc.actions.back;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Sale;
import com.usc.daos.SaleDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 设置为促销商品
 * 
 * @author MZ
 *
 * 2009-8-28上午09:44:32
 */
public class SaleSetAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	private float salePrice;// 促销价
	private int priority;//优先级
	
	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	private Commodity commodity;// 商品对象，通过Spring注入
	private CommodityDAO commodityDao;// 商品对象DAO，通过Spring注入
	private Sale sale;//促销商品对象，通过Spring注入
	private SaleDAO saleDao;//促销商品对象DAO，通过Spring注入
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
	public int getPriority()
	{
		return priority;
	}
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	public Sale getSale()
	{
		return sale;
	}
	public void setSale(Sale sale)
	{
		this.sale = sale;
	}
	public void setSalePrice(float salePrice)
	{
		this.salePrice = salePrice;
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
	public void setSaleDao(SaleDAO saleDao)
	{
		this.saleDao = saleDao;
	}
	
	@Override
	public String execute() throws Exception
	{
		//1.设促销标志位
		//2.写人到促销表中
		sysAdmin.setsaleFlag(type, entityID, 1);
		sale.setCommodityId(sysAdmin.getCommodityID(type, entityID));
		sale.setOperatorID(sysAdmin.getOperatorID(ActionContext.getContext().getSession().get("manger").toString()));
		sale.setSalePrice(salePrice);
		sale.setPriority(priority);
		//设置表中属性
		sysAdmin.saveSale(sale);//接口，保存商品，要考虑优先级存在问题
		return SUCCESS;
	}
	
}
