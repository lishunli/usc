<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="logic"  uri="http://struts.apache.org/tags-logic"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 
<logic:forward name="reguserui" />

<logic:redirect forward="reguserui"></logic:redirect>
<logic:redirect page="/RegUserUI.htm"></logic:redirect>
--%>
<logic:redirect href="${pageContext.request.contextPath}/RegUserUI.htm"></logic:redirect>