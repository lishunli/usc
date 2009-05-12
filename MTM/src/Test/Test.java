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
			// ��ȡ��������
			teacherdao.insertTeacher("����ʦ", new String[] { "��С��", "��С��", "����"});
			//���ʹ��JRE1.6�Ļ����׳��쳣��ʹ�õ�һ��汾�ͺã�����1.5��
			Teacher teacher = teacherdao.getTeacherByID(new Integer(1));
			
			if (teacher != null)
			{
				System.out.println("======= ��ȡ���Ϊ1����ʦ������"
						+ teacher.getTeacherName());
				// ʹ�õ��������ѧ�ϵ���Ϣ,����ʹ�÷���
				Iterator<Student> iterator = teacher.getStudents().iterator();
				while (iterator.hasNext())
				{
					Student student = (Student) iterator.next();
					System.out.println("����ѧ��:" + student.getStudentName());
				}
			} else
			{
				System.out.println("û���ҵ����Ϊ1����ʦ");
			}
			 Student student = teacherdao.getStudentByID(new Integer(1));
			 if (student != null) {
			 System.out.println("======= ��ȡ���Ϊ1��ѧ��������"
			 + student.getStudentName() + "======");
			 Iterator iterator = student.getTeachers().iterator();
			 while (iterator.hasNext()) {
			 Teacher tc = (Teacher) iterator.next();
			 System.out.println("������ʦ:" + tc.getTeacherName() );
			 }
			 } else {
			 System.out.println("û���ҵ����Ϊ1��ѧ��");
			 }
		} catch (Exception e)
		{
			// System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

}
