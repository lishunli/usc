<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
	<head>
		<title>学生管理系统按姓名查询学生信息</title>
	</head>
	<body>
		<center>
			<table border="0" width="920" cellspacing="0" bgcolor="white">
				<tr>
					<jsp:include page="/top.jsp"></jsp:include>
				</tr>
				<tr>
					<td height="500" align="center" valign="top">
						<div align="left">
							您现在的位置：
							<a href="index.jsp">首页</a>&gt;&gt;按姓名查询学生信息
						</div>
								<p align="right">
									<a href="loginOut.do">注销登录</a>
								</p>
						
						<br>
						<br>
						<html:form action="/serachbyname">
						姓名 : <html:text property="sname" />
							<html:errors property="sname" />
							<br />
							<html:submit value="查询" />
							<html:reset value="重置" />
						</html:form>

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