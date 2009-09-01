<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台登陆</title>
		<link rel="stylesheet" href="../../../css/error.css" type="text/css"></link>
	</head>
	<body>
		<s:form action="backLogin" method="post" theme="simple">
			<table width="500" border="1" align="center">
				<tr>
					<td colspan="3">
						<div align="center">
							<h1>
								后台登陆
							</h1>
						</div>
					</td>
				</tr>
				<tr>
					<td width="10%">
						姓名
					</td>
					<td width="35%">
						<s:textfield name="operator.operatorName" id="operatorName"
							value="%{operator.operatorName}"></s:textfield>
					</td>
					<td width="55%">
						<font color="red">* <span id="operatorNameError"></span> <s:fielderror>
								<s:param>operator.operatorName</s:param>
							</s:fielderror>
						</font>
					</td>
				</tr>
				<tr>
					<td>
						密码
					</td>
					<td>
						<s:password name="operator.operatorPass" id="operatorPass"></s:password>
					</td>
					<td>
						<font color="red">* <span id="operatorPassError"></span> <s:fielderror>
								<s:param>operator.operatorPass</s:param>
							</s:fielderror> </font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						<s:submit value="登录"></s:submit>
						<s:reset value="重置"></s:reset>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>

			<%--管理员：<s:textfield name="operator.operatorName"--%>
			<%--				value="%{operator.operatorName}"></s:textfield>--%>
			<%--			<s:fielderror cssClass="formFieldError">--%>
			<%--				<s:param>operator.operatorName</s:param>--%>
			<%--			</s:fielderror>--%>
			<%--			<br>--%>
			<%--密码：<s:password name="perator.operatorPass"></s:password>--%>
			<%--			<s:fielderror cssClass="formFieldError">--%>
			<%--				<s:param>perator.operatorPass</s:param>--%>
			<%--			</s:fielderror>--%>
			<%--			<br>--%>
			<%--			<s:submit value="登录"></s:submit>--%>
			<%--			<s:reset value="重置"></s:reset>--%>
		</s:form>
	</body>
</html>