package org.springframework.samples.mvc.basic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-7-6<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
public class PerformanceInterceptor extends HandlerInterceptorAdapter {

	long start = 0L;
	long end = 0L;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		start = System.currentTimeMillis();

		return true;
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		end = System.currentTimeMillis();

		System.out.println("elapsed time for = " + (end - start) + " ms");
	}

}
