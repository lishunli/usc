<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
 			function trim(str){  //删除左右两端的空格
  				 return str.replace(/(^\s*)|(\s*$)/g, "");
 			}
			<!-- function ltrim(str){  //删除左边的空格-->
			<!-- return str.replace(/(^\s*)/g,"");-->
			<!-- }-->
			<!-- function rtrim(str){  //删除右边的空格-->
			<!--   return str.replace(/(\s*$)/g,"");-->
			<!-- }-->
		</script>


		<script type="text/javascript">
			function checkstu()
			{
				if("" == trim(document.getElementById("no").value))
				{
					alert("学号不能为空，请重新输入！");
					document.getElementById("no").focus();
					return false;
				}
	
			}
		</script>

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
		<!--		<s:action name="gradeNameAction" id="gradeNameAction" />-->
		<s:form action="addStu" validate="true">
			<s:action name="gradeNameAction" id="gradeNameAction" />
			<s:textfield name="stu.sno" label="%{getText('no')}" id="no"
				maxLength="11"></s:textfield>
			<s:textfield name="stu.sname" label="%{getText('name')}" id="name"></s:textfield>
			<s:select list="{'男生','女生'}" name="stu.sex" label="%{getText('sex')}"
				id="sex"></s:select>
			<s:textfield name="stu.age" label="%{getText('age')}" id="age"></s:textfield>
			<s:select list="#gradeNameAction.gradeName" headerKey="0"
				listKey="gname" listValue="gname" name="stu.gname"
				label="%{getText('grade')}" id="grade">


			</s:select>
			<s:submit value="%{getText('submit')}"></s:submit>
		</s:form>
	</body>
</html>
