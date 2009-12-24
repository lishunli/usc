<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Excel或DBF文件导入MySql数据库</title>
	</head>
	<body>

		<table align="center" width="50%">
			<tr>
				<td>

					<s:fielderror cssStyle="color:red" />

				</td>
			</tr>
		</table>
		<br>
		<p align="right">
			<a href="index.jsp">回到首页</a>
		</p>
		<br>
		<br>
		<br>

		<h1 align="center">
			Excel或DBF文件导入MySql数据库
		</h1>
		<s:form action="upload.action" theme="simple" method="post"
			enctype="multipart/form-data">

			<table align="center" width="50%" border="1">
				<tr>
					<td>
						导入数据文件
					</td>
					<td>
						<s:file name="upload"></s:file>
					</td>
				</tr>
				<tr>
					<td>

					</td>
					<td>
						<s:submit value=" 导入 "></s:submit>
					</td>
				</tr>

			</table>

		</s:form>
		<center>
			<br>
			<br>
			<br>
			Copyright @ 2009-2010 章爱国. All Rights Reserved
		</center>
	</body>


</html>
