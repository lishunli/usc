<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
	<head>
		<title><bean:message key="login.jsp.title" /></title>
		<html:javascript formName="loginForm" />
	</head>
	<body>
		<center>
			<table border="0" width="920" cellspacing="0" bgcolor="white">
				<tr>
					<jsp:include page="/top.jsp"></jsp:include>
				</tr>
				<tr>
					<td height="500" align="center" valign="top">

						<br>
						<br>

						<html:form action="/login"
							onsubmit="return validateLoginForm(this);">
							<bean:message key="login.jsp.username" />: <html:text
								property="username" />
							<font color="#FF0000"><html:errors property="username" />
								<br /> </font>
							<bean:message key="login.jsp.password" />: <html:password
								property="password" />
							<font color="#FF0000"><html:errors property="password" />
								<br /> </font>
							<br />
							<html:submit>
								<bean:message key="login.jsp.submit" />
							</html:submit>
							<html:reset>
								<bean:message key="login.jsp.reset" />
							</html:reset>
						</html:form>
						<br>
						<br>
						<br>

					</td>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>

				</tr>
				<tr>
					<hr>
					<jsp:include page="/bottom.jsp"></jsp:include>
					<br>
				</tr>
			</table>
		</center>
	</body>
</html>

