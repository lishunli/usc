<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>简易计算器</title>
</head>
<body>
	<h1>简易计算器</h1>
	<hr>
	<form action="action/cal" method="post">
		<input type="text" name="value1">
		<select name="flag">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		<input type="text" name="value2">
		<input type="submit" value="=">
	</form>
</body>
</html>