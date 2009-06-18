/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.usc.struts.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.usc.dao.Student;
import com.usc.service.studentService;

/**
 * MyEclipse Struts Creation date: 06-19-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 */
public class PdfAction extends Action
{
	private studentService ss;

	public void setSs(studentService ss)
	{
		this.ss = ss;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		Document document = new Document();
		ByteArrayOutputStream student = new ByteArrayOutputStream();
		try
		{
			PdfWriter writer = PdfWriter.getInstance(document, student);
		} catch (DocumentException e1)
		{
			e1.printStackTrace();
		}
		document.open();
		
//		List<Student> list = ss.getAllStudnet();
//
//		for (int i = 0; i < list.size(); ++i)
//		{
//			document.add(new Paragraph((String) list.get(i)));
//		}
//		
		try
		{
			document.add(new Paragraph("student"));
		} catch (DocumentException e1)
		{
			e1.printStackTrace();
		}
		document.close();

		OutputStream os;
		try
		{
			os = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("Content-disposition",
					"attachment;filename=student.pdf");
			student.writeTo(os);
			os.flush();
			os.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}