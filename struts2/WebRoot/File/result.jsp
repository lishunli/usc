<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.io.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

<!--struts2中的default拦截器栈中含有uploadfile，对以下有影响，故此时先注释使用struts2-->
<% 
	InputStream is = request.getInputStream();

	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	
	String buffer = null;
	
	while((buffer = br.readLine()) != null)
	{
		out.print(buffer + "<br>");		
	}
%>

<!--Information: <%= request.getParameter("info")%><br>-->
<!--File:  <%= request.getParameter("file")%><br>-->






</body>
</html>