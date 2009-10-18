<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.*,org.usc.ejb3.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try
{
	//3.获得上下文环境
//	InitialContext ctx= new InitialContext(props);
	InitialContext ctx= new InitialContext();
	//4.通过JNDI获得接口代理
	IHelloWorldLocal helloWorld = (IHelloWorldLocal)ctx.lookup("HelloWorldBean/local");
	out.println(helloWorld.sayHello("Local : ShunLi Lee"));
} catch (NamingException e)
{
	// TODO Auto-generated catch block
	out.println(e.getMessage());
}
%>
</body>
</html>