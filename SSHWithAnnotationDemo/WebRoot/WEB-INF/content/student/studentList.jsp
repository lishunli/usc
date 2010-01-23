<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/content/share/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'allStudentList.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table border="1">
			<tr>
				<td>
					学号
				</td>
				<td>
					姓名
				</td>
				<td>
					性别
				</td>
				<td>
					年龄
				</td>
				<td>
					分数
				</td>
				<td>
					入学日期
				</td>
			</tr>
			<s:iterator value="#request.studentList" id="student">
				<tr>
					<td>
						<s:property value="#student.no" />
					</td>
					<td>
						<s:property value="#student.name" />
					</td>
					<td>
						<s:property value="#student.sex" />
					</td>
					<td>
						<s:property value="#student.age" />
					</td>
					<td>
						<s:property value="#student.score" />
					</td>
					<td>
						<s:property value="#student.eduTime" />
					</td>
				</tr>
			</s:iterator>

		</table>
	</body>
</html>
