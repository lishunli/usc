<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p align="right"><a href="indexBack.action">回到后台首页</a></p>

		<s:form action="updatePass" method="post" theme="simple">
姓名：<%=session.getAttribute("manger")%><br>
原密码： <s:password name="operator.operatorPass"></s:password>

			<font color="red">* <span id="operatorPassError"></span> <s:fielderror>
					<s:param>operator.operatorPass</s:param>
				</s:fielderror> </font>
			<br>
新密码：<s:password name="newPass"></s:password>

			<font color="red">* <span id="newPassError"></span> <s:fielderror>
					<s:param>newPass</s:param>
				</s:fielderror> </font>
			<br>
重复新密码：<s:password name="reNewPass"></s:password>

			<font color="red">* <span id="reNewPassError"></span> <s:fielderror>
					<s:param>reNewPass</s:param>
				</s:fielderror> </font>
			<br>
			<s:submit value="修改"></s:submit>
			<s:reset value="重置"></s:reset>
			<br>
		</s:form>
	</body>
</html>