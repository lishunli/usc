<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
								<c:choose>
									<c:when test="${empty glist}">
											没有班级信息
								</c:when>
									<c:otherwise>
										<c:forEach items="${glist}" var="g">
											<html:option value="${g}"></html:option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
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

