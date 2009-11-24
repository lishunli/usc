package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.bean.privilege.Employee;
import cn.itcast.utils.WebUtil;
/**
 * Ա����¼У��,���Ա��δ��¼�����������/control��ͷ��·��
 */
public class EmployeeValidateFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		Employee employee = WebUtil.getEmployee(request);
		if(employee==null){
			HttpServletResponse response = (HttpServletResponse) res; 
			response.sendRedirect("/employee/logon.do");
			return ;
		}
		filterChain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
