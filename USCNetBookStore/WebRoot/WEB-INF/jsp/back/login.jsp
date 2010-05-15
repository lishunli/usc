<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台登陆</title>
		<link rel="stylesheet" href="../../../css/error.css" type="text/css"></link>
	</head>
	<body>
		<h1 align="center" style="color: blue">
			<img alt="usc" src="images/custom/Log.jpg" width="995" height="131" align="top">
			<br>
			电子图书后台管理系统之信息发布系统
		</h1>
		<br>
		<s:form action="backLogin" method="post" theme="simple">
			<table width="600" border="1" align="center" background="images/back/login_back.png">
				<tr>
					<td colspan="2">
						<div align="center">
							<h2>
								后台登陆
							</h2>
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%" align="center" style="color: blue">
						姓名
					</td>
					<td width="80%">
						<s:textfield name="operator.operatorName" id="operatorName" value="%{operator.operatorName}"></s:textfield>

						<font color="red">* <span id="operatorNameError"></span> <s:fielderror>
								<s:param>operator.operatorName</s:param>
							</s:fielderror> </font>
					</td>
				</tr>
				<tr>
					<td align="center" style="color: blue">
						密码
					</td>
					<td>
						<s:password name="operator.operatorPass" id="operatorPass"></s:password>
						<font color="red">* <span id="operatorPassError"></span> <s:fielderror>
								<s:param>operator.operatorPass</s:param>
							</s:fielderror> </font>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<s:submit value="登录"></s:submit>
						<s:reset value="重置"></s:reset>
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

	<div
		style="background: #ededed; height: 31px; width: 100%; position: fixed; left: auto; right: auto; bottom: 0; _position: absolute; _top: e xpression(document.documentElement.clientHeight +     document.documentElement.scrollTop -     this.offsetHeight); text-align: center;">
		Powered by: 南华大学计算机科学与技术学院 指导老师：谢卫星 Copyright ©2010
		<a href="http://www.blogjava.net/lishunli/" target="_blank">李顺利</a>
	</div>

</html>