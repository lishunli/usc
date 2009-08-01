<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>show</title>
		<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
		<script type="text/javascript">
	window.onload = function() {
		var oFCKeditor = new FCKeditor('show');
		oFCKeditor.BasePath = "fckeditor/";
		oFCKeditor.Height = 600;
		oFCKeditor.ToolbarSet = "Simple";
		oFCKeditor.ReplaceTextarea();
	}
</script>
	</head>
	<body>
		<%
		//解决提交后的中文乱码问题
			request.setCharacterEncoding("UTF-8");
		 %>
		<textarea rows="10" cols="80" name="show" readonly="readonly" >${param.FCKeditor01 }</textarea>
	</body>
</html>