<!--fckeditor的JavaScript的第一种方法-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>fckeditor01</title>
		<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
	</head>
	<body>
<form action="show.jsp" method="post" target="_blank">
		<script type="text/javascript">
			var oFCKeditor = new FCKeditor('FCKeditor01');
			oFCKeditor.BasePath = "fckeditor/";
			oFCKeditor.Height	= 600 ;
			//或者下面的写法，上面的是相对路径
			//oFCKeditor.BasePath = "/FCKEditor/fckeditor/";
			//配置 fckeditor,在这配置的时候是局部配置，仅这个fckeditor都能产生效果
			//oFCKeditor.Config["CustomConfigurationsPath"] = "/FCKEditor/fckeditorconfig.js" ;
			oFCKeditor.ToolbarSet="MyFCK";
			oFCKeditor.Create();
		</script>
<br>
<input type="submit" value="Submit">
</form>
	</body>
</html>