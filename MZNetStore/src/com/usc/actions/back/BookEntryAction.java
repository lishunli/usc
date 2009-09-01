package com.usc.actions.back;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.BookDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.daos.ProducttypeDAO;
import com.usc.services.back.IManger;

/**
 * 图书录入Action
 * @author MZ
 *
 */
public class BookEntryAction extends ActionSupport
{
	private Book book;//图书,通过Struts2传入
	private File upload;//上传的图片
	private int[] PTypeID;//type，数组，存取整个下拉框选择的值
	private IManger manger;// 接口实现对象，通过Spring注入
	private BookDAO bookDao;//图书dao，通过Spring注入
	private ProducttypeDAO pTypeDao;//ProducttypeDAO，通过Spring注入
	private Products product;//产品，通过Spring注入
	private ProductsDAO pDao;//产品DAO，通过Spring注入

	
	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public File getUpload()
	{
		return upload;
	}

	public void setUpload(File upload)
	{
		this.upload = upload;
	}

	public int[] getPTypeID()
	{
		return PTypeID;
	}

	public void setPTypeID(int[] typeID)
	{
		PTypeID = typeID;
	}

	public void setManger(IManger manger)
	{
		this.manger = manger;
	}

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setPTypeDao(ProducttypeDAO typeDao)
	{
		pTypeDao = typeDao;
	}

	public void setProduct(Products product)
	{
		this.product = product;
	}

	public void setPDao(ProductsDAO dao)
	{
		pDao = dao;
	}

	/**
	 * 下面的验证
	productTypeID  //不能为0，如果为0提示请选择
	bookName //不能为空
	publisher //不能为空
	isbn //不能为空 且 固定格式 而且唯一
	publishedPrice//不能为空且为float类型（类型判断）
	publishedTime//可以为空，但不为空时必须满足日期格式
	productsPflag//初始时设置为0
	upload//图片，上传有一定的大小和格式限制（可以为空）这个验证在Struts的配置文件中
	 * 
	 */
	
	
	@Override
	public void validate()
	{
		if(null != book)//传过来的值不为空
		{
			if(null == book.getIsbn() || "".equals(book.getIsbn().trim()))//isbn 不能为空 而且唯一    且 固定格式
			{ 
				this.addFieldError("book.isbn", "ISBN不能为空");
			}
			else if(manger.checkIsbnIsExist(book.getIsbn().trim()))//isbn 不能为空 而且唯一    且 固定格式
			{
				this.addFieldError("book.isbn", "ISBN已存在，此产品已录入");
			}
			if(null == book.getBookName() || "".equals(book.getBookName().trim()))//BookName不能为空
			{
				this.addFieldError("book.bookName", "图书名不能为空");
			}
			if(null == book.getPublishedPrice())//定价不能为空（格式通过Struts已经验证，错误信息在message.properties文件中）
			{
				this.addFieldError("book.publishedPrice", "定价不能为空");
			}
			if(null == book.getPublisher() || "".equals(book.getPublisher().trim()))//出版社不能为空
			{
				this.addFieldError("book.publisher", "出版社不能为空");
			}
			if(0== PTypeID[0])//没有选择分类
			{
				this.addFieldError("PTypeID", "请选择分类");
			}
			else if(1 != PTypeID[0])//在类型表中1为图书，也就是选择的类型不是图书的话
			{
				this.addFieldError("PTypeID", "请选择图书分类");
			}
			//publishedTime//可以为空，但不为空时必须满足日期格式（格式通过Struts已经验证，错误信息在message.properties文件中）
			
		}
	}

	@Override
	public String execute() throws Exception
	{
		if(null != book)//传过来的值不为空
		{
			if(null != upload)
			{
				FileInputStream fin = new FileInputStream(upload);//File 转 InputStream
				Blob blob = Hibernate.createBlob(fin);//InputStream 转 Blob
				book.setPicture(blob);
			}
			int i=0;
			for(;i<PTypeID.length;i++)
			{
				if(PTypeID[i] == 0)//为0表示没有子类了，所以前一个就是最小的子类
					break;
			}
			book.setProductTypeID(PTypeID[i-1]);//前一个就是最小的子类
			book.setProductsPflag(0);//初始时设置为0
			bookDao.save(book);//录入图书，同时要想产品表中插入数据
			product.setProductTypeId(PTypeID[0]);//设置产品表中的产品分类ID，为最大类的ID
			for(Book b : bookDao.findByIsbn(book.getIsbn().trim()))//通过ISBN找到该book并获取bookID
			{
				product.setEntityId(b.getBookId());//把获取的bookID作为实物ID设置进
			}
			pDao.save(product);//保存为产品
			return SUCCESS;
		}
		return INPUT;
	}
}
