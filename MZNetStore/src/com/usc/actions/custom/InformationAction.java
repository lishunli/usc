package com.usc.actions.custom;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.services.custom.IMain;

public class InformationAction extends ActionSupport
{
	private int entityID;
	private int type;
	private IMain mainImpl;
	
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
	
	public void setMainImpl(IMain mainImpl)
	{
		this.mainImpl = mainImpl;
	}
	@Override
	public String execute() throws Exception
	{
		Map request = (Map) ActionContext.getContext().get("request");
		if(1 == type)
		{
			request.put("bookCommonInit",mainImpl.BookCommonInfo(type, entityID));
			request.put("bookSaleInit", mainImpl.BookSaleInfo(type, entityID));
			return "bookInfo";
		}
		else if(2 ==  type)
		{
			request.put("digitalCommonInit", mainImpl.DigitalCommonInfo(type, entityID) );
			request.put("digitalSaleInit", mainImpl.DigitalSaleInfo(type, entityID));
			return "digitalInfo";
		}
		return INPUT;
	}
	

}
