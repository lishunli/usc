<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加学生</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<!--#gradeNameAction.gradeName-->
	<body>
		<s:action name="gradeNameAction" id="gradeNameAction" />
		<s:form action="addStu">
			<s:textfield name="stu.sno" label="%{getText('no')}"></s:textfield>
			<s:textfield name="stu.sname" label="%{getText('name')}"></s:textfield>
			<s:select list="{'男生','女生'}" name="stu.sex" label="%{getText('sex')}"></s:select>
			<s:textfield name="stu.age" label="%{getText('age')}"></s:textfield>
			<s:select list="#gradeNameAction.gradeName" headerKey="0"
				listKey="gname" listValue="gname" name="stu.gname"
				label="%{getText('grade')}">


			</s:select>

			<s:submit value="%{getText('submit')}"></s:submit>
		</s:form>
	</body>
</html>
