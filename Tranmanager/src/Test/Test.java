package Test;

import java.util.Properties;

import javax.naming.InitialContext;

import com.manager.TmanagerDAO;

public class Test
{
	public static void main(String[] args) throws Exception//把异常抛到最外层，好让容器收到
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
//			transactiondao.insertTP("电脑", new Float("1200"), true);
			transactiondao.insertTP("电脑", new Float("1200"), false);
			transactiondao.ModifyTP("数码相机", false);
//			transactiondao.ModifyTP("数机", true);
			System.out.println("执行完成");
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
