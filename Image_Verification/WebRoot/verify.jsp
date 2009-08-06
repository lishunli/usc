<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--		链接外部的js文件-->
		<script type="text/javascript" src="js/check.js"></script>
<script type="text/javascript">

function verify(){
    alert("<%= session.getAttribute("verify") %>");
}
</script>
</head>
<body>
验证码：<input type="text" id="verify"/>
<img src="ImageServlet" onclick="javascript:this.src='ImageServlet?id='+  Math.random();" alt="看不清换一个,请点我">
<font color="red"><span id="verifyresult"></span></font>
<input type="button" value="验证" onclick="verify();"/>
</body>
</html>