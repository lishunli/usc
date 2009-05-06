<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
function vaildate() {
<!--另一种方法获得表单元素-->
<!--var usernamevalue=document.getElementsByTagName("username")[0].value;-->
<!--客户端校验-->
<!--表单加入了id属性，直接使用-->
	var usernamevalue=document.getElementById("usernameId").value;
	var passwordvalue=document.getElementById("passwordId").value;
	var repasswordvalue=document.getElementById("repasswordId").value;
	
	if(usernamevalue.length==0)
	{
		alert("username should not be blank!");
		return false;	
	}
	else if(usernamevalue.length<6 || usernamevalue.length >10)
	{
		alert("length of username should be between 6 and 10!");
		return false;
	}
	
	if(passwordvalue.length==0)
	{
		alert("password should not be blank!");
		return false;	
	}
	else if(passwordvalue.length<6 || passwordvalue.length >10)
	{
		alert("length of password should be between 6 and 10!");
		return false;
	}
	
	if(repasswordvalue.length==0)
	{
		alert("repassword should not be blank!");
		return false;	
	}
	else if(repasswordvalue.length<6 || repasswordvalue.length >10)
	{
		alert("length of repassword should be between 6 and 10!");
		return false;
	}
	
	else if(repasswordvalue  != passwordvalue)
	{
		alert("repassword and password should be same!");
		return false;
	}	
	
	return true;
}





</script>


  </head>
  
  <body>
    
		<center>
			<s:text name="addUser"></s:text>
		</center>

		<center>
			<s:i18n name="temp">
				<s:text name="hello">
					<s:param>木子</s:param>
				</s:text>
			</s:i18n>
		</center>


	<table align="center" width="40%">
<tr>
<td>

<!--		<s:actionerror cssStyle="color:red"/>-->
<!--	<s:fielderror cssStyle="color:red"/>-->
		<s:actionerror cssStyle="color:blue"/>

</td>
</tr>




<s:form action="register3" theme="simple">
	<s:token></s:token> 		<!--表单重复提交-->

<!--使用国际化的时候theme一定要除掉simple  theme="simple"-->
<!--theme的使用是为了不要使用内置的addfieldworre，只使用其他的校验-->
<!--onsubmit="return vaildate();"-->
<!--onsubmit方法是用在客户端的校验上-->


</table>
		<table align="center" width="60%" border="1">

				<tr>
					<td>
						用户名
					</td>

					<td>
						<s:textfield name="username" label="用户名" id="usernameId"></s:textfield>
<!--							<s:textfield name="username" key="username.xml.invalid" id="usernameId"></s:textfield>-->
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>username</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					<td>
						密码
					</td>

					<td>
						<s:password name="password" label="密码" id="passwordId"> </s:password>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>password</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					<td>
						确认密码
					</td>

					<td>
						<s:password name="repassword" label="确认密码" id="repasswordId"></s:password>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>repassword</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					<td>
						年龄
					</td>

					<td>
						<s:textfield name="age" label="年龄"></s:textfield>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>age</s:param>
							</s:fielderror>
					</td>

				</tr>


				<tr>
					<td>
						出生日期
					</td>

					<td>
						<s:textfield name="birthday" label="出生日期"></s:textfield>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>birthday</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					
					<td>
						毕业日期
					</td>
					<td>
						<s:textfield name="graduation" label="毕业日期"></s:textfield>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>graduation</s:param>
							</s:fielderror>
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


   
	
<!--	<s:reset value=" 重置 " ></s:reset>-->
	

</s:form>

  </body>
</html>
