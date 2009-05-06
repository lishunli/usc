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
		
		//测试网页是否存在并打开,采用URL方式,如果输入URL错误或者不存在的话，会报一个错误
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
		
		//使用请求对象
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
	
//	把相应的对象中得到的响应页面的内容拿到
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
	
//	测试表格
	@Test
	public void testWebTables()
	{
		WebConversation webconversation  = new WebConversation();
		
		
		try
		{
			WebResponse response =webconversation.getResponse("http://localhost:8080/struts2/register.jsp");
			
			//webTable是对网页的表格的一种封装
			//冲网页中所有的最外层的表格
//			WebTable webTable = response.getTables()[0];//0错误？
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
	
	//测试链接
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
	
//	测试form表单中的一些控件的默认值和提交
	@Test
	public void testWebForm()
	{
		WebConversation webconversation  = new WebConversation();

		try
		{
			WebResponse response =webconversation.getResponse("http://localhost:8080/struts2/login.jsp");
			
			//封装
			WebForm form = response.getForms()[0];//取得表单的第一个

			
			
			assertEquals("",form.getParameterValue("username"));
			
			//其他的类似
			
			//测试提交
			
			WebResponse submit = form.submit();
			
			String expectedURL ="http://localhost:8080/struts2/login.action";
			
			assertEquals(expectedURL, submit.getURL().toString());

			
		} catch (Exception e)
		{
			// TODO: handle exception
		}

		
	}
	
	
	

}
