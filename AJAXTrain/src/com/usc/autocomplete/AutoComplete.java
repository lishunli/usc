package com.usc.autocomplete;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: ming
 * Date: 2008-6-14
 * Time: 14:17:00
 * To change this template use File | Settings | File Templates.
 * �����û�������
 */
public class AutoComplete extends HttpServlet{
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //��ʾҳ�洫�������ַ��������ںͷ������εĵ��ʽ�������ƥ��
        String word = httpServletRequest.getParameter("word");
        //���ַ���������request������
        httpServletRequest.setAttribute("word",word);
        //������ת������ͼ�㣨ע��AJAX�У������ν����ͼ�㲻����ҳ�棬ֻ�������ݣ�����Ҳ���Գ���ʹһ�����ݲ㣩
        httpServletRequest.getRequestDispatcher("wordxml.jsp").
                forward(httpServletRequest, httpServletResponse);

    }

    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
