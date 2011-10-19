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
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.pojo.Hb;

public class HBDAO {
	private Session session;// ���ݿ�����Ӷ���

	private Connection conn;

	@SuppressWarnings("deprecation")
	public HBDAO() {
//		AnnotationConfiguration cfg=new AnnotationConfiguration().configure();
//		Configuration cfg = new Configuration().configure();// �������ö���,��ȡhibernate.cfg.xml�ļ�������
//		SessionFactory sf = cfg.buildSessionFactory();// �������ӹ���
		// ʹ��Hibernate.cfg.xml�ļ��������ݿ������
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		
		session = sf.openSession();// �����ݿ�ĻỰ------Connection
//		conn = session.connection();
	}

	// Hql���ԵĲ���

	public void closeSession() {// �ͷ���Դ
		if (session != null) {
			session.close();
			session = null;
		}
	}

	// ���Ӳ���
	public void AddHB(Hb user) {
		Transaction tx = session.beginTransaction();// ��ʼһ������
		session.saveOrUpdate(user);
//		session.update(user);
//		session.save(user);
		System.out.println("3."+user.getUname());
		tx.commit();// �����ύ
	}

	// ɾ������
	public void DelHB(Hb user) {
		Transaction tx = session.beginTransaction();// ��ʼһ������
		session.delete(user);
		tx.commit();// �ύ
	}

	// �޸Ĳ���
	public void UpdateHB(Hb user) {
		Transaction tx = session.beginTransaction();// ��ʼһ������
		session.update(user);
		tx.commit();// �ύ
	}

	// ��ѯȫ��������
	public List<Hb> getAll() {
		Query query = session.createQuery("from Hb"); // ����
		// ��ҳ����
		query.setFirstResult(0);//(��ǰҳ-1)*ÿҳ��ʾ�ĸ���
		query.setMaxResults(3);//ÿҳ��ʾ�ĸ���
		List<Hb> list = query.list();

		return list;
	}

	// ��ѯ�ض�������
	public Hb getOneById(int id) {
		Query query = session.createQuery("from Hb  p where  p.uid=?"); // ����.����=?
		query.setInteger(0, id);
		Hb user = (Hb) query.uniqueResult();
		return user;
	}

	// ģ����ѯ
	public List<Hb> getOneByName(String name) {
		Query query = session.createQuery("from Hb  p where  p.uname like ?"); // ����.����=?
		query.setString(0, "%" + name + "%");
		List<Hb> list = query.list();
		return list;
	}

	// SQL���ԵĲ���
	public void AddHBBySql(Hb user) {
		try {
			PreparedStatement ps = conn.prepareStatement("");
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
	}

}