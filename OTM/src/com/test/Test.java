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
//		 插入班级，并同时插入班级内的学生，级联操作
		// Classes cla =new Classes();
		// cla.setCname("200644401");
		// Stu st1 =new Stu();
		// st1.setSname("木子");
		// Stu st2 =new Stu();
		// st2.setSname("李顺利");
		// cla.getStus().add(st1);
		// cla.getStus().add(st2);
		// st1.setClasses(cla);
		// st2.setClasses(cla);
		// session.saveOrUpdate(cla);
		// session.beginTransaction().commit();//事务提交
		// session.close();

//		// 修改学生
//		Stu st = new Stu();
//		st.setSname("顺子");
//		st.setSid(1);
//		Classes cla = new Classes();
//		cla.setCname("200644401");
//		cla.setCid(1);
//		st.setClasses(cla);
//		session.update(st);
//		session.beginTransaction().commit();// 事务提交
//		session.close();
		
	
//		//修改班级	
//		Classes cla = new Classes();
//		cla.setCname("计算机061班");
//		cla.setCid(1);
//		
//		session.update(cla);
//		session.beginTransaction().commit();// 事务提交
//		session.close();

//		// 查询操作
//		// 主表的操作，对班级的查询
//		String hql="from Classes c where c.cid=7";
//		Query q =session.createQuery(hql);
////		List<Classes> list =q.list();
//		Classes cla=(Classes)q.uniqueResult();
//		if(!Hibernate.isInitialized(cla.getStus()))
//		{
//			Hibernate.initialize(cla.getStus());
//		}
//		session.close();//这样做能够不修改lazy延迟
//		
//		System.out.println(cla.getCname());
//		Set<Stu> set=cla.getStus();
//		Iterator<Stu> it=set.iterator();
//		System.out.println(cla.getCname()+"班级里有");
//		while(it.hasNext())
//		{
//			Stu s=it.next();
//			System.out.println(s.getSid()+"\t"+s.getSname());
//		}
////		session.close();
		
////		 从表的查询
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

//		//学生表和老师表没有关联，实现单表操作
//		Classes cla =new Classes();
//		cla.setCname("200644402");
//		Stu st1 = new Stu();
//		st1.setSname("木子2");
//		Stu st2 = new Stu();
//		st2.setSname("李顺利2");
//		st1.setClasses(cla);
//		st2.setClasses(cla);
//		
//		
//		session.saveOrUpdate(cla);
//		session.saveOrUpdate(st1);
//		session.saveOrUpdate(st2);
//		session.beginTransaction().commit();
//		session.close();
		
//		默认用生成的DAO类来操作数据库，很快捷，不过要注意修改一定的DAO类。加入一些提交和事物关闭
		Student stu =new Student();
		stu.setStudentName("李顺利");
		StudentDAO sdao =new StudentDAO();
		
//		session.clear();
//		//
//		//最好先做 clear ，再其他操作，最后做flush
//		//
//		session.flush();
		
		sdao.save(stu);
		
		


		
		
		
		
		
	}

}
