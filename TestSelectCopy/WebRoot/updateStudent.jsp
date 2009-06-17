<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
	<head>
		<title>学生管理系统修改学生信息</title>
		<html:javascript formName="addStudentForm" />
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache");
		%>
		<!--上面的语句是进入jsp后刷新一次-->
		<center>
			<table border="0" width="920" cellspacing="0" bgcolor="white">
				<tr>
					<jsp:include page="/top.jsp"></jsp:include>
				</tr>
				<tr>
					<td height="500" align="center" valign="top">
						<div align="left">
							您现在的位置：
							<a href="index.jsp">首页</a>&gt;&gt;修改学生信息
						</div>
						<p align="right">
							<a href="loginOut.do">注销登录</a>
						</p>

						<br>
						<br>
						<html:form action="/updateStudent"
							onsubmit="return validateAddStudentForm(this);">
			学号: <html:text property="sno" value="${updatelist.sno}" />
							<font color="#FF0000"><html:errors property="sno" /> <br />
							</font>
							
							
			姓名: <html:text property="sname" value="${updatelist.sname}" />
							<font color="#FF0000"><html:errors property="sname" /> <br />
							</font>
							
							
							  
			性别: <html:select property="sex" value="${updatelist.sex}">
								<html:option value="男生">男生</html:option>
								<html:option value="女生">女生</html:option>
							</html:select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<font color="#FF0000"><html:errors property="sex" /> </font>
							<br />  
			年龄: <html:text property="age" value="${updatelist.age}" />


							<font color="#FF0000"><html:errors property="age" /> </font>
							<br />


班级: <html:select property="gname" value="${updatelist.gname}">
								<html:option value="计算机061班">计算机061班</html:option>
								<html:option value="计算机062班">计算机062班</html:option>
								<html:option value="软件061班">软件061班</html:option>
								<html:option value="软件062班">软件062班</html:option>
								<html:option value="网络061班">网络061班</html:option>
								<html:option value="计算机071班">计算机071班</html:option>
								<html:option value="数媒071班">数媒071班</html:option>
								<html:option value="软件071班">软件071班</html:option>
								<html:option value="软件072班">软件072班</html:option>
								<html:option value="网络071班">网络071班</html:option>
								<html:option value="网络072班">网络072班</html:option>

							</html:select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
<font color="#FF0000"><html:errors property="gname" /> </font>



							<br />
							<html:submit value="修改" />
							<html:reset value="重置" />
						</html:form>
						<br>
						<br>
						<br>

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

