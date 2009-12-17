package org.usc.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;
import com.opensymphony.xwork2.ActionSupport;

public class ExportDBFAction 
{

	public static void main(String[] args)
	{
		DBFField fields[] = new DBFField[6];

		fields[0] = new DBFField();
		fields[0].setName("Ñ§ºÅ");
		fields[0].setDataType(DBFField.FIELD_TYPE_C);
		fields[0].setFieldLength(10);

		fields[1] = new DBFField();
		fields[1].setName("name");
		fields[1].setDataType(DBFField.FIELD_TYPE_C);
		fields[1].setFieldLength(20);

//		fields[2] = new DBFField();
//		fields[2].setName("salary");
//		fields[2].setDataType(DBFField.FIELD_TYPE_N);
//		fields[2].setFieldLength(12);
//		fields[2].setDecimalCount(2);
		
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
//		fields[5].setFieldLength(20);
	
		
		
		
		try
		{
			DBFWriter writer = new DBFWriter();
			writer.setCharactersetName("gbk"); 
			writer.setFields(fields);

			// now populate DBFWriter
			//

			Object rowData[] = new Object[6];
			rowData[0] = "20064440150";
			rowData[1] = "ÀîË³Àû";
			rowData[2] = "ÄÐ";
			rowData[3] = new Double(20);
			rowData[4] = new Double(90);
			rowData[5] = new java.util.Date();
			

			writer.addRecord(rowData);

//			rowData = new Object[3];
//			rowData[0] = "1001";
//			rowData[1] = "Lalit";
//			rowData[2] = new Double(3400.00);
//
//			writer.addRecord(rowData);
//
//			rowData = new Object[3];
//			rowData[0] = "1002";
//			rowData[1] = "Rohit";
//			rowData[2] = new Double(7350.00);
//
//			writer.addRecord(rowData);

			FileOutputStream fos;

			fos = new FileOutputStream("c:/test.dbf");
			writer.write(fos);
			fos.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}