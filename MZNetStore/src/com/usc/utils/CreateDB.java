package com.usc.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * 用于由Hibernate，OR映射文件，生成表
 * @author Administrator
 *
 */
public class CreateDB {
	/**
	 * 根据Hibernate配置文件、映射文件。在相应数据库中生成表。
	 */
	public void createTable() {
		try {
			System.out.println("初始化数据开始......");
			// 读取hibernate.cfg.xml文件。
			// 不调用.configure()时，默认读取hibernate.properties配置文件
			Configuration cfg = new Configuration().configure();

			// 环境变量中，还设置了 oracle_sid = test，才能成功。

			// 一工具类， 生成hibernate.cfg.xml中定义的表。
			SchemaExport export = new SchemaExport(cfg);
			export.create(true, true); // 如果第二个参数为true的话，会把原来的表删除重建。

			System.out.println("初始化数据库表完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CreateDB db = new CreateDB();
		db.createTable();

	}

}
