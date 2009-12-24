package org.usc.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFWriter;

public class DBF_tool {

	//java.lang.String
	public static final byte FIELD_TYPE_C = 67;

	//java.lang.Boolean
	public static final byte FIELD_TYPE_L = 76;

	//java.lang.Double
	public static final byte FIELD_TYPE_N = 78;

	//lava.lang.Double
	public static final byte FIELD_TYPE_F = 70;

	//java.util.Date
	public static final byte FIELD_TYPE_D = 68;

	private String fileOpenPath,   // 打开文件所需路径存储
	               fileCreatePath; //创建文件所需路径存储
	private W_readDBF rdbf;  //读文件操作对象
	private W_writeDBF wdbf; //写文件操作对象
	private Vector<Byte> filedSave;//表头属性存储，在插入数据时通过此变量来判断数据类型
	
	/**
	 * 构造函数，初始化一些变量
	 */
	public DBF_tool() {
		// TODO Auto-generated constructor stub
		filedSave = new Vector<Byte>();
	}
	
	/**
	 * 打开dbf文件操作
	 * @param filePath
	 */
	void openFile(String filePath) {
		// TODO Auto-generated method stub
		this.fileOpenPath = filePath;
		if (filePath=="") {
			System.out.println("打开文件操作没有指明路径，系统退出");
			System.exit(-1);
		}		
		rdbf = new W_readDBF(fileOpenPath);
	}
	
	/**
	 * 得到dbf文件属性的个数（列数）
	 * @return int
	 */
	int DBFGetFieldCount() {
		// TODO Auto-generated method stub
		return rdbf.DBFGetFieldCount();
	}
	 
	/**
	 * 得到dbf文件的条数（行数）
     * @return int
	 */
	int DBFGetRecordCount() {
	    // TODO Auto-generated method stub
	    return rdbf.DBFGetRecordCount();
	} 
	
	/**
	 * 得到第num个属性段的详细信息
	 * @param num 属性段的位置
	 * @return FiledInfor
	 */
	FiledInfor getDBFFiledInfor(int num) {
		// TODO Auto-generated method stub
		return rdbf.getDBFFiledInfor(num);
	}

	/**
	 * 根据属性段的名称得到属性段所在的位置
	 * @param input 属性段名称
	 * @return int
	 */
	int getDBFFiledNum(String input) {
		// TODO Auto-generated method stub
		return rdbf.getDBFFiledNum(input);
	}

	/**
	 * 读取dbf文件中详细位置的数据，限定行和列，从0算起
	 * @param line 行
	 * @param nFiled 列
	 * @return Object
	 */
	Object getContent(int line, int nFiled) {
		// TODO Auto-generated method stub
		return rdbf.getContent(line, nFiled);
	}
	
	/**
	 * 得到dbf文件指定的一列，从0算起
	 * @param nFiled 列
	 * @return Object[]
	 */
	Object[] getContent(int nFiled) {
		// TODO Auto-generated method stub
		return rdbf.getContent(nFiled);
	}
	
	/**
	 * 创建dbf操作
	 * @param filePath
	 */
	public void createFile(String filePath) {
		// TODO Auto-generated method stub
		this.fileCreatePath = filePath;
		if (filePath=="") {
			System.out.println("创建文件操作没有指明路径，系统退出");
			System.exit(-1);
		}
		wdbf = new W_writeDBF(fileCreatePath);
	}
	
	/**
	 * 生成表头信息
	 * @param vecFiled
	 */
	void writeFiled(Vector<FiledInfor> vecFiled) {
		// TODO Auto-generated method stub
		if (!filedSave.isEmpty()) {
			System.out.println("异常:表头数据已经插入过一次，请检查，系统退出！");
		    System.exit(-1);
		}
		
		for (int i = 0; i < vecFiled.size(); i++) {
			filedSave.add(vecFiled.elementAt(i).filedDataType);
			wdbf.add(vecFiled.elementAt(i));
		}
		wdbf.writeDBFTitle();
	}
	
	/**
	 * 将每行dbf内容输入到文件中
	 * @param dbfLine
	 */
	void writeDBFLine(String dbfLine) {
		// TODO Auto-generated method stub
		Vector<String> vecTemp = vecSplit(dbfLine);
		
		if (vecTemp.size() < filedSave.size()) {
			System.out.println("输入dbf内容时数据分段异常："+dbfLine);
			System.out.println("请检查，系统退出！");
			System.exit(-1);
		}
		
		for (int i = 0; i < filedSave.size(); i++) {
			if (filedSave.elementAt(i) == FIELD_TYPE_C) {
				wdbf.addStringLine(vecTemp.elementAt(i));
			}else if (filedSave.elementAt(i) == FIELD_TYPE_L) {
				wdbf.addBooleanLine(vecTemp.elementAt(i));
			}else if (filedSave.elementAt(i) == FIELD_TYPE_N
				    ||filedSave.elementAt(i) == FIELD_TYPE_F) {
				wdbf.addDoubleLine(vecTemp.elementAt(i));
			}else if (filedSave.elementAt(i) == FIELD_TYPE_D) {
				wdbf.addDateLine(vecTemp.elementAt(i));
			}else{
				System.out.println("无法解析的filedSave(表头信息类型)["+i+"]="
						+filedSave.elementAt(i)+"\n请检查，系统退出！");
				System.exit(-1);
			}
		}
		
		wdbf.writeLine();
	}
	
	/**
	 * 新建一个相同结构的空dbf表
	 * @param copyPath 复制路径
	 * @param pastePath 粘贴路经
	 */
	void copyDBFtitle(String copyPath ,String pastePath) {
		// TODO Auto-generated method stub
		openFile(copyPath);//读
		createFile(pastePath);//写
		Vector<FiledInfor> vecTitle = new Vector<FiledInfor>();//表头存储
		
		for (int i = 0; i < DBFGetFieldCount(); i++) {
			vecTitle.add(getDBFFiledInfor(i));
		}
		
		writeFiled(vecTitle);		
	}
	
	/**
	 * 关闭操作，此处禁止抛出异常
	 */
	void close(){
		// TODO Auto-generated method stub
		try {
			wdbf.close();
			rdbf.close();
		} catch (Exception e){}
	}
	
	/**
	 * split the string with the tag ",",and it can contain ""
	 * @param input
	 * @return
	 */
	private Vector<String> vecSplit(String input) {
		// TODO Auto-generated method stub
		Vector<String> output = new Vector<String>();
		
		input += ",";
		char[] chrTemp = input.toCharArray();
		String strTemp = "";
		for (int i = 0; i < chrTemp.length; i++) {
			if (chrTemp[i]!=',') {
				strTemp += chrTemp[i];
			}else {
				output.add(strTemp);
				strTemp = "";
			}
		}		
		
		return output;
	}
	
	/**
	 * 操作说明文档
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/************************************************/
		/* 初始化dbf操作对象                                   */
		/************************************************/
		DBF_tool dbf = new DBF_tool();
		/************************************************/
		/* 创建dbf操作，生成"creatDBF.dbf"，此处采用相对路径  */
		/* 也可以用绝对路径进行创建                             */
		/************************************************/
		System.out.println("正在创建dbf文件：student.dbf ...");
		dbf.createFile("student.dbf");
		//dbf.createFile("D:\\student.dbf");//绝对路径
		/************************************************/
		/* 创建dbf表头信息，此处只能一次性输入所有表头信息       */
		/* 表头信息由FiledInfor类生成，然后放入vector中       */
		/* 此处为：编号，姓名，年龄，salary（薪水），出生日期   */
		/************************************************/
		System.out.println("创建dbf文件表头信息 ...");
		FiledInfor filedinfor;//表头信息对象
		Vector<FiledInfor> vecTitle = new Vector<FiledInfor>();
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_C;//类型
		filedinfor.filedName = "no";                  //名称
		filedinfor.fieldLength = 11;                      //长度
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_C;
		filedinfor.filedName = "name";
		filedinfor.fieldLength = 12;
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_C;
		filedinfor.filedName = "sex";
		filedinfor.fieldLength = 2;
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_N;
		filedinfor.filedName = "age";
		filedinfor.fieldLength = 5;
		filedinfor.decimalCount = 0;                    //精度
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_F;
		filedinfor.filedName = "score";//不支持"salary(**)"这种方式，但支持中英文结合
		filedinfor.fieldLength = 7;
		filedinfor.decimalCount = 2;
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_D;
		filedinfor.filedName = "eduTime";
		vecTitle.add(filedinfor);
		dbf.writeFiled(vecTitle);
		/************************************************/
		/* 创建dbf表内容信息                                   */
		/************************************************/
		System.out.println("向dbf文件中添加内容 ...");
		String dbfLine;//dbf每行的内容，filed之间以","分隔
		dbfLine = "20064440151,李顺利,男,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,李顺利,男,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,李顺利,男,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,李顺利,男,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,李顺利,男,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000002,助理,30,10000.00,82-3-17";
//		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000003,小兵1,25,4000.12,87-5-20";
//		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000004,小兵2,28,4200,07-2-15";
//		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000005,小兵3,29,3800.00,02-4-23";
//		dbf.writeDBFLine(dbfLine);
		/************************************************/
		/* 关闭创建dbf表操作，此为必须操作                      */
		/************************************************/
		System.out.println("创建表操作结束！");
		dbf.close();
		/************************************************/
		/* 打开dbf操作,绝对路径和相对路径皆可                   */
		/************************************************/
		dbf = new DBF_tool();
		System.out.println("正在打开dbf文件：student.dbf ...");
		dbf.openFile("student.dbf");
		System.out.println("分析...");
		/************************************************/
		/* 得到dbf的行列个数                                   */
		/************************************************/
		System.out.println("此dbf文件的数据有："+dbf.DBFGetRecordCount()+
				         "行，"+dbf.DBFGetFieldCount()+"列，");
		/*******************************************************/
		/* 得到dbf各个字段的详细信息(目前可以得到：名称、类型、长度、精度 */
		/*******************************************************/
		System.out.println("各个字段的详细信息为：");
		for (int i = 0; i < dbf.DBFGetFieldCount(); i++) {
			filedinfor = dbf.getDBFFiledInfor(i);
			System.out.println("name:"+filedinfor.filedName+"  length:"+filedinfor.fieldLength);
		}
		/************************************************/
		/* 得到指定名称在dbf中的位置                           */
		/************************************************/
		System.out.println("其中，年龄在dbf表中的位置是："+dbf.getDBFFiledNum("年 龄"));
		/************************************************/
		/* 得到dbf中指定行数和列数的值,参数从0计                */
		/************************************************/
		System.out.println("第3行，第2列的值是："+dbf.getContent(2, 1));
		dbf.close();
		/************************************************/
		/* 复制dbf文件表头部分功能                             */
		/************************************************/
		dbf = new DBF_tool();
		System.out.println("将student.dbf的文件结构复制到新的文件copy.dbf中...");
		dbf.copyDBFtitle("student.dbf", "copy.dbf");
		dbf.close();
		System.out.println("演示结束！");
	}
}

class W_readDBF {
	
	private InputStream inputStream;//输入流支持
	private DBFReader reader;       //读取dbf文件对象
	private int numberOfFields,     //数据类型个数（列数）
	            numberofRecord;     //数据的条数（行数）
	private String dbfFileName;     //所提取的dbf文件名
	
	/**
	 * 构造函数,获取dbf对象，同时得到相关对象信息
	 * @param dbfFileName 需要提取的dbf文件对象名称
	 */
	public W_readDBF(String dbfFileName) {
		// TODO Auto-generated constructor stub
		this.dbfFileName = dbfFileName;
		try {
			inputStream = new FileInputStream(dbfFileName);
			reader = new DBFReader(inputStream);
			numberOfFields = reader.getFieldCount();
			numberofRecord = reader.getRecordCount();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到dbf文件属性的个数（列数）
	 * @return int
	 */
	 int DBFGetFieldCount() {
		// TODO Auto-generated method stub
		return numberOfFields;
	}
	
	/**
	 * 得到dbf文件的条数（行数）
	 * @return int
	 */
	int DBFGetRecordCount() {
		// TODO Auto-generated method stub
		return numberofRecord;
	}
	
	/**
	 * 得到第num个属性段的详细信息
	 * @param num 属性段的位置
	 * @return FiledInfor
	 */
	FiledInfor getDBFFiledInfor(int num) {
		// TODO Auto-generated method stub
		FiledInfor fTemp = new FiledInfor();
		try {
			fTemp.filedName = reader.getField(num).getName();
			fTemp.fieldLength = reader.getField(num).getFieldLength();
			fTemp.decimalCount = reader.getField(num).getDecimalCount();
			fTemp.filedDataType = reader.getField(num).getDataType();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return fTemp;
	}
	
	/**
	 * 根据属性段的名称得到属性段所在的位置
	 * @param input 属性段名称
	 * @return int
	 */
	int getDBFFiledNum(String input) {
		// TODO Auto-generated method stub
		int output = 0;
		for (int i = 0; i < numberOfFields; i++) {
			FiledInfor filedTemp = getDBFFiledInfor(i);
			String fddf = filedTemp.filedName;
			if (filedTemp.filedName.equals(input)) {
				output = i;
			}
		}
		
		return output;
	}
	
	/**
	 * 读取dbf文件中详细位置的数据，限定行和列，从0算起
	 * @param line 行
	 * @param nFiled 列
	 * @return Object
	 */
	Object getContent(int line, int nFiled) {
		// TODO Auto-generated method stub
		Object[] output = new Object[numberOfFields];//输出
		
		try {
			//对文件流进行刷新操作，相当于指针归位
			inputStream = new FileInputStream(dbfFileName);
			reader = new DBFReader(inputStream);
			
			for (int i = 0; i <= line; i++) {
				//得到第i行的数据
				output = reader.nextRecord();
			}		

			//对string类型进行重新编解码,否则可能输出乱码
			//"US-ASCII"; "ISO-8859-1"; "UTF-8"; "UTF-16BE"; "UTF-16LE"; "UTF-16"; "GBK";
			FiledInfor fTemp = getDBFFiledInfor(nFiled);
			if (fTemp.filedDataType==DBFField.FIELD_TYPE_C) {
				byte[] bs = ((String)output[nFiled]).getBytes("ISO-8859-1");
				output[nFiled] = (Object)(dropSpeace(new String(bs)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return output[nFiled];
	}
	
	/**
	 * 得到dbf文件指定的一列，从0算起
	 * @param nFiled 列
	 * @return Object[]
	 */
	Object[] getContent(int nFiled) {
		Object[] output = new Object[numberofRecord];//输出
		
		try {
			//对文件流进行刷新操作，相当于指针归位
			inputStream = new FileInputStream(dbfFileName);
			reader = new DBFReader(inputStream);
			
			for (int i = 0; i < numberofRecord; i++) {
				//得到第i行的数据
				Object[] objTemp = reader.nextRecord();
				
				//对string类型进行重新编解码,否则可能输出乱码
				//"US-ASCII"; "ISO-8859-1"; "UTF-8"; "UTF-16BE"; "UTF-16LE"; "UTF-16"; "GBK";
				FiledInfor fTemp = getDBFFiledInfor(nFiled);
				if (fTemp.filedDataType==DBFField.FIELD_TYPE_C) {
					byte[] bs = ((String)objTemp[nFiled]).getBytes("ISO-8859-1");
					objTemp[nFiled] = (Object)(dropSpeace(new String(bs)));
				}
				
				output[i] = objTemp[nFiled];
			}		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return output;
	}
	
	/**
	 * 去掉字符串输出时的多余的空格
	 * @param input 输入
	 * @return String 
	 */
	private String dropSpeace(String input) {
		// TODO Auto-generated method stub
		char[] charTemp= input.toCharArray();
		String strTemp = "",
		       output = "";
		for (int i = 0; i < charTemp.length; i++) {
			if (charTemp[i] == ' ') {
				strTemp += charTemp[i];
			}else{
				strTemp += charTemp[i];
				output += strTemp;
				strTemp = "";
			}
		}
		return output;
	}
	
	/**
	 * 关闭流操作
	 */
	void close() {
		// TODO Auto-generated method stub
		try {
			inputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

/**
 * 关于dbf属性段信息的存储
 * @author wangchen
 */
class FiledInfor implements Cloneable{
	String filedName; //属性名称
	int decimalCount, //精确度，精确到小数点后的位数，四舍五入
			fieldLength; //属性长度
	byte filedDataType;//属性类型

	/**
	 * 增加clone功能，支持同一变量连续赋值
	 */
	public FiledInfor clone() throws CloneNotSupportedException {
		FiledInfor cloned = (FiledInfor) super.clone();
		return cloned;
	}
}

class W_writeDBF {
	private String dbfFileName;                 //所要创建的dbf文件名
	FileOutputStream fos;                       //文件写操作需要的流
	private Vector<FiledInfor> vecFiledInfor;   //文件头所需
	private Vector<Object> vecLine;             //文件每行内容所需
	private DBFWriter writer;                   //dbf写操作对象
	
	/**
	 * 构造函数，设定生成的文件名
	 * @param dbfFileName dbf文件名
	 */
	public W_writeDBF(String dbfFileName) {
		// TODO Auto-generated constructor stub
		this.dbfFileName = dbfFileName;
		try {
			fos = new FileOutputStream(dbfFileName);
			writer = new DBFWriter();
			vecFiledInfor = new Vector<FiledInfor>();
			vecLine = new Vector<Object>();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 加入字段属性信息操作
	 * @param inout 字段信息
	 */
	void add(FiledInfor input) {
		// TODO Auto-generated method stub
		try {
			vecFiledInfor.add(input.clone());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成dbf表头信息
	 */
	void writeDBFTitle() {
		// TODO Auto-generated method stub
		if (vecFiledInfor.isEmpty()) {
			System.out.println("没有输入表头信息，系统退出，请检查！");
			System.exit(-1);
		} else {
			try {
				DBFField fields[] = new DBFField[vecFiledInfor.size()];
				for (int i = 0; i < fields.length; i++) {
					//对java.util.date数据类型的特殊照顾
					if (vecFiledInfor.elementAt(i).filedDataType == DBFField.FIELD_TYPE_D) {
						fields[i] = new DBFField();
						fields[i].setName(vecFiledInfor.elementAt(i).filedName);
						fields[i].setDataType(vecFiledInfor.elementAt(i).filedDataType);
						continue;
					}
					
					fields[i] = new DBFField();
					fields[i].setName(vecFiledInfor.elementAt(i).filedName);
					fields[i].setDataType(vecFiledInfor.elementAt(i).filedDataType);
					fields[i].setFieldLength(vecFiledInfor.elementAt(i).fieldLength);
					fields[i].setDecimalCount(vecFiledInfor.elementAt(i).decimalCount);
				}
				writer.setFields(fields);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 文件加入Boolean类型内容
	 * @param input
	 */
	void addBooleanLine(String input) {
		// TODO Auto-generated method stub
		if (input == "true") {
			vecLine.add(true);
		}else{
			vecLine.add(false);
		}
	}
	
	/**
	 * 文件加入Date类型内容
	 * @param input
	 */
	void addDateLine(String input) {
		// TODO Auto-generated method stub
		Date date = new Date(81,12,23);
		if (input.contains("-")) {
			String[] dateSplit = input.split("-");
			if (dateSplit.length==3) {
				date = new Date(new Integer(dateSplit[0]),
						new Integer(dateSplit[1]),new Integer(dateSplit[2]));
			}
		}else{
			date = new Date(input);
		}
		vecLine.add(date);
	}
	
	/**
	 * 文件加入double类型内容
	 * @param input
	 */
	void addDoubleLine(String input) {
		// TODO Auto-generated method stub
		Double douTemp = new Double(input);
		vecLine.add(douTemp);
	}

	/**
	 * 文件加入String类型内容
	 * @param input
	 */
	void addStringLine(String input) {
		// TODO Auto-generated method stub
		byte[] bs = input.getBytes();
		try {//避免输入乱码，详细参照W_readDBF.java
			input =  new String(bs,"ISO-8859-1");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		vecLine.add(input);
	}
	
	/**
	 * 将dbf文件内容按行写入
	 */
	void writeLine() {
		// TODO Auto-generated method stub
		if (vecLine.size()!= vecFiledInfor.size()) {
			System.out.println("写入行操作中内容个数和表头不符，系统退出，请检查！");
		    System.exit(-1);
		}else{
			Object rowData[] = new Object[vecLine.size()];
			for (int i = 0; i < rowData.length; i++) {
				rowData[i] = vecLine.elementAt(i);
			}
			try {
				writer.addRecord(rowData);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			vecLine.clear();
		}
	}
	
	/**
	 * 写入流操作，关闭相应文件
	 */
	void close() {
		// TODO Auto-generated method stub
		try {
			writer.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
