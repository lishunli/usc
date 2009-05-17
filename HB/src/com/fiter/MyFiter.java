
package com.fiter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

public class MyFiter extends RequestProcessor {

	@Override
	protected boolean processPreprocess(HttpServletRequest arg0, HttpServletResponse arg1) {
		
		try {
			arg0.setCharacterEncoding("gbk");
//			arg1.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return true;
	}

}
