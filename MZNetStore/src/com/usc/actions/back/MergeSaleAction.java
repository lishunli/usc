package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.services.back.ISystemAdmin;

/**
 * 修改促销商品（促销价或优先级）
 * 
 * @author MZ
 *
 * 2009-8-28上午09:44:12
 */
public class MergeSaleAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
	private float salePrice;// 促销价
	private int priority;//优先级
	
	private ISystemAdmin sysAdmin;// 系统管理员实现实例化对象，通过Spring注入
	
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

	public float getSalePrice()
	{
		return salePrice;
	}

	public void setSalePrice(float salePrice)
	{
		this.salePrice = salePrice;
	}

	public int getPriority()
	{
		return priority;
	}

	public void setPriority(int priority)
	{
		this.priority = priority;
	}

	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}

	@Override
	public String execute() throws Exception
	{
		sysAdmin.mergeSale(type, entityID, salePrice, priority);//修改促销表，促销价和优先级
		return SUCCESS;
	}

}
