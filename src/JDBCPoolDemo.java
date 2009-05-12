
/* �����Ҫ�İ� */
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class JDBCPoolDemo
{
   public static void main(String args[])
   {
      String tablename="student";             //���ݿ��б���
      String sqlstr;                          //sql���
      Connection con=null;                    //���Ӷ���
      Statement stmt=null;                    //������
      ResultSet rs=null;                      //���������
      Context ctx=null;
      Hashtable ht=new Hashtable();
      try
      {
         /*1���������ݿ����� */
         ht.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
	     ht.put(Context.PROVIDER_URL,"localhost:1099");
         ht.put(Context.URL_PKG_PREFIXES,"org.jboss.naming");
	     // ����һ����ʼ�����Ļ���
	     ctx=new InitialContext(ht);  
	     
	     DataSource ds=(DataSource)ctx.lookup("MysqlDS");
         //����DataSource����getConnection()��������ȡ���ݿ��������Ϣ��
	     con=ds.getConnection(); 

	     /*2�������ݿ��ύ��ѯ���� */
         stmt=con.createStatement();                // ����statement����
         sqlstr="select * from "+tablename;          // ��дSQL���
		 rs=stmt.executeQuery(sqlstr);              // ִ��SQL��䣬���ز�ѯ���
         
	     /*3����ȡ��ѯ���        */
         while(rs.next())
         {
               System.out.print(rs.getString("id"));
               System.out.print("\t");
               System.out.print(rs.getString("name"));
               System.out.print("\t");
//               System.out.print(rs.getInt("age"));
//               System.out.print("\t");
//               System.out.print("\n");
         }
       }
        /*4���쳣����        */
      catch(NamingException e1)
      {
         System.out.println(e1.toString());
		  System.out.println("��������û���ҵ���");
      }
      catch(SQLException e2)
      {
         System.out.println(e2.toString());
		 System.out.println("���ݿ��쳣��");
      }
	 /*5���ر����ݿ�       */
      finally
      {
         try
         {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(con!=null) con.close();
          }
          catch(Exception e)
          {
		     System.out.println(e.toString());
			 }
      }
   }
}

