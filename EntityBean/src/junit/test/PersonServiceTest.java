package junit.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.naming.InitialContext;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.test.bean.Person;
import org.test.service.PersonService;


public class PersonServiceTest
{
	private static PersonService personService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		try
		{
			InitialContext ctx=new InitialContext();
			 personService =(PersonService) ctx.lookup("PersonServiceBean/remote");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@AfterClass
	@Ignore
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	@Ignore
	public void setUp() throws Exception
	{
	}

	@Test
	public void testSave()
	{
		personService.save(new Person("ľ��"));
	}

	@Test
	public void testUpdate()
	{
		Person person=personService.getPerson(1);
		person.setName("��˳��");
		personService.update(person);
		
	}

	@Test
	public void testDelete()
	{
//		personService.delete(1);
		//ÿ�ζ�ɾ���Ļ��϶�û����
	}

	@Test
	public void testGetPerson()
	{
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void testGetPersons()
	{
		List<Person> persons= personService.getPersons();
		for(Person person:persons)
		{
			System.out.println(person.getName());
		}
	}

}
