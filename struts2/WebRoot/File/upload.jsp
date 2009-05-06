<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>文件上传和下载</title>
</head>
<body>

	<form action="result.jsp" method="post" enctype="multipart/form-data">
<!--文件上传中一定需要method为post，enctype为multipart/form-data	enctype="multipart/form-data"-->
	Information: <input type="text" name="info"><br>
	File: <input type="file" name="file"><br>
	
	<input type="submit" name="submit" value=" submit ">
	
	</form>

</body>
</html>