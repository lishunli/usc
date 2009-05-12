import java.util.Properties;

import javax.naming.InitialContext;

import com.DAO.ProcCall;

public class Test {

	// ��ȡejb�ķ���
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
		//��������
		//procDAO.QueryNoneReturnValueStoreProcedure();
		/*
		 *����ĳ����¼������
		 * String msg=procDAO.QuerySingleObjectStoreProcedure(1);
		System.out.println(msg);*/
		//�鿴ȫ������Ϣ
		/*String msg=procDAO.QueryStoreProcedure();
		System.out.println(msg);*/
		//��ѯ��¼�Ĳ�������
		String msg=procDAO.QueryPartColumnStoreProcedure();
		System.out.println(msg);
	}
}
