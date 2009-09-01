package com.usc.services.custom;

import java.util.List;

import com.usc.daos.Book;
import com.usc.daos.BookExtra;
import com.usc.daos.Digital;
import com.usc.daos.DigitalExtra;

/**
 * 主界面接口
 *
 * @author MZ
 *
 * 2009-8-30上午10:53:29
 */
public interface IMain {
	List<BookExtra> AdvancedBookSearchCommon(String bookName,String author,String isbn,String publisher);//图书高级搜索
	List<BookExtra> AdvancedBookSearchSale(String bookName,String author,String isbn,String publisher);//图书高级搜索
	List<DigitalExtra> AdvancedSearchDigitalCommon(String digitalName,String brand);	//数码高级搜索
	List<DigitalExtra> AdvancedSearchDigitalSale(String digitalName,String brand);	//数码高级搜索
	
	List<BookExtra> BookCommonInfo(int typeId, int bookId);//图书高级搜索
	List<BookExtra> BookSaleInfo(int typeId, int bookId);//图书高级搜索
	List<DigitalExtra> DigitalCommonInfo(int typeId, int digitalId);	//数码高级搜索
	List<DigitalExtra> DigitalSaleInfo(int typeId, int digitalId);	//数码高级搜索
	
}
