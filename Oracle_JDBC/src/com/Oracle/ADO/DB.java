package com.Oracle.ADO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	private Connection con;
//	private PreparedStatement pstm;
	private String user="scott";
	private String password="lishunli";
	private String className="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@192.168.1.102:1521:ORCL";	
	
	public DB(){
		try{
			Class.forName(className);
		}catch(ClassNotFoundException e){
			System.out.println("�������ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	/**�������ݿ�����*/
	public Connection getCon(){
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			con=null;
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
}