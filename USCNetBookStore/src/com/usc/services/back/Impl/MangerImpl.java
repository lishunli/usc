package com.usc.services.back.Impl;

import java.util.List;

import com.usc.daos.BookDAO;
import com.usc.daos.DigitalDAO;
import com.usc.daos.Operator;
import com.usc.daos.OperatorDAO;
import com.usc.services.back.IManger;
import com.usc.utils.EncoderByMd5;

/**
 * ��̨����Ա�������ֽӿڵ�ʵ��
 * 
 * @author MZ
 * 
 */
public class MangerImpl implements IManger
{
	private OperatorDAO operDao;// ��̨����ԱDAO
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
	 * ������Ա��¼�û�
	 */
	public Operator checkManger(Operator operator)
	{
		// �˹���Ա��������
		// �����������Ĺ���Ա���Ƿ�����ƥ�䣨���������ˣ�
		for (Operator oper : operDao.findByOperatorName(operator.getOperatorName().trim()))
		{
			if (oper.getOperatorPass().equals(new EncoderByMd5().encoderByMd5(operator.getOperatorPass())))
			{
				return oper;// ���������붼��ƥ�䣬������
			}
		}
		return null;
	}

	/**
	 * �޸�����
	 */
	public boolean updatePass(Operator operator, String newPass)
	{

		// �����������Ĺ���Ա���Ƿ�����ƥ�䣨���������ˣ�
		for (Operator oper : operDao.findByOperatorName(operator.getOperatorName().trim()))
		{
			EncoderByMd5 encoderByMd5 = new EncoderByMd5();
			if (oper.getOperatorPass().equals(encoderByMd5.encoderByMd5(operator.getOperatorPass())))
			{
				oper.setOperatorPass(encoderByMd5.encoderByMd5(newPass));// ����������
				operDao.merge(oper);// �޸�
				return true;// �޸ĳɹ���������
			}
		}

		return false;
	}

	/**
	 * ��ͼ������ISBNΨһ����֤
	 */
	public boolean checkIsbnIsExist(String isbn)
	{
		if (!bookDao.findByIsbn(isbn).isEmpty())// ������Ҳ��Ψһ��������
			return true;
		return false;
	}

	/**
	 * ����������������Ψһ����֤
	 */
	public boolean checkBarCodeIsExist(String barcode)
	{
		if (!digitalDAO.findByBarcode(barcode).isEmpty())// ������Ҳ��Ψһ��������
			return true;
		return false;
	}

	/* 
	 * @see com.usc.services.back.IManger#checkMangerIsExist(com.usc.daos.Operator)
	 */
	@SuppressWarnings("null")
	public boolean checkMangerIsExist(Operator operator)
	{
		// �˹���Ա��������
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
