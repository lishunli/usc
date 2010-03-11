package com.usc.actions.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.BookExtra;
import com.usc.daos.DigitalExtra;
import com.usc.services.custom.IMain;

/**
 * 数码高级搜索
 *
 * @author MZ
 *
 * 2009-8-30上午10:36:22
 */
public class AdvancedSearchDigitalAction extends ActionSupport
{
	private String digitalName;
	private String brand;
	private IMain mainImpl;
	
	public String getDigitalName()
	{
		return digitalName;
	}
	public void setDigitalName(String digitalName)
	{
		this.digitalName = digitalName;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public void setMainImpl(IMain mainImpl)
	{
		this.mainImpl = mainImpl;
	} 
	
	@Override
	public String execute() throws Exception
	{
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("digitalCommonInit", mainImpl.AdvancedSearchDigitalCommon(digitalName, brand));
		request.put("digitalSaleInit", mainImpl.AdvancedSearchDigitalSale(digitalName, brand));
		return SUCCESS;
	}
	
}
