package Test;

import java.util.Date;
import java.util.Properties;

import javax.naming.InitialContext;

import com.DAO.PersonDAO;
import com.pojo.Person;
public class Test {
		public static void main(String[] args) throws Exception {
			//获取ejb的服务
			
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
					System.out.println("寻找编号为1的人员");
					System.out.println("姓名:" + person.getName() + " 身份证："
							+ person.getIdcard().getCardno());
				} else {
					System.out.println("没有找到编号为1的人员");
				}
				System.out.println("更新编号为1的人员的姓名为李明,身份证号为33012" + endno);
				oneToonedao.updatePersonInfo(new Integer(1), "李明", "33012" + endno);
				System.out.println("================删除编号为1的人员==============<br>");
				oneToonedao.deletePerson(new Integer(1));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		

		}

		}
