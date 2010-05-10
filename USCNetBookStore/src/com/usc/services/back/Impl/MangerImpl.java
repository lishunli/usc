package com.usc.services.back.Impl;

import java.util.List;

import com.usc.daos.BookDAO;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.services.back.IManger;
import com.usc.utils.EncoderByMd5;

/**
 * 后台管理员公共部分接口的实现
 * 
 * @author MZ
 * 
 */
public class MangerImpl implements IManger
{
	private OperatorDAO operDao;// 后台管理员DAO
	private BookDAO bookDao;
	private DigitalDAO digitalDAO;

	public void setBookDao(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}

	public void setOperDao(OperatorDAO operDao)
	{
		this.operDao = operDao;
	}

	public void setDigitalDAO(DigitalDAO digitalDAO)
	{
		this.digitalDAO = digitalDAO;
	}

	/**
	 * 检查管理员登录用户
	 */
	public Operator checkManger(Operator operator)
	{
		// 此管理员姓名存在
		// 遍历此姓名的管理员，是否密码匹配（重名现象了）
		for (Operator oper : operDao.findByOperatorName(operator.getOperatorName().trim()))
		{
			if (oper.getOperatorPass().equals(new EncoderByMd5().encoderByMd5(operator.getOperatorPass())))
			{
				return oper;// 姓名和密码都能匹配，返回真
			}
		}
		return null;
	}

	/**
	 * 修改密码
	 */
	public boolean updatePass(Operator operator, String newPass)
	{

		// 遍历此姓名的管理员，是否密码匹配（重名现象了）
		for (Operator oper : operDao.findByOperatorName(operator.getOperatorName().trim()))
		{
			EncoderByMd5 encoderByMd5 = new EncoderByMd5();
			if (oper.getOperatorPass().equals(encoderByMd5.encoderByMd5(operator.getOperatorPass())))
			{
				oper.setOperatorPass(encoderByMd5.encoderByMd5(newPass));// 设置新密码
				operDao.merge(oper);// 修改
				return true;// 修改成功，返回真
			}
		}

		return false;
	}

	/**
	 * 对图书表进行ISBN唯一性验证
	 */
	public boolean checkIsbnIsExist(String isbn)
	{
		if (!bookDao.findByIsbn(isbn).isEmpty())// 不存在也即唯一，返回真
			return true;
		return false;
	}

	/**
	 * 对数码表进行条形码唯一性验证
	 */
	public boolean checkBarCodeIsExist(String barcode)
	{
		if (!digitalDAO.findByBarcode(barcode).isEmpty())// 不存在也即唯一，返回真
			return true;
		return false;
	}

	/* 
	 * @see com.usc.services.back.IManger#checkMangerIsExist(com.usc.daos.Operator)
	 */
	@SuppressWarnings("null")
	public boolean checkMangerIsExist(Operator operator)
	{
		// 此管理员姓名存在
		List<Operator> findByOperatorName = operDao.findByOperatorName(operator.getOperatorName().trim());
		if(findByOperatorName != null && findByOperatorName.size() != 0)
		{
			return true;
		}
		return false;
	}

	/* 
	 * @see com.usc.services.back.IManger#saveOperator(com.usc.daos.Operator)
	 */
	public void saveOperator(Operator operator)
	{
//		encoderByMd5
		operator.setOperatorPass(new EncoderByMd5().encoderByMd5(operator.getOperatorPass()));
		operDao.save(operator);
	}

}
