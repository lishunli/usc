package com.bjsxt.spring.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		BeanFactory f = new ClassPathXmlApplicationContext("com/bjsxt/spring/factory/applicationContext.xml");
		Object o = f.getBean("v");
		Moveable m = (Moveable)o;
		m.run();
		
////		读配置文件（.properties）方法一
//		Properties props = new Properties();
//		props.load(Test.class.getClassLoader().getResourceAsStream("com/bjsxt/spring/factory/spring.properties"));
//		String vehicletypename = props.getProperty("vehicletyp");
//		Moveable m =(Moveable)Class.forName(vehicletypename).newInstance();
//		m.run();
////		读配置文件（.properties）方法二——绝对路径
//		Properties props = new Properties();
//		props.load(new FileInputStream(System.getProperty("user.dir")+"/src/com/bjsxt/spring/factory/spring.properties"));
//		String vehicleTypeName = props.getProperty("vehicleTyp");
//		Moveable m =(Moveable)Class.forName(vehicleTypeName).newInstance();
//		m.run();
////		读配置文件（.properties）方法三——相对路径
//		Properties props = new Properties();
//		props.load(new FileInputStream("src/com/bjsxt/spring/factory/spring.properties"));
//		String vehicleTypeName = props.getProperty("vehicleTyp");
//		Moveable m =(Moveable)Class.forName(vehicleTypeName).newInstance();
//		m.run();
	}

}
