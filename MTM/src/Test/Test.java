package Test;

import java.util.Iterator;
import javax.naming.InitialContext;
import com.DAO.TeacherDAO;
import com.pojo.Student;
import com.pojo.Teacher;

public class Test
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{

		try
		{
			InitialContext ctx = new InitialContext();
			TeacherDAO teacherdao = (TeacherDAO) ctx.lookup("TeacherDAOBean/remote");
			// 获取操作方法
			teacherdao.insertTeacher("李老师", new String[] { "张小红", "朱小光", "龚利"});
			//如果使用JRE1.6的话会抛出异常，使用低一点版本就好（高于1.5）
			Teacher teacher = teacherdao.getTeacherByID(new Integer(1));
			
			if (teacher != null)
			{
				System.out.println("======= 获取编号为1的老师姓名："
						+ teacher.getTeacherName());
				// 使用迭代器输出学上的信息,将以使用泛型
				Iterator<Student> iterator = teacher.getStudents().iterator();
				while (iterator.hasNext())
				{
					Student student = (Student) iterator.next();
					System.out.println("他的学生:" + student.getStudentName());
				}
			} else
			{
				System.out.println("没有找到编号为1的老师");
			}
			 Student student = teacherdao.getStudentByID(new Integer(1));
			 if (student != null) {
			 System.out.println("======= 获取编号为1的学生姓名："
			 + student.getStudentName() + "======");
			 Iterator iterator = student.getTeachers().iterator();
			 while (iterator.hasNext()) {
			 Teacher tc = (Teacher) iterator.next();
			 System.out.println("他的老师:" + tc.getTeacherName() );
			 }
			 } else {
			 System.out.println("没有找到编号为1的学生");
			 }
		} catch (Exception e)
		{
			// System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

}
