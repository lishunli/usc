<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>register</title>
		<link rel="stylesheet" href="css/error.css" type="text/css"></link>
	</head>
	<body>



		<%--		<s:fielderror cssStyle="color: red"></s:fielderror>--%>


		<form action="register.action" method="post">
			用 &nbsp;戶&nbsp;名：
			<input type="text" name="user.username" />
<%--			<s:fielderror cssClass="formFieldError">--%>
<%--				<s:param>user.username</s:param>--%>
<%--			</s:fielderror>--%>
	
			<s:fielderror cssStyle="color: red">
				<s:param>user.username</s:param>
			</s:fielderror>

			<br>
			密&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;码：
			<input type="password" name="user.password" />
<%--			<s:fielderror cssClass="formFieldError">--%>
<%--				<s:param>user.password</s:param>--%>
<%--			</s:fielderror>--%>
			<s:fielderror cssStyle="color: red">
				<s:param>user.password</s:param>
			</s:fielderror>
			<br>
			重复密码：
			<input type="password" name="repassword" />
			<s:fielderror cssStyle="color: red">
				<s:param>repassword</s:param>
			</s:fielderror>
			<br>
			<input type="submit" value="注册">
			<input type="reset" value="重置">
		</form>

		<%--	<s:form action="register" method="post">--%>
		<%--    	<s:textfield name="user.username" label="用 戶名："></s:textfield>--%>
		<%--    	<s:password name="user.password" label="密码："></s:password>--%>
		<%--    	<s:password label="重复密码："></s:password>--%>
		<%--		<s:submit label="注册"></s:submit>--%>
		<%--		<s:reset label="重置"></s:reset>--%>
		<%--    </s:form>--%>
	</body>
</html>