package com.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import com.DAOTest.Student;
import com.DAOTest.StudentDAO;
import com.pojo.Classes;
import com.pojo.HSF;
import com.pojo.Stu;

public class Test
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
//		Session session = HSF.getSession();
//		 ����༶����ͬʱ����༶�ڵ�ѧ������������
		// Classes cla =new Classes();
		// cla.setCname("200644401");
		// Stu st1 =new Stu();
		// st1.setSname("ľ��");
		// Stu st2 =new Stu();
		// st2.setSname("��˳��");
		// cla.getStus().add(st1);
		// cla.getStus().add(st2);
		// st1.setClasses(cla);
		// st2.setClasses(cla);
		// session.saveOrUpdate(cla);
		// session.beginTransaction().commit();//�����ύ
		// session.close();

//		// �޸�ѧ��
//		Stu st = new Stu();
//		st.setSname("˳��");
//		st.setSid(1);
//		Classes cla = new Classes();
//		cla.setCname("200644401");
//		cla.setCid(1);
//		st.setClasses(cla);
//		session.update(st);
//		session.beginTransaction().commit();// �����ύ
//		session.close();
		
	
//		//�޸İ༶	
//		Classes cla = new Classes();
//		cla.setCname("�����061��");
//		cla.setCid(1);
//		
//		session.update(cla);
//		session.beginTransaction().commit();// �����ύ
//		session.close();

//		// ��ѯ����
//		// ����Ĳ������԰༶�Ĳ�ѯ
//		String hql="from Classes c where c.cid=7";
//		Query q =session.createQuery(hql);
////		List<Classes> list =q.list();
//		Classes cla=(Classes)q.uniqueResult();
//		if(!Hibernate.isInitialized(cla.getStus()))
//		{
//			Hibernate.initialize(cla.getStus());
//		}
//		session.close();//�������ܹ����޸�lazy�ӳ�
//		
//		System.out.println(cla.getCname());
//		Set<Stu> set=cla.getStus();
//		Iterator<Stu> it=set.iterator();
//		System.out.println(cla.getCname()+"�༶����");
//		while(it.hasNext())
//		{
//			Stu s=it.next();
//			System.out.println(s.getSid()+"\t"+s.getSname());
//		}
////		session.close();
		
////		 �ӱ�Ĳ�ѯ
//		
//		String hql="from Stu s where s.classes.cid=7";
//		Query q =session.createQuery(hql);
//		List<Stu> list =q.list();
//		for (Iterator<Stu> iterator = list.iterator(); iterator.hasNext();)
//		{
//			Stu stu = (Stu) iterator.next();
//			System.out.println("\t"+stu.getSname()+"\t"+stu.getClasses().getCid()+"\t"+stu.getClasses().getCname());
//			
//		}
//		session.close();

//		//ѧ�������ʦ��û�й�����ʵ�ֵ������
//		Classes cla =new Classes();
//		cla.setCname("200644402");
//		Stu st1 = new Stu();
//		st1.setSname("ľ��2");
//		Stu st2 = new Stu();
//		st2.setSname("��˳��2");
//		st1.setClasses(cla);
//		st2.setClasses(cla);
//		
//		
//		session.saveOrUpdate(cla);
//		session.saveOrUpdate(st1);
//		session.saveOrUpdate(st2);
//		session.beginTransaction().commit();
//		session.close();
		
//		Ĭ�������ɵ�DAO�����������ݿ⣬�ܿ�ݣ�����Ҫע���޸�һ����DAO�ࡣ����һЩ�ύ������ر�
		Student stu =new Student();
		stu.setStudentName("��˳��");
		StudentDAO sdao =new StudentDAO();
		
//		session.clear();
//		//
//		//������� clear �������������������flush
//		//
//		session.flush();
		
		sdao.save(stu);
		
		


		
		
		
		
		
	}

}
