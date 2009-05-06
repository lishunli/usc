<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload3.jsp' starting page</title>
    
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

<script type="text/javascript">

<!--addMore函数可以提供上传多个文件上传-->

function addMore()
{

	var td = document.getElementById("more");
	
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	
	input.type = "file";
	input.name = "file";
	
	button.type = "button";
	button.value = "   删除    ";
	
	button.onclick = function()
	{
		td.removeChild(br);
		td.removeChild(input);
		td.removeChild(button);
	}
	
	td.appendChild(br);
	td.appendChild(input);
	td.appendChild(button);
}

</script>
 
<!--<h3><font color="red">上传文件类型后缀为doc,ppt,xls,pdf,txt,java，每个文件大小不能大于50M</font></h3>-->

<table align="center" width="40%">
<tr>
<td>

<!--		<s:actionerror cssStyle="color:red"/>-->
	<s:fielderror cssStyle="color:red"/>

</td>
</tr>

<s:form action="upload" theme="simple" method="post" enctype="multipart/form-data">

</table>
		<table align="center" width="40%" border="1">

				<tr>
					<td>
						用户名
					</td>

					<td>
						<s:textfield name="username"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						密码
					</td>

					<td>
						<s:password name="password"> </s:password>
					</td>
				</tr>


				<tr >
					<td >
						上传文件
					</td>
					<td id="more">
						<s:file name="file"></s:file><input type="button" value="上传更多..." onclick="addMore()">
					</td>
				</tr>



				<tr>

					<td>
						<s:submit value=" 确认 "></s:submit>
					</td>

					<td>
						<s:reset value=" 重置 " ></s:reset>
					</td>
				</tr>

</table>

</s:form>

  </body>
</html>
