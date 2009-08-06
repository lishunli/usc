<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table align="center" border="0">
			<tralign="center">
			<td>
				<fontcolor="red">
				<html:errors />
				</font>
			</td>
			</tr>
			<tr align="center">
				<td>
					系统登录
				</td>
			</tr>
			<form. action="loginCheck.jsp" method="post" focus="username">
			<tr>
				<td>
					用户名：
					<input type="text" name="username" />
				</td>
			</tr>
			<tr>
				<td>
					密&nbsp;&nbsp;码：
					<input type="password" name="password" />
				</td>
			</tr>
			<tr>
				<td>
					验证码：
					<input type="text" name="certCode" />
					<img src="makeCertPic.jsp">
				</td>
			</tr>
			<tralign="left">
			<td>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="确定" />
			</td>
			</tr>
			</form>
		</table>

	</body>
</html>