<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
	<head>
		<title>RegisterForm</title>
		<!--		链接外部的js文件-->
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/check.js"></script>
		<!--		链接外部的css文件-->
		<%--		<link type="text/css" rel="stylesheet" href="css/error.css" />--%>
	</head>
	<body>
		<form action="register.do" method="post">
			username :
			<input type="text" name="username" id="username"
				onblur="checkusername()" onfocus="cleanusernameerror()" />
			<font color="red">*<span id="checkusernameinfo"><html:errors
						property="username" /> </span> </font>
			<br>

			password :
			<input type="password" name="password" id="password"
				onblur="checkpassword()" onfocus="cleanpassworderror()" />
			<font color="red">* <span id="checkpasswordinfo"><html:errors
						property="password" /> </span> </font>

			<br>
			repassword :
			<input type="password" name="repassword" id="repassword"
				onblur="checkrepassword()" onfocus="cleanrepassworderror()" />
			<font color="red">* <span id="checkrepasswordinfo"><html:errors
						property="repassword" /> </span> </font>

			<br>
			<input type="submit" value="submit" id="submit" onclick="check()" />
			<%--			<input type="reset" value="reset"/>--%>
		</form>
	</body>
</html>

