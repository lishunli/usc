package com.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.DAOtest.Student;
import com.DAOtest.StudentDAO;
import com.onetomany.Catelog;
import com.onetomany.Pp;
import com.util.HSF;

/*
 2008-1-15上午11:54:14
 作者：老猫zk
 版权所有，仅供参考
 */
public class Test {
	public static void main(String[] args) {
		Session session = HSF.getSession();
		/*
		 * Catelog cla=new Catelog(); cla.setCname("0725"); Pp p1=new Pp();
		 * p1.setPname("zhangsan"); Pp p2=new Pp(); p2.setPname("lisu");
		 * 
		 * cla.getPps().add(p1); cla.getPps().add(p2); p1.setCatelog(cla);
		 * p2.setCatelog(cla);
		 * 
		 * session.saveOrUpdate(cla); session.beginTransaction().commit();
		 */
		// 修改
		/*
		 * Pp p1=new Pp(); p1.setPname("jf"); p1.setPid(1); Catelog cla=new
		 * Catelog(); cla.setCname("0725"); cla.setCid(1); p1.setCatelog(cla);
		 * 
		 * session.update(p1); Catelog cla=new Catelog(); cla.setCname("1109");
		 * cla.setCid(1); session.saveOrUpdate(cla);
		 * session.beginTransaction().commit(); session.close();
		 */
		// 查询操作
		// 主表的操作
		/*
		 * String hql="from Catelog p where p.cid=2"; Query
		 * q=session.createQuery(hql); //List<Catelog> list=q.list(); Catelog
		 * cla=(Catelog)q.uniqueResult();
		 * if(!Hibernate.isInitialized(cla.getPps())){
		 * Hibernate.initialize(cla.getPps()); } session.close();
		 * System.out.println(cla.getCname()); Set<Pp> set=cla.getPps();
		 * Iterator<Pp> it = set.iterator(); while(it.hasNext()){ Pp
		 * p=it.next(); System.out.println(p.getPname()+" "+p.getPid()+"
		 * "+p.getCatelog().getCname()); }
		 */
		// 从表的查询
		/*
		 
		Catelog cla = new Catelog();
		cla.setCname("08-7");
		
		Pp p1 = new Pp();
		p1.setPname("zhaoliu");
		Pp p2 = new Pp();
		p2.setPname("fenqi");
		
		p1.setCatelog(cla);
		p2.setCatelog(cla);
		
		
		session.saveOrUpdate(cla);
		session.saveOrUpdate(p1);
		session.saveOrUpdate(p2);
		session.beginTransaction().commit();*/
		Student s=new Student();
		s.setStudentid(4);
		s.setStudentName("zk");
		StudentDAO sdao=new StudentDAO();
	/*	session.clear();
		session.flush();*/
		sdao.save(s);
		
		

	}

}
