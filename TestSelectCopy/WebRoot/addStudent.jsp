<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<html>
	<head>
		<title>学生管理系统添加学生</title>

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

						<br>
						<br>
						<html:form action="/addStudent">
			学号: <html:text property="sno" />
							<html:errors property="sno" />
							<br />
							
			姓名: <html:text property="sname" />
							<html:errors property="sname" />
							<br /> 
							
							  
			性别: <html:select property="sex">
								<html:option value="男生">男生</html:option>
								<html:option value="女生">女生</html:option>
							</html:select>

							<html:errors property="sex" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<br />  
			年龄: <html:text property="age" />
							<html:errors property="age" />
							<br />
			班级: <html:select property="gname">

								<logic:iterate id="g" name="gradelist">
									<html:option value="${g}"></html:option>
								</logic:iterate>
							</html:select>
							<html:errors property="gname" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
							<br />
							<html:submit value="添加" />
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

