package com.usc.actions.back;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Book;
import com.usc.daos.Digital;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Products;
import com.usc.daos.ProductsDAO;
import com.usc.daos.ProducttypeDAO;
import com.usc.services.back.IManger;

/**
 * 数码录入
 * @author MZ
 *
 */
public class DigitalEntryAction extends ActionSupport
{
	private Digital digital;//图书,通过Struts2传入
	private File upload;//上传的图片
	private int[] PTypeID;//type，数组，存取整个下拉框选择的值
	private IManger manger;// 接口实现对象，通过Spring注入
	private DigitalDAO digitalDao;//图书dao，通过Spring注入
	private ProducttypeDAO pTypeDao;//ProducttypeDAO，通过Spring注入
	private Products product;//产品，通过Spring注入
	private ProductsDAO pDao;//产品DAO，通过Spring注入

	/**
	 * 下面的验证
	productTypeID  //不能为0，如果为0提示请选择
	digitalName //不能为空
	brand //品牌不能为空
	barcode 不能为空 且 固定格式 而且唯一
	publishedPrice//定价 不能为空且为float类型（类型判断）
	productsPflag//初始时设置为0
	upload//图片，上传有一定的大小和格式限制（可以为空）这个验证在Struts的配置文件中
	 * 
	 */
	
	
	@Override
	public void validate()
	{
		if(null != digital)//传过来的值不为空
		{
			if(null == digital.getBarcode() || "".equals(digital.getBarcode().trim()))//条形码 不能为空 而且唯一    且 固定格式
			{ 
				this.addFieldError("digital.barcode", "条形码不能为空");
			}
			else if(manger.checkBarCodeIsExist(digital.getBarcode().trim()))//条形码 不能为空 而且唯一    且 固定格式
			{
				this.addFieldError("digital.barcode", "条形码已存在，此产品已录入");
			}
			if(null == digital.getDigitalName() || "".equals(digital.getDigitalName().trim()))//digitalName不能为空
			{
				this.addFieldError("digital.digitalName", "数码名称不能为空");
			}
			if(null == digital.getPublishedPrice())//定价不能为空（格式通过Struts已经验证，错误信息在message.properties文件中）
			{
				this.addFieldError("digital.publishedPrice", "定价不能为空");
			}
			if(null == digital.getBrand() || "".equals(digital.getBrand().trim()))//brand 品牌不能为空
			{
				this.addFieldError("digital.brand", "品牌不能为空");
			}
			if(0== PTypeID[0])//没有选择分类
			{
				this.addFieldError("PTypeID", "请选择分类");
			}
			else if(2 != PTypeID[0])//在类型表中2为数码，也就是选择的类型不是数码的话
			{
				this.addFieldError("PTypeID", "请选择数码分类");
			}
			
		}
	}


	@Override
	public String execute() throws Exception
	{
		if(null != digital)//传过来的值不为空
		{
			if(null != upload)
			{
				FileInputStream fin = new FileInputStream(upload);//File 转 InputStream
				Blob blob = Hibernate.createBlob(fin);//InputStream 转 Blob
				digital.setPhoto(blob);
			}
			int i=0;
			for(;i<PTypeID.length;i++)
			{
				if(PTypeID[i] == 0)//为0表示没有子类了，所以前一个就是最小的子类
					break;
			}
			digital.setProductTypeID(PTypeID[i-1]);//前一个就是最小的子类
			digital.setProductsPflag(0);//初始时设置为0
			digitalDao.save(digital);//录入数码，同时要想产品表中插入数据
			product.setProductTypeId(PTypeID[0]);//设置产品表中的产品分类ID，为最大类的ID
			for(Digital d : digitalDao.findByBarcode(digital.getBarcode().trim()))//通过Barcode找到该digital并获取digitalID
			{
				product.setEntityId(d.getDigitalId());//把获取的digitalID作为实物ID设置进
			}
			pDao.save(product);//保存为产品
			return SUCCESS;
		}
		return INPUT;
	}
	
	
	public Digital getDigital()
	{
		return digital;
	}

	public void setDigital(Digital digital)
	{
		this.digital = digital;
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

	public void setDigitalDao(DigitalDAO digitalDao)
	{
		this.digitalDao = digitalDao;
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

}
