<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>学生管理系统按学号查询学生信息</title>
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
							<a href="index.jsp">首页</a>&gt;&gt;按学号查询学生信息
						</div>
						<c:choose>
							<c:when test="${empty login}">
								<p align="right">
									<a href="login.jsp">登录</a>
								</p>
							</c:when>
							<c:otherwise>
								<p align="right">
									<a href="loginOut.do">注销登录</a>
								</p>
							</c:otherwise>
						</c:choose>
						<br>
						<br>
						<html:form action="/searchbyno">
						学号 : <html:text property="sno" />
							<html:errors property="sno" />
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
					<br>
					<br>
<br>
					<br><br>
					<br><br>
					

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

