package Test;

import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;

import com.DAO.PersonDAO;
import com.pojo.Person;
public class Test {
		public static void main(String[] args) throws Exception {
			//��ȡejb�ķ���
			
//			Properties props = new Properties();
//			props.setProperty("java.naming.factory.initial",	"org.jnp.interfaces.NamingContextFactory");
//			props.setProperty("java.naming.provider.url", "localhost:1099");
//			props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
			
			/*Hashtable prop=new Hashtable();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			prop.put(Context.PROVIDER_URL, "jnp:/localhost");*/
			
			
			try {
				
				InitialContext ctx=new InitialContext();
				
				PersonDAO oneToonedao = (PersonDAO) ctx.lookup("PersonDAOBean/remote");
				/*
				 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				 * SimpleDateFormat formatter1 = new SimpleDateFormat("MMddhhmmss");
				 */
				Date IDDate= new Date();
//				String endno = date.toLocaleString().replace("-", "").replace(":", "").replace(" ", "");
//				String endno = date.getTime().;
				java.sql.Date date = new java.sql.Date(IDDate.getTime());
				String endno = date.toString().replace("-", "");
				endno=endno+IDDate.getHours()+IDDate.getMinutes()+IDDate.getSeconds();
				
				oneToonedao.insertPerson("jsjmz", true, (short) 26, new Date().toGMTString(), endno);
			Person person = oneToonedao.getPersonByID(new Integer(1));
				if (person != null) {
					System.out.println("Ѱ�ұ��Ϊ1����Ա");
					System.out.println("����:" + person.getName() + " ���֤��"
							+ person.getIdcard().getCardno());
				} else {
					System.out.println("û���ҵ����Ϊ1����Ա");
				}
				System.out.println("���±��Ϊ1����Ա������Ϊ����,���֤��Ϊ33012" + endno);
				oneToonedao.updatePersonInfo(new Integer(1), "����", "33012" + endno);
				System.out.println("================ɾ�����Ϊ1����Ա==============<br>");
				oneToonedao.deletePerson(new Integer(1));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		

		}

		}
