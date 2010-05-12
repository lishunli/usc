package com.usc.actions.back;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Commodity;
import com.usc.daos.CommodityDAO;
import com.usc.daos.Operator;
import com.usc.services.back.ISystemAdmin;

/**
 * ������Ʒ
 * 
 * @author MZ
 * 
 *         2009-8-28����09:44:23
 */
public class PublisheAction extends ActionSupport
{
	private int entityID;// ʵ��ID
	private int type;// ���ͣ�1Ϊͼ�飬2Ϊ����
	private float discount;// �ۿ�

	private ISystemAdmin sysAdmin;// ϵͳ����Աʵ��ʵ��������ͨ��Springע��
	private Commodity commodity;// ��Ʒ����ͨ��Springע��
	private CommodityDAO commodityDao;// ��Ʒ����DAO��ͨ��Springע��

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
		sysAdmin.setProductPFlag(type, entityID, 1);// ���ò�Ʒ������־λ1
		commodity.setDiscount(discount);// �����ۿ�
		Operator operator = (Operator)ActionContext.getContext().getSession().get("manger");
		commodity.setOperatorID(operator.getOperatorId());// ���ò���ԱID
		commodity.setProductsID(sysAdmin.getProductID(type, entityID));// ���ò�ƷID
		commodity.setPublisheTime(new Date());// ���ò�Ʒ����ʱ��Ϊ��ǰϵͳʱ��
		commodity.setSaleFlag(0);// ������Ʒ��־λ��Ĭ��Ϊ0��1�Ļ����Ǵ�����Ʒ
		commodityDao.save(commodity);// ��ӵ���Ʒ����
		return SUCCESS;
	}
}
