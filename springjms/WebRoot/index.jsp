<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="org.springframework.jms.core.JmsTemplate"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.jms.core.MessageCreator"%>
<%@page import="javax.jms.*"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

  <body>
    This is my JSP page. <br>
    <%
    ApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
    JmsTemplate jmsQueueTemplate=(JmsTemplate)ctx.getBean("jmsQueueTemplate");
    jmsQueueTemplate.send(new MessageCreator(){
       public Message createMessage(Session session) throws JMSException{
          return session.createTextMessage("Hello, I'am JMS!");
       }
    });
    out.println(ctx.getBean("RequestQueueDestination"));
    out.println(ctx.getBean("batch.jmsFactory"));


    %>
  </body>
</html>
