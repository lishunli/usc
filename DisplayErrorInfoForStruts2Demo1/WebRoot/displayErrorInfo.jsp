<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>DisplayErrorInfo</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body>
		<s:form action="displayErrorInfo" method="post" theme="simple">
			<h1 align="center" style="color: blue">
				DisplayErrorInfoForStruts2Demo1(使用OGNL拿值栈的内容，推荐使用)
			</h1>
			<h2 dir="rtl">
				顺利整理
			</h2>
			<hr>
			<hr>
			1.1.All ErrorInfos(Map):&nbsp;<s:property value="errors" /><br>
			1.2.All fieldErrorsInfos(Map):&nbsp;<s:property value="fieldErrors" /><br>
			<hr>
			2.1.DisplayErrorInfo in errors(errors.displayErrorInfo[0]):<s:textfield />
			<font color="red">
				<s:property value="errors.displayErrorInfo[0]" /> 
			</font>
			<br>
			2.2.DisplayErrorInfo in errors(errors['displayErrorInfo'][0]):<s:textfield />
			<font color="red">
				<s:property value="errors['displayErrorInfo'][0]" /> 
			</font>
			<br>
				&nbsp;&nbsp;<font color="green">注：拿到值后，就可以按照自己的格式进行自定义显示了</font>
			<br>
			2.3.DisplayErrorInfo in errors(一般不会使用到[1],这里仅是测试):<s:textfield />
			<font color="red">
				<s:property value="errors.displayErrorInfo[1]" /> 
			</font>
			<br>
			<hr>
			3.1.DisplayErrorInfo in fieldErrors(fieldErrors.displayErrorInfo[0]):<s:textfield />
			<font color="red">
				<s:property value="fieldErrors.displayErrorInfo[0]" /> 
			</font>
			<br>
			3.2.DisplayErrorInfo in fieldErrors(fieldErrors['displayErrorInfo'][0]):<s:textfield />
			<font color="red">
				<s:property value="fieldErrors['displayErrorInfo'][0]" /> 
			</font>
			<br>
				&nbsp;&nbsp;<font color="green">注：建议使用fieldErrors取值，在Action中使用的是this.addFieldError</font>
			<br>
			<hr>
			4.0.DisplayErrorInfo - user.username(正确的表达式.errors['user.username'][0]):<s:textfield />
			<font color="red">
				<s:property value="errors['user.username'][0]" /> 
			</font>
			<br>
			4.1.DisplayErrorInfo - user.username(正确的表达式.fieldErrors['user.username'][0]):<s:textfield />
			<font color="red">
				<s:property value="fieldErrors['user.username'][0]" /> 
			</font>
			<br>
			<font color="blue"> 
				4.2.DisplayErrorInfo - user.username(错误的表达式1.errors.%{user.username}[0]):<s:textfield />
				<font color="red">
					<s:property value="errors.%{user.username}[0]" /> 
				</font>
				<br> 4.3.DisplayErrorInfo - user.username(错误的表达式2.errors.# {user.username}[0]):<s:textfield />
				这种方法本身语言就有问题，详情请看JSP规范对# 的规范
				<br> 4.4.DisplayErrorInfo - user.username(错误的表达式3.%{errors.user.username}[0]):<s:textfield />
				<font color="red">
					<s:property value="%{errors.user.username}[0]" /> 
				</font>
				<br> 4.5.DisplayErrorInfo - user.username(错误的表达式4.errors.user.username):<s:textfield />
				<font color="red">
					<s:property value="errors.user.username" /> 
				</font>
			<br>
			</font>
		</s:form>
		<hr>
		<s:debug />
	</body>
</html>
