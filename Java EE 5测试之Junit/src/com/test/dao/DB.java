package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {
	private Connection con;
//	private PreparedStatement pstm;
	private String user="jsjmz";
	private String password="lishunli";
	private String className="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url="jdbc:sqlserver://localhost:1433;DatabaseName=db_JUnitTest";	
	
	public DB(){
		try{
			Class.forName(className);
		}catch(ClassNotFoundException e){
			System.out.println("加载数据库驱动失败！");
			e.printStackTrace();
		}
	}

	/**创建数据库连接*/
	public Connection getCon(){
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("创建数据库连接失败！");
			con=null;
			e.printStackTrace();
		}
		return con;
	}
}