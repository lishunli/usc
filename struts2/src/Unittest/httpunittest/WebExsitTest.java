package Unittest.httpunittest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.TableCell;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;


public class WebExsitTest
{
	@Test
	public void webExsitTest()
	{
		WebConversation webConversation = new WebConversation();
		
		//������ҳ�Ƿ���ڲ���,����URL��ʽ,�������URL������߲����ڵĻ����ᱨһ������
		try
		{
			webConversation.getResponse("http://localhost:8080/struts2");
			
//			webConversation.getResponse("http://localhost:8080/struts2/login.jsp");
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void webExsitTest2()
	{
		WebConversation webConversation = new WebConversation();
		
		//ʹ���������
		WebRequest request = new GetMethodWebRequest("http://localhost:8080/struts2");
		
		try
		{
			webConversation.getResponse(request);
			
//			webConversation.getResponse("http://localhost:8080/struts2/login.jsp");
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	����Ӧ�Ķ����еõ�����Ӧҳ��������õ�
	@Test
	@Ignore
	public void  showWebContext()
	{
		WebConversation webconversation  = new WebConversation();
		
		try
		{
			WebResponse response =webconversation.getResponse("http://localhost:8080/struts2");
			
			System.out.println(response.getText());
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
//	���Ա��
	@Test
	public void testWebTables()
	{
		WebConversation webconversation  = new WebConversation();
		
		
		try
		{
			WebResponse response =webconversation.getResponse("http://localhost:8080/struts2/register.jsp");
			
			//webTable�Ƕ���ҳ�ı���һ�ַ�װ
			//����ҳ�����е������ı��
//			WebTable webTable = response.getTables()[0];//0����
			WebTable webTable = response.getTables()[1];
			
			assertEquals(2,webTable.getColumnCount());
			assertEquals(7, webTable.getRowCount());
			
			TableCell cell =webTable.getTableCell(1, 0);
			
			assertEquals("password", cell.getText());
			
		} catch (Exception e)
		{
			// TODO: handle exception
		}

		
	}
	
	//��������
	@Test
	@Ignore
	public void testWebLink()
	{
		WebConversation webconversation  = new WebConversation();

		try
		{
			WebResponse response =webconversation.getResponse("http://localhost:8080/struts2/register.jsp");
			
			WebLink link = response.getLinkWith("hello");
			
			WebRequest clickRequest = link.getRequest();
			
			WebResponse linkPage = webconversation.getResponse(clickRequest);
			
			String expectedURL ="http://localhost:8080/struts2/success.jsp";
			
			assertEquals(expectedURL, linkPage.getURL().toString());

			
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
//	����form���е�һЩ�ؼ���Ĭ��ֵ���ύ
	@Test
	public void testWebForm()
	{
		WebConversation webconversation  = new WebConversation();

		try
		{
			WebResponse response =webconversation.getResponse("http://localhost:8080/struts2/login.jsp");
			
			//��װ
			WebForm form = response.getForms()[0];//ȡ�ñ��ĵ�һ��

			
			
			assertEquals("",form.getParameterValue("username"));
			
			//����������
			
			//�����ύ
			
			WebResponse submit = form.submit();
			
			String expectedURL ="http://localhost:8080/struts2/login.action";
			
			assertEquals(expectedURL, submit.getURL().toString());

			
		} catch (Exception e)
		{
			// TODO: handle exception
		}

		
	}
	
	
	

}
