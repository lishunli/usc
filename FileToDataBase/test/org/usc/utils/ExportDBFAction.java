package org.usc.utils;

import java.io.FileOutputStream;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

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

			Object rowData[] = new Object[6];
			rowData[0] = "20064440150";
			rowData[1] = "ÀîË³Àû";
			rowData[2] = "ÄÐ";
			rowData[3] = new Double(20);
			rowData[4] = new Double(90);
			rowData[5] = new java.util.Date();

			writer.addRecord(rowData);

			FileOutputStream fos;

			fos = new FileOutputStream("c:/test.dbf");
			writer.write(fos);
			fos.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
}