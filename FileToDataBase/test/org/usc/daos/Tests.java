package org.usc.daos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests
{
	@Test
	public void test()
	{
		try
		{
			readXML();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Field[] fields = Stu.class.getDeclaredFields();
		for(Field f : fields)
		{
			System.out.println(f.getName()+":"+f.getGenericType()+":");
			
		}*/
		
		
		
		
	}
	
	public static void readXML() throws FileNotFoundException, IOException
	{

		Document myDoc = null;
		try
		{
			SAXBuilder sb = new SAXBuilder();
			myDoc = sb.build(Tests.class.getClassLoader().getResourceAsStream("org/usc/daos/Stu.hbm.xml"));
		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (NullPointerException e)
		{
			e.printStackTrace();
		}

		Element root = myDoc.getRootElement(); // 先得到根元素
		System.out.println(root);
		
/*		List books = root.getChildren();// root.getChildren("book");
		for (Iterator iter1 = books.iterator(); iter1.hasNext();)
		{
			Element book = (Element) iter1.next();
			System.out.println("bookname:" + book.getChild("name").getText());
			System.out.println("hot:"
					+ book.getChild("name").getAttributeValue("hot"));
			System.out.println("price:" + book.getChild("price").getText());
		}*/

	}

	
}
