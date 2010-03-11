<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<center>
			<h1>
				找回密码
			</h1>
			<hr color="#3254DD" width="80%">
			<s:form action="" method="post">
				<table>
					<tr>
						<td>
							<s:textfield name="Custom.email" label="注册的Email：" />
						</td>
						<td>
							<s:textfield name="yanzheng" label="验证码："/>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit theme="simple" value="确认" />
						</td>
						<td>
							<s:reset theme="simple" value="重置" />
						</td>
					</tr>
				</table>
				
			</s:form>
		</center>
	</body>
</html>
