<!--fckeditor的Taglib的使用方法-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>fckeditor03</title>
	</head>
	<body>
		<FCK:editor instanceName="FCKEditor" basePath="/fckeditor"></FCK:editor>
	</body>
</html>