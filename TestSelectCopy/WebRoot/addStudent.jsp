<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<html>
	<head>
		<title>JSP for AddStudentForm form</title>

	</head>
	<body>
		<html:form action="/addStudent"> 
			psno&nbsp;&nbsp; : <html:text property="sno" />
			<html:errors property="sno" />
			<br />
			sname : <html:text property="sname" />
			<html:errors property="sname" />
			<br />  
			sex &nbsp; &nbsp;&nbsp; : <html:select property="sex">
				<html:option value="男生">男生</html:option>
				<html:option value="女生">女生</html:option>
			</html:select>

			<html:errors property="sex" />
			<br />  
			age&nbsp; &nbsp; &nbsp; : <html:text property="age" />
			<html:errors property="age" />
			<br />
			gname : <html:select property="gname">
					
				<logic:iterate id="g" name="gradelist">
					<html:option value="${g}"></html:option>
				</logic:iterate>
			</html:select>
			<html:errors property="gname" />
			<br />
			<html:submit />
			<html:reset />
		</html:form>
	</body>
</html>

