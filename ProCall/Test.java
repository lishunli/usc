import java.util.Properties;

import javax.naming.InitialContext;

import com.DAO.ProcCall;

public class Test {

	// 获取ejb的服务
	public static void main(String[] args) throws Exception{

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");

		/*
		 * Hashtable prop=new Hashtable();
		 * prop.put(Context.INITIAL_CONTEXT_FACTORY,
		 * "org.jnp.interfaces.NamingContextFactory");
		 * prop.put(Context.PROVIDER_URL, "jnp:/localhost");
		 */

		InitialContext ctx = new InitialContext(props);
		ProcCall procDAO=(ProcCall) ctx.lookup("ProcCallBean/remote");
		//插入数据
		//procDAO.QueryNoneReturnValueStoreProcedure();
		/*
		 *查找某条记录的属性
		 * String msg=procDAO.QuerySingleObjectStoreProcedure(1);
		System.out.println(msg);*/
		//查看全部的信息
		/*String msg=procDAO.QueryStoreProcedure();
		System.out.println(msg);*/
		//查询记录的部分属性
		String msg=procDAO.QueryPartColumnStoreProcedure();
		System.out.println(msg);
	}
}
