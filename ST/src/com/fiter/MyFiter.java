
package com.fiter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.RequestProcessor;

/*
 2008-1-12下午02:19:13
 作者：老猫zk
 版权所有，仅供参考
 */
public class MyFiter extends RequestProcessor {

	@Override
	protected boolean processPreprocess(HttpServletRequest arg0, HttpServletResponse arg1) {
		
		try {
			arg0.setCharacterEncoding("gb2312");
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return true;
	}

}
