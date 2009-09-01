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
 * 图书高级搜索
 * 
 * @author MZ
 *
 * 2009-8-30上午10:34:35
 */
public class AdvancedBookSearchAction extends ActionSupport
{
	private String bookName;
	private String author;
	private String isbn;
	private String publisher;
	private IMain mainImpl;
	
	
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public void setMainImpl(IMain mainImpl)
	{
		this.mainImpl = mainImpl;
	} 

	@Override
	public String execute() throws Exception
	{
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("bookCommonInit",mainImpl.AdvancedBookSearchCommon(bookName, author, isbn, publisher));
		request.put("bookSaleInit", mainImpl.AdvancedBookSearchSale(bookName, author, isbn, publisher));
		return SUCCESS;
	}
}
