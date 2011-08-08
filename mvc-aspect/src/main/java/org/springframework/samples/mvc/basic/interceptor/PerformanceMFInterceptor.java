package org.springframework.samples.mvc.basic.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.samples.mvc.basic.util.SimpleNameUtil;

/**
 * Method Fourt Interceptor to calculate spent time in invoke controller method <br>
 * Use spring config on aspect <br>
 * Advantages: very easy to get handler's params e.g. method name and class name <br>
 * Disadvantages: very diffcult to config <br>
 *
 * @author <a href="http://www.blogjava.net/lishunli/"
 *         target="_blank">ShunLi</a>
 * @notes Created on 2011-7-7<br>
 *        Revision of last commit:$Revision$<br>
 *        Author of last commit:$Author$<br>
 *        <p>
 */
@Order(4)
public class PerformanceMFInterceptor {
	private Logger log = LoggerFactory.getLogger(getClass());

	public Object invoke(ProceedingJoinPoint jp) throws Throwable {
		long startTime = 0;
		Object proceed = null;
		startTime = System.currentTimeMillis();
		try {
			proceed = jp.proceed(); // execute
		} finally {
			Object[] params = { SimpleNameUtil.chompClassName(jp.getSignature().getDeclaringTypeName()), jp.getSignature().getName(), (System.currentTimeMillis() - startTime) };
			log.info("[2] {} elapsed time for {}() = {} ms ", params);
		}

		return proceed;
	}

}