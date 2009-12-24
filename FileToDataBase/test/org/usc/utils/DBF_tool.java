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

	private String fileOpenPath,   // ���ļ�����·���洢
	               fileCreatePath; //�����ļ�����·���洢
	private W_readDBF rdbf;  //���ļ���������
	private W_writeDBF wdbf; //д�ļ���������
	private Vector<Byte> filedSave;//��ͷ���Դ洢���ڲ�������ʱͨ���˱������ж���������
	
	/**
	 * ���캯������ʼ��һЩ����
	 */
	public DBF_tool() {
		// TODO Auto-generated constructor stub
		filedSave = new Vector<Byte>();
	}
	
	/**
	 * ��dbf�ļ�����
	 * @param filePath
	 */
	void openFile(String filePath) {
		// TODO Auto-generated method stub
		this.fileOpenPath = filePath;
		if (filePath=="") {
			System.out.println("���ļ�����û��ָ��·����ϵͳ�˳�");
			System.exit(-1);
		}		
		rdbf = new W_readDBF(fileOpenPath);
	}
	
	/**
	 * �õ�dbf�ļ����Եĸ�����������
	 * @return int
	 */
	int DBFGetFieldCount() {
		// TODO Auto-generated method stub
		return rdbf.DBFGetFieldCount();
	}
	 
	/**
	 * �õ�dbf�ļ���������������
     * @return int
	 */
	int DBFGetRecordCount() {
	    // TODO Auto-generated method stub
	    return rdbf.DBFGetRecordCount();
	} 
	
	/**
	 * �õ���num�����Զε���ϸ��Ϣ
	 * @param num ���Զε�λ��
	 * @return FiledInfor
	 */
	FiledInfor getDBFFiledInfor(int num) {
		// TODO Auto-generated method stub
		return rdbf.getDBFFiledInfor(num);
	}

	/**
	 * �������Զε����Ƶõ����Զ����ڵ�λ��
	 * @param input ���Զ�����
	 * @return int
	 */
	int getDBFFiledNum(String input) {
		// TODO Auto-generated method stub
		return rdbf.getDBFFiledNum(input);
	}

	/**
	 * ��ȡdbf�ļ�����ϸλ�õ����ݣ��޶��к��У���0����
	 * @param line ��
	 * @param nFiled ��
	 * @return Object
	 */
	Object getContent(int line, int nFiled) {
		// TODO Auto-generated method stub
		return rdbf.getContent(line, nFiled);
	}
	
	/**
	 * �õ�dbf�ļ�ָ����һ�У���0����
	 * @param nFiled ��
	 * @return Object[]
	 */
	Object[] getContent(int nFiled) {
		// TODO Auto-generated method stub
		return rdbf.getContent(nFiled);
	}
	
	/**
	 * ����dbf����
	 * @param filePath
	 */
	public void createFile(String filePath) {
		// TODO Auto-generated method stub
		this.fileCreatePath = filePath;
		if (filePath=="") {
			System.out.println("�����ļ�����û��ָ��·����ϵͳ�˳�");
			System.exit(-1);
		}
		wdbf = new W_writeDBF(fileCreatePath);
	}
	
	/**
	 * ���ɱ�ͷ��Ϣ
	 * @param vecFiled
	 */
	void writeFiled(Vector<FiledInfor> vecFiled) {
		// TODO Auto-generated method stub
		if (!filedSave.isEmpty()) {
			System.out.println("�쳣:��ͷ�����Ѿ������һ�Σ����飬ϵͳ�˳���");
		    System.exit(-1);
		}
		
		for (int i = 0; i < vecFiled.size(); i++) {
			filedSave.add(vecFiled.elementAt(i).filedDataType);
			wdbf.add(vecFiled.elementAt(i));
		}
		wdbf.writeDBFTitle();
	}
	
	/**
	 * ��ÿ��dbf�������뵽�ļ���
	 * @param dbfLine
	 */
	void writeDBFLine(String dbfLine) {
		// TODO Auto-generated method stub
		Vector<String> vecTemp = vecSplit(dbfLine);
		
		if (vecTemp.size() < filedSave.size()) {
			System.out.println("����dbf����ʱ���ݷֶ��쳣��"+dbfLine);
			System.out.println("���飬ϵͳ�˳���");
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
				System.out.println("�޷�������filedSave(��ͷ��Ϣ����)["+i+"]="
						+filedSave.elementAt(i)+"\n���飬ϵͳ�˳���");
				System.exit(-1);
			}
		}
		
		wdbf.writeLine();
	}
	
	/**
	 * �½�һ����ͬ�ṹ�Ŀ�dbf��
	 * @param copyPath ����·��
	 * @param pastePath ճ��·��
	 */
	void copyDBFtitle(String copyPath ,String pastePath) {
		// TODO Auto-generated method stub
		openFile(copyPath);//��
		createFile(pastePath);//д
		Vector<FiledInfor> vecTitle = new Vector<FiledInfor>();//��ͷ�洢
		
		for (int i = 0; i < DBFGetFieldCount(); i++) {
			vecTitle.add(getDBFFiledInfor(i));
		}
		
		writeFiled(vecTitle);		
	}
	
	/**
	 * �رղ������˴���ֹ�׳��쳣
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
	 * ����˵���ĵ�
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/************************************************/
		/* ��ʼ��dbf��������                                   */
		/************************************************/
		DBF_tool dbf = new DBF_tool();
		/************************************************/
		/* ����dbf����������"creatDBF.dbf"���˴��������·��  */
		/* Ҳ�����þ���·�����д���                             */
		/************************************************/
		System.out.println("���ڴ���dbf�ļ���student.dbf ...");
		dbf.createFile("student.dbf");
		//dbf.createFile("D:\\student.dbf");//����·��
		/************************************************/
		/* ����dbf��ͷ��Ϣ���˴�ֻ��һ�����������б�ͷ��Ϣ       */
		/* ��ͷ��Ϣ��FiledInfor�����ɣ�Ȼ�����vector��       */
		/* �˴�Ϊ����ţ����������䣬salary��нˮ������������   */
		/************************************************/
		System.out.println("����dbf�ļ���ͷ��Ϣ ...");
		FiledInfor filedinfor;//��ͷ��Ϣ����
		Vector<FiledInfor> vecTitle = new Vector<FiledInfor>();
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_C;//����
		filedinfor.filedName = "no";                  //����
		filedinfor.fieldLength = 11;                      //����
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
		filedinfor.decimalCount = 0;                    //����
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_F;
		filedinfor.filedName = "score";//��֧��"salary(**)"���ַ�ʽ����֧����Ӣ�Ľ��
		filedinfor.fieldLength = 7;
		filedinfor.decimalCount = 2;
		vecTitle.add(filedinfor);
		
		filedinfor = new FiledInfor();
		filedinfor.filedDataType = DBF_tool.FIELD_TYPE_D;
		filedinfor.filedName = "eduTime";
		vecTitle.add(filedinfor);
		dbf.writeFiled(vecTitle);
		/************************************************/
		/* ����dbf��������Ϣ                                   */
		/************************************************/
		System.out.println("��dbf�ļ���������� ...");
		String dbfLine;//dbfÿ�е����ݣ�filed֮����","�ָ�
		dbfLine = "20064440151,��˳��,��,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,��˳��,��,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,��˳��,��,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,��˳��,��,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
		dbfLine = "20064440150,��˳��,��,20,95.5,88-12-9";
		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000002,����,30,10000.00,82-3-17";
//		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000003,С��1,25,4000.12,87-5-20";
//		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000004,С��2,28,4200,07-2-15";
//		dbf.writeDBFLine(dbfLine);
//		dbfLine = "000005,С��3,29,3800.00,02-4-23";
//		dbf.writeDBFLine(dbfLine);
		/************************************************/
		/* �رմ���dbf���������Ϊ�������                      */
		/************************************************/
		System.out.println("���������������");
		dbf.close();
		/************************************************/
		/* ��dbf����,����·�������·���Կ�                   */
		/************************************************/
		dbf = new DBF_tool();
		System.out.println("���ڴ�dbf�ļ���student.dbf ...");
		dbf.openFile("student.dbf");
		System.out.println("����...");
		/************************************************/
		/* �õ�dbf�����и���                                   */
		/************************************************/
		System.out.println("��dbf�ļ��������У�"+dbf.DBFGetRecordCount()+
				         "�У�"+dbf.DBFGetFieldCount()+"�У�");
		/*******************************************************/
		/* �õ�dbf�����ֶε���ϸ��Ϣ(Ŀǰ���Եõ������ơ����͡����ȡ����� */
		/*******************************************************/
		System.out.println("�����ֶε���ϸ��ϢΪ��");
		for (int i = 0; i < dbf.DBFGetFieldCount(); i++) {
			filedinfor = dbf.getDBFFiledInfor(i);
			System.out.println("name:"+filedinfor.filedName+"  length:"+filedinfor.fieldLength);
		}
		/************************************************/
		/* �õ�ָ��������dbf�е�λ��                           */
		/************************************************/
		System.out.println("���У�������dbf���е�λ���ǣ�"+dbf.getDBFFiledNum("�� ��"));
		/************************************************/
		/* �õ�dbf��ָ��������������ֵ,������0��                */
		/************************************************/
		System.out.println("��3�У���2�е�ֵ�ǣ�"+dbf.getContent(2, 1));
		dbf.close();
		/************************************************/
		/* ����dbf�ļ���ͷ���ֹ���                             */
		/************************************************/
		dbf = new DBF_tool();
		System.out.println("��student.dbf���ļ��ṹ���Ƶ��µ��ļ�copy.dbf��...");
		dbf.copyDBFtitle("student.dbf", "copy.dbf");
		dbf.close();
		System.out.println("��ʾ������");
	}
}

class W_readDBF {
	
	private InputStream inputStream;//������֧��
	private DBFReader reader;       //��ȡdbf�ļ�����
	private int numberOfFields,     //�������͸�����������
	            numberofRecord;     //���ݵ�������������
	private String dbfFileName;     //����ȡ��dbf�ļ���
	
	/**
	 * ���캯��,��ȡdbf����ͬʱ�õ���ض�����Ϣ
	 * @param dbfFileName ��Ҫ��ȡ��dbf�ļ���������
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
	 * �õ�dbf�ļ����Եĸ�����������
	 * @return int
	 */
	 int DBFGetFieldCount() {
		// TODO Auto-generated method stub
		return numberOfFields;
	}
	
	/**
	 * �õ�dbf�ļ���������������
	 * @return int
	 */
	int DBFGetRecordCount() {
		// TODO Auto-generated method stub
		return numberofRecord;
	}
	
	/**
	 * �õ���num�����Զε���ϸ��Ϣ
	 * @param num ���Զε�λ��
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
	 * �������Զε����Ƶõ����Զ����ڵ�λ��
	 * @param input ���Զ�����
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
	 * ��ȡdbf�ļ�����ϸλ�õ����ݣ��޶��к��У���0����
	 * @param line ��
	 * @param nFiled ��
	 * @return Object
	 */
	Object getContent(int line, int nFiled) {
		// TODO Auto-generated method stub
		Object[] output = new Object[numberOfFields];//���
		
		try {
			//���ļ�������ˢ�²������൱��ָ���λ
			inputStream = new FileInputStream(dbfFileName);
			reader = new DBFReader(inputStream);
			
			for (int i = 0; i <= line; i++) {
				//�õ���i�е�����
				output = reader.nextRecord();
			}		

			//��string���ͽ������±����,��������������
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
	 * �õ�dbf�ļ�ָ����һ�У���0����
	 * @param nFiled ��
	 * @return Object[]
	 */
	Object[] getContent(int nFiled) {
		Object[] output = new Object[numberofRecord];//���
		
		try {
			//���ļ�������ˢ�²������൱��ָ���λ
			inputStream = new FileInputStream(dbfFileName);
			reader = new DBFReader(inputStream);
			
			for (int i = 0; i < numberofRecord; i++) {
				//�õ���i�е�����
				Object[] objTemp = reader.nextRecord();
				
				//��string���ͽ������±����,��������������
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
	 * ȥ���ַ������ʱ�Ķ���Ŀո�
	 * @param input ����
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
	 * �ر�������
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
 * ����dbf���Զ���Ϣ�Ĵ洢
 * @author wangchen
 */
class FiledInfor implements Cloneable{
	String filedName; //��������
	int decimalCount, //��ȷ�ȣ���ȷ��С������λ������������
			fieldLength; //���Գ���
	byte filedDataType;//��������

	/**
	 * ����clone���ܣ�֧��ͬһ����������ֵ
	 */
	public FiledInfor clone() throws CloneNotSupportedException {
		FiledInfor cloned = (FiledInfor) super.clone();
		return cloned;
	}
}

class W_writeDBF {
	private String dbfFileName;                 //��Ҫ������dbf�ļ���
	FileOutputStream fos;                       //�ļ�д������Ҫ����
	private Vector<FiledInfor> vecFiledInfor;   //�ļ�ͷ����
	private Vector<Object> vecLine;             //�ļ�ÿ����������
	private DBFWriter writer;                   //dbfд��������
	
	/**
	 * ���캯�����趨���ɵ��ļ���
	 * @param dbfFileName dbf�ļ���
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
	 * �����ֶ�������Ϣ����
	 * @param inout �ֶ���Ϣ
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
	 * ����dbf��ͷ��Ϣ
	 */
	void writeDBFTitle() {
		// TODO Auto-generated method stub
		if (vecFiledInfor.isEmpty()) {
			System.out.println("û�������ͷ��Ϣ��ϵͳ�˳������飡");
			System.exit(-1);
		} else {
			try {
				DBFField fields[] = new DBFField[vecFiledInfor.size()];
				for (int i = 0; i < fields.length; i++) {
					//��java.util.date�������͵������չ�
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
	 * �ļ�����Boolean��������
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
	 * �ļ�����Date��������
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
	 * �ļ�����double��������
	 * @param input
	 */
	void addDoubleLine(String input) {
		// TODO Auto-generated method stub
		Double douTemp = new Double(input);
		vecLine.add(douTemp);
	}

	/**
	 * �ļ�����String��������
	 * @param input
	 */
	void addStringLine(String input) {
		// TODO Auto-generated method stub
		byte[] bs = input.getBytes();
		try {//�����������룬��ϸ����W_readDBF.java
			input =  new String(bs,"ISO-8859-1");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		vecLine.add(input);
	}
	
	/**
	 * ��dbf�ļ����ݰ���д��
	 */
	void writeLine() {
		// TODO Auto-generated method stub
		if (vecLine.size()!= vecFiledInfor.size()) {
			System.out.println("д���в��������ݸ����ͱ�ͷ������ϵͳ�˳������飡");
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
	 * д�����������ر���Ӧ�ļ�
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
