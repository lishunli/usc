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

<!--addMore���������ṩ�ϴ�����ļ��ϴ�-->

function addMore()
{

	var td = document.getElementById("more");
	
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	
	input.type = "file";
	input.name = "file";
	
	button.type = "button";
	button.value = "   ɾ��    ";
	
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
 
<!--<h3><font color="red">�ϴ��ļ����ͺ�׺Ϊdoc,ppt,xls,pdf,txt,java��ÿ���ļ���С���ܴ���50M</font></h3>-->

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
						�û���
					</td>

					<td>
						<s:textfield name="username"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						����
					</td>

					<td>
						<s:password name="password"> </s:password>
					</td>
				</tr>


				<tr >
					<td >
						�ϴ��ļ�
					</td>
					<td id="more">
						<s:file name="file"></s:file><input type="button" value="�ϴ�����..." onclick="addMore()">
					</td>
				</tr>



				<tr>

					<td>
						<s:submit value=" ȷ�� "></s:submit>
					</td>

					<td>
						<s:reset value=" ���� " ></s:reset>
					</td>
				</tr>

</table>

</s:form>

  </body>
</html>
