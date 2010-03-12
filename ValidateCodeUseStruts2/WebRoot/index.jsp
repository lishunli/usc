<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">     
	    	function changeValidateCode(obj) 
	    	{     
		           //获取当前的时间作为参数，无具体意义     
		        var timenow = new Date().getTime();     
		           //每次请求需要一个不同的参数，否则可能会返回同样的验证码     
		        //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。     
		        obj.src="validateCode2.action?d="+timenow;     
	   		}     
		</script>
	</head>

	<body>
		<%
			response.setHeader("Cache-Control", "no-cache");
		%>
		<!--上面的语句是进入jsp后刷新一次-->
		This is my JSP page.
		<br>
		<s:form action="validate" theme="simple" method="post">
			验证码：<s:textfield name="code" ></s:textfield>
			<img src="validateCode2.action" onclick="changeValidateCode(this)" />
			<s:submit label="验证"></s:submit>
		</s:form>





	</body>
</html>
