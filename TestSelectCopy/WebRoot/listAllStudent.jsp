<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>JSP for ListAllStudentForm form</title>
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
							</tr>
							<c:choose>
								<c:when test="${empty studentlist}">
									<tr>
										<td colspan="5">
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

