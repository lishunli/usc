<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>upload</title>
	</head>
	<body>
		<!--<h3><font color="red">上传文件类型后缀为doc,ppt,xls,pdf,txt,java，每个文件大小不能大于50M</font></h3>-->

		<table align="center" width="50%">
			<tr>
				<td>

					<!--		<s:actionerror cssStyle="color:red"/>-->
					<s:fielderror cssStyle="color:red" />

				</td>
			</tr>
		</table>
		<h1 align="center">
			Excel或DBF文件导入数据库（MySql）
		</h1>
		<s:form action="upload.action" theme="simple" method="post"
			enctype="multipart/form-data">

			<table align="center" width="50%" border="1">
				<tr>
					<td>
						导入源文件
					</td>
					<td>
						<s:file name="upload"></s:file>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit value=" 确认 "></s:submit>
					</td>
					<td>
						<s:reset value=" 重置 "></s:reset>
					</td>
				</tr>

			</table>

		</s:form>
		<hr><hr>
		<br>
		<center>
		<h1><a href="exportXLS.action">导出为Excel文件</a>	</h1>
		<h1><a href="exportDBF.action">导出为DBF文件</a>	</h1>
		</center>
		
		<br>
		<center>
			Copyright @ 2009-2010 林淼. All Rights Reserved
		</center>
		
		
	
		
		

	</body>


</html>
