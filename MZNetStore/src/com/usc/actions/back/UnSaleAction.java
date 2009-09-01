package com.usc.actions.back;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.services.back.ISystemAdmin;

/**
 * 设为普通商品
 * 
 * @author MZ
 *
 * 2009-8-28上午09:44:50
 */
public class UnSaleAction extends ActionSupport
{
	private int entityID;// 实物ID
	private int type;// 类型，1为图书，2为数码
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
	public void setSysAdmin(ISystemAdmin sysAdmin)
	{
		this.sysAdmin = sysAdmin;
	}
	
	@Override
	public String execute() throws Exception
	{
		sysAdmin.setsaleFlag(type, entityID, 0);//把类型和实物传过去，促销标志设置为0
		return SUCCESS;
	}
	
}
