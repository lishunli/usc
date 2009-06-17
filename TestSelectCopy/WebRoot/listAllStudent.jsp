<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>显示所有学生信息</title>

		<script type="text/javascript">
	function del()
	{
		if ("<%= session.getAttribute("login") %>" == "null") {   
    		alert("需要登陆才能删除学生,请登录");   
		} 
		if(confirm("你真的想删除该学生的信息吗？"))
		{
			return true;
		}
		return false;
		
		
	}
	</script>
	</head>
	<body>
		<center>
			<table border="0" width="920" cellspacing="0" bgcolor="white">
				<tr>
					<jsp:include page="/top.jsp"></jsp:include>
				</tr>
				<tr>
					<td height="500" align="center" valign="top">
						<div align="left">
							您现在的位置：
							<a href="index.jsp">首页</a>&gt;&gt;显示所有学生信息
						</div>
						<c:choose>
							<c:when test="${empty login}">
								<p align="right">
									<a href="login.jsp">登录</a>
								</p>
								</a>
							</c:when>
							<c:otherwise>
								<p align="right">
									<a href="loginOut.do">注销登录</a>
								</p>
							</c:otherwise>
						</c:choose>
						<br>
						<br>

						<table border="1">
							<tr>
								<td>
									学号
								</td>
								<td>
									姓名
								</td>
								<td>
									性别
								</td>
								<td>
									年龄
								</td>
								<td>
									班级
								</td>
								<td>
									修改
								</td>
								<td>
									删除
								</td>
							</tr>
							<c:choose>
								<c:when test="${empty studentlist}">
									<tr>
										<td colspan="7">
											没有学生信息!
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${studentlist}" var="stu">
										<tr>
											<td>
												${stu.sno }
											</td>
											<td>
												${stu.sname }
											</td>
											<td>
												${stu.sex }
											</td>
											<td>
												${stu.age }
											</td>
											<td>
												${stu.gname }
											</td>
											<td>
												
												<a href="updateStudent.do">修改</a>
											</td>
											<td>
												<a href="deleteStudent.do?sno=${stu.sno }"
													onclick="return del();">删除</a>
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</table>


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

