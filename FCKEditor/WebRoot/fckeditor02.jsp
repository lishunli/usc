<!--fckeditor的JavaScript的第二种方法-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>fckeditor02</title>
		<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
		<script type="text/javascript">
			window.onload = function() 
			{
				var oFCKeditor = new FCKeditor('FCKeditor');
				oFCKeditor.BasePath = "fckeditor/";
				oFCKeditor.ReplaceTextarea();
			}
		</script>
	</head>
	<body>
		<textarea rows="10" cols="80" name="FCKeditor"></textarea>

	</body>
</html>