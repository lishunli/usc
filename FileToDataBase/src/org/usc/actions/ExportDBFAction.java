package org.usc.actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.usc.daos.Student;
import org.usc.daos.StudentDAO;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 从MySql数据库导出为DBF格式文件
 * 
 * @author ShunLi
 * @Time 2009-12-24
 */
public class ExportDBFAction extends ActionSupport
{

	private StudentDAO sDAO;

	public void setsDAO(StudentDAO sDAO)
	{
		this.sDAO = sDAO;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return
	 */
	public String execute()
	{

		DBFField fields[] = new DBFField[6];

		fields[0] = new DBFField();
		fields[0].setName("no");
		fields[0].setDataType(DBFField.FIELD_TYPE_C);
		fields[0].setFieldLength(10);

		fields[1] = new DBFField();
		fields[1].setName("name");
		fields[1].setDataType(DBFField.FIELD_TYPE_C);
		fields[1].setFieldLength(20);

		fields[2] = new DBFField();
		fields[2].setName("sex");
		fields[2].setDataType(DBFField.FIELD_TYPE_C);
		fields[2].setFieldLength(20);

		fields[3] = new DBFField();
		fields[3].setName("age");
		fields[3].setDataType(DBFField.FIELD_TYPE_N);
		fields[3].setFieldLength(20);

		fields[4] = new DBFField();
		fields[4].setName("score");
		fields[4].setDataType(DBFField.FIELD_TYPE_F);
		fields[4].setFieldLength(20);

		fields[5] = new DBFField();
		fields[5].setName("eduTime");
		fields[5].setDataType(DBFField.FIELD_TYPE_D);

		try
		{

			DBFWriter writer = new DBFWriter();
			writer.setCharactersetName("GB2312");
			writer.setFields(fields);
			
			List<Student> list = sDAO.findAll();
			for (int i = 0; i < list.size(); i++)
			{
				Student stu = list.get(i);
				Object rowData[] = new Object[6];
				rowData[0] = stu.getNo();
				rowData[1] = stu.getName();
				rowData[2] = stu.getSex();
//				rowData[3] = new Double(20);
//				rowData[4] = new Double(90);
				rowData[3] = new Double(stu.getAge());
				rowData[4] = new Double(stu.getScore());
				rowData[5] = new java.util.Date(stu.getEduTime().getDate());
//				rowData[5] = stu.getEduTime();
				
				writer.addRecord(rowData);
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			OutputStream os = response.getOutputStream();

			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition",
					"attachment;filename=student.dbf");
			writer.write(os);
			os.flush();
			os.close();
			System.out.println("OK");

		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;

	}
}