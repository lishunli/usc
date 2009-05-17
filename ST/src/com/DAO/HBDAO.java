package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Hb;

/*
 2008-1-12下午01:48:07
 作者：老猫zk
 版权所有，仅供参考
 */
public class HBDAO {
	private Session session;// 数据库的连接对象

	private Connection conn;

	public HBDAO() {
		Configuration cfg = new Configuration().configure();// 创建配置对象
		SessionFactory sf = cfg.buildSessionFactory();// 建立连接工厂
		// 使用Hibernate.cfg.xml文件建立数据库的连接
		session = sf.openSession();// 打开数据库的会话------Connection
		conn = session.connection();
	}

	// Hql语言的操作

	public void closeSession() {// 释放资源
		if (session != null) {
			session.close();
			session = null;
		}
	}

	// 增加操作
	public void AddHB(Hb user) {
		Transaction tx = session.beginTransaction();// 开始一个事务
		session.saveOrUpdate(user);
		tx.commit();// 提交
	}

	// 删除操作
	public void DelHB(Hb user) {
		Transaction tx = session.beginTransaction();// 开始一个事务
		session.delete(user);
		tx.commit();// 提交
	}

	// 修改操作
	public void UpdateHB(Hb user) {
		Transaction tx = session.beginTransaction();// 开始一个事务
		session.update(user);
		tx.commit();// 提交
	}

	// 查询全部的内容
	public List<Hb> getAll() {
		Query query = session.createQuery("from Hb"); // 类名
		// 分页操作
		query.setFirstResult(0);//(当前页-1)*每页显示的个数
		query.setMaxResults(3);//每页显示的个数
		List<Hb> list = query.list();

		return list;
	}

	// 查询特定的内容
	public Hb getOneById(int id) {
		Query query = session.createQuery("from Hb  p where  p.uid=?"); // 类名.属性=?
		query.setInteger(0, id);
		Hb user = (Hb) query.uniqueResult();
		return user;
	}

	// 模糊查询
	public List<Hb> getOneByName(String name) {
		Query query = session.createQuery("from Hb  p where  p.uname like ?"); // 类名.属性=?
		query.setString(0, "%" + name + "%");
		List<Hb> list = query.list();
		return list;
	}

	// SQL语言的操作
	public void AddHBBySql(Hb user) {
		try {
			PreparedStatement ps = conn.prepareStatement("");
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}

}
