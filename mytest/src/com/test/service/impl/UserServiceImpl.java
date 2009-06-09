package com.test.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.test.bean.User;
import com.test.dao.UserDAO;
import com.test.service.UserService;

public class UserServiceImpl implements UserService
{
	private UserDAO userDao;

	public UserDAO getUserDao()
	{
		return userDao;
	}

	public void setUserDao(UserDAO userDao)
	{
		this.userDao = userDao;
	}

	public void delete(User user)
	{
		this.userDao.removeUser(user);
	}

	public List<User> findAll()
	{
		return this.userDao.findAllUsers();
	}

	public User findById(Integer id)
	{
		return this.userDao.findUserById(id);
	}

	public void save(User user)
	{
		this.userDao.saveUser(user);
	}

	public void update(User user)
	{
		this.userDao.updateUser(user);
	}

	public InputStream getInputStream()
	{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("序号");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("姓");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("名");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("年龄");

		List<User> list = this.findAll();

		for (int i = 0; i < list.size(); ++i)
		{
			User user = list.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(i + 1);

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getFirstname());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getLastname());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(user.getAge());
		}

		// //方法一，生成xls的方法，临时文件
		// //String fileName = CharacterUtils.getRandomString(10);
		//		
		// String fileName = RandomStringUtils.randomAlphanumeric(10);
		//		
		// fileName = new StringBuffer(fileName).append(".xls").toString();
		//		
		// final File file = new File(fileName);
		//
		// try
		// {
		// OutputStream os = new FileOutputStream(file);
		// wb.write(os);
		// os.close();
		// }
		// catch (Exception e)
		// {
		// e.printStackTrace();
		// }
		//
		// InputStream is = null;
		// try
		// {
		// is = new FileInputStream(file);
		// }
		// catch (FileNotFoundException e)
		// {
		// e.printStackTrace();
		// }
		//	
		// // new Thread(new Runnable()
		// // {
		// // public void run()
		// // {
		// // try
		// // {
		// // Thread.sleep(15000);
		// // }
		// // catch (InterruptedException e)
		// // {
		// // e.printStackTrace();
		// // }
		// //
		// // file.delete();//删除临时文件
		// // }
		// // }).start();
		//		
		//
		// return is;

		// 方法二：获得xls文件，从内存中得到,下面的不可取
		// byte[] content = wb.getBytes();
		// InputStream is = new ByteArrayInputStream(content);
		//		
		// return is;

		// 方法二：获得xls文件，从内存中得到
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try
		{
			wb.write(os);
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();

		InputStream is = new ByteArrayInputStream(content);

		return is;

	}

}
