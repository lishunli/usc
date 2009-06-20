<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
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
	
	function update()
	{
		if ("<%= session.getAttribute("login") %>" == "null") {   
    		alert("需要登陆才能修改学生,请登录");   
		} 
		
	}
		
	function topPage() {
		window.self.location = "listAllStudent.do?pageNo=1"
	}
	
	function previousPage() {
		window.self.location = "listAllStudent.do?pageNo=${pageModel.pageNo-1}"
	}	
	
	function nextPage() {
		window.self.location = "listAllStudent.do?pageNo=${pageModel.pageNo+1}"
	}
	
	function bottomPage() {
		window.self.location = "listAllStudent.do?pageNo=${pageModel.totalPages}"
	}	
	function selectPageNo() {
		//dim i = document.getElementById("selectPageNo").value
		//alert(document.getElementById("selectPageNo").value);
		window.self.location = "listAllStudent.do?pageNo=" + document.getElementById("selectPageNo").value;
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
						<p align="right"> 
						学生信息导出为 &nbsp; <a href="excel.do">Excel</a>&nbsp;&nbsp; 或 &nbsp; <a href="pdf.do">PDF</a>
						</p>
						<c:choose>
							<c:when test="${empty login}">
								<p align="right">
									<a href="login.jsp">登录</a>
								</p>
								
							</c:when>
							<c:otherwise>
								<p align="right">
									<a href="loginOut.do">注销登录</a>
								</p>
							</c:otherwise>
						</c:choose>
						<br><br>

						

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
												
												<a href="updatePStudent.do?sno=${stu.sno }" onclick="return update();">修改</a>
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
 <table width="45%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      <td  height="2" width="60%"> <div align="left">
当前页：${pageModel.pageNo }
&nbsp;&nbsp;
总页数：${pageModel.totalPages }
&nbsp;&nbsp;
<input name="btnTopPage"  type="submit" id="btnTopPage" value="转到第"  title="转到，输入错误转到第一页" onClick="selectPageNo()">
<input name="selectPageNo" type="text" id="selectPageNo" size="3" maxlength="3"/>页
</div></td>
      <td  width="40%" > <div align="right">
        <input name="btnTopPage"  type="button" id="btnTopPage" value="|&lt;&lt; "  title="首页" onClick="topPage()">
        <input name="btnPreviousPage" type="button" id="btnPreviousPage" value=" &lt;  "  title="上一页" onClick="previousPage()">
        <input name="btnNext"  type="button" id="btnNext" value="  &gt; "  title="下一页" onClick="nextPage()">
        <input name="btnBottomPage"  type="button" id="btnBottomPage" value=" &gt;&gt;|"  title="尾页" onClick="bottomPage()">
        </div></td>
    </tr>
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

