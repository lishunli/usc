package Test;

import java.util.Properties;

import javax.naming.InitialContext;

import com.manager.TmanagerDAO;

public class Test
{
	public static void main(String[] args) throws Exception//���쳣�׵�����㣬���������յ�
	{
		//
		// Properties props = new Properties();
		// props.setProperty("java.naming.factory.initial",
		// "org.jnp.interfaces.NamingContextFactory");
		// props.setProperty("java.naming.provider.url", "localhost:1099");
		// props.setProperty("java.naming.factory.url.pkgs",
		// "org.jboss.naming");

		try
		{
			InitialContext ctx = new InitialContext();
			TmanagerDAO transactiondao = (TmanagerDAO) ctx.lookup("TmanagerDAOBean/remote");
//			transactiondao.insertTP("����", new Float("1200"), true);
			transactiondao.insertTP("����", new Float("1200"), false);
			transactiondao.ModifyTP("�������", false);
//			transactiondao.ModifyTP("����", true);
			System.out.println("ִ�����");
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
