
package com.fiter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

/*
 2008-1-12����02:19:13
 ���ߣ���èzk
 ��Ȩ���У������ο�
 */
public class MyFiter extends RequestProcessor {

	@Override
	protected boolean processPreprocess(HttpServletRequest arg0, HttpServletResponse arg1) {
		
		try {
			arg0.setCharacterEncoding("gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return true;
	}

}
