package org.springframework.samples.mvc.basic.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.samples.mvc.basic.util.SimpleNameUtil;

/**
 * Method Two Interceptor to calculate spent time in invoke controller method <br>
 * Use spring Normal Interceptor and configruation <br>
 * Advantages: very easy to get handler's params e.g. method name and class name <br>
 * Disadvantages: very diffcult to config <br>
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2011-7-7<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        <p>
 */
@Order(2)
public class PerformanceMTInterceptor implements MethodInterceptor {// extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(getClass());

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object result = methodInvocation.proceed();

		Method method = methodInvocation.getMethod();
		Object[] params = { SimpleNameUtil.chompClassName(method.getDeclaringClass().getName()), method.getName(), System.currentTimeMillis() - startTime };

		log.info("[3] {} elapsed time for {}() = {} ms ", params);
		return result;
	}

}
