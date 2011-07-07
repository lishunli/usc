package org.springframework.samples.mvc.basic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Method One Interceptor to calculate spent time in invoke controller method <br>
 * Use mvc:interceptors must impl HandlerInterceptor <br>
 * Advantages: very easy impl and understand(only user mvc:interceptors),best integration with spring mvc 3 ,calculation is most comprehensive and most correct <br>
 * Disadvantages: very diffcult to get handler's method name<br>
 *
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-7-6<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        Date of last commit:$Date$<br>
 *        <p>
 */
@Order(1)
public class PerformanceMOInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(getClass());

	long startTime = 0L;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		startTime = System.currentTimeMillis();

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("[5] elapsed time {} ms ", System.currentTimeMillis() - startTime);
		// TODO to get handler's method name.
	}

}
