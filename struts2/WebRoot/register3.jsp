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
<!--��һ�ַ�����ñ�Ԫ��-->
<!--var usernamevalue=document.getElementsByTagName("username")[0].value;-->
<!--�ͻ���У��-->
<!--��������id���ԣ�ֱ��ʹ��-->
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
					<s:param>ľ��</s:param>
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
	<s:token></s:token> 		<!--���ظ��ύ-->

<!--ʹ�ù��ʻ���ʱ��themeһ��Ҫ����simple  theme="simple"-->
<!--theme��ʹ����Ϊ�˲�Ҫʹ�����õ�addfieldworre��ֻʹ��������У��-->
<!--onsubmit="return vaildate();"-->
<!--onsubmit���������ڿͻ��˵�У����-->


</table>
		<table align="center" width="60%" border="1">

				<tr>
					<td>
						�û���
					</td>

					<td>
						<s:textfield name="username" label="�û���" id="usernameId"></s:textfield>
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
						����
					</td>

					<td>
						<s:password name="password" label="����" id="passwordId"> </s:password>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>password</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					<td>
						ȷ������
					</td>

					<td>
						<s:password name="repassword" label="ȷ������" id="repasswordId"></s:password>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>repassword</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					<td>
						����
					</td>

					<td>
						<s:textfield name="age" label="����"></s:textfield>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>age</s:param>
							</s:fielderror>
					</td>

				</tr>


				<tr>
					<td>
						��������
					</td>

					<td>
						<s:textfield name="birthday" label="��������"></s:textfield>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>birthday</s:param>
							</s:fielderror>
					</td>

				</tr>

				<tr>
					
					<td>
						��ҵ����
					</td>
					<td>
						<s:textfield name="graduation" label="��ҵ����"></s:textfield>
					</td>

					<td>
							<s:fielderror cssStyle="color:red">
								<s:param>graduation</s:param>
							</s:fielderror>
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


   
	
<!--	<s:reset value=" ���� " ></s:reset>-->
	

</s:form>

  </body>
</html>
