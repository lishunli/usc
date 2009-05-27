package Test;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.Oracle.impl.HibernateSessionFactory;
import org.Oracle.impl.Test;
import org.Oracle.impl.TestDAO;
import org.Oracle.impl.TestId;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class test
{

	public static void main(String[] args)
	{
		Session session = HibernateSessionFactory.getSession();
		
		Test test =new Test();
		TestId id =new TestId();
		id.setEmpno(new java.lang.Long (8001));
		id.setEname("李顺利");
//		id.setJob("董事长");
		
		SimpleDateFormat bartDateFormat =new SimpleDateFormat("MM-dd-yyyy");
		String dateStringToParse = "9-29-2001";
		Date date = null;
		try
		{
			date = bartDateFormat.parse(dateStringToParse);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}



		
		id.setHiredate(date);
//		id.setSal(6000.00);
//		id.setComm(800.00);
		id.setDeptno(new java.lang.Long (40));
		
		test.setId(id);
		
		TestDAO dao =new TestDAO();
		
		dao.save(test);
		
//		session.clear();
//		dao.delete(test);
//		dao.deleteById(8080);
		
		List<Test> lists = dao.findAll();
		for(Test list : lists)
		{
			System.out.println(""+list.getId().getEmpno()+"\t"+list.getId().getEname());
		}
//		
		
		session.close();
		
		
	}

}
