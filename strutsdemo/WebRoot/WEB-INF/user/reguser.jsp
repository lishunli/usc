<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fckeditor/fckeditor.js"></script>
  </head>
  
  <body>
  <html:link action="ChangeLocale.htm?language=en&country=US&page=/RegUserUI.htm">english</html:link>
 <html:link action="ChangeLocale.htm?language=zh&country=CN&page=/RegUserUI.htm">chinese</html:link>
 
  <hr>
	<%
		Date now = new Date();
		request.setAttribute("now",now);
		request.setAttribute("name","张孝祥")	;
		Map map = new HashMap();
		map.put("x","1");
		map.put("y","2");
		map.put("z","3");
		request.setAttribute("person",map);				
	 %>
   <a href="/strutsdemo/RegUser.do">注册（太差）</a>
   <a href="${pageContext.request.contextPath}/RegUser.do">注册（一般）</a>
   <html:link action="/RegUserUI">注册（很好）</html:link>
    <html:link action="/RegUserUI" paramId="username" paramName="name">注册（url编码）</html:link>  
    <html:link action="/RegUserUI" paramId="t" paramName="now" paramProperty="time">注册（对象属性url编码）</html:link>  
    <html:link titleKey="info.submit" bundle="xxx" action="/RegUserUI" name="person">注册（多个参数）</html:link>  
    <hr>
<%-- ${requestScope["org.apache.struts.action.ERROR"]} --%>
 <hr>
 <html:errors  property="password2"  header="" footer="" prefix="" suffix=""/> 
 <html:form action="/RegUser" focus="user.username" enctype="multipart/form-data">
 用户名：<html:text property="user.username" /><html:errors property="username" header="" footer="" prefix="" suffix=""/><br>
密码：<html:password property="user.password" value=""/><br>
确认密码：<html:password property="password2" value=""/><html:errors property="password2"  header="" footer="" prefix="" suffix=""/><br>
身高：<html:text property="user.height"/>
<fmt:formatDate value="${userForm.user.birthday}" pattern="yyyy-MM-dd" var="birthday"/><br>
生日：<html:text property="user.birthday" value="${birthday}"/><br>
<!-- 
爱好：   	<input type="checkbox" name="user.specialities" value="1">football
	<input type="checkbox" name="user.specialities" value="2">basketball	
	<input type="checkbox" name="user.specialities" value="3">ping-pong				
	<input type="checkbox" name="user.specialities" value="4">volleyball
	<input type="checkbox" name="user.specialities" value="5">baseball
	<input type="checkbox" name="user.specialities" value="6">tennis ball<br>
 -->
<!--  
爱好：   
<c:forEach items="${specialities}" var="speciality">
	<c:remove var="checked"/>
	<c:forEach items="${userForm.user.specialities}" var="hasSpeciality">
		<c:if test="${speciality.id==hasSpeciality}">
			<c:set var="checked" value='checked="checked"'/>
		</c:if>
	</c:forEach>
	<input type="checkbox" name="user.specialities" value="${speciality.id }" ${checked}>${speciality.name }	
</c:forEach>
--> 
 爱好：
 <c:forEach items="${specialities}" var="speciality">  
 	<html:multibox property="user.specialities" value="${speciality.id }"/>${speciality.name }
 </c:forEach>
 
<br>
<%-- 
<select name="user.gender">
	<c:forEach items="${genders}" var="gender">
		<option value="${gender.value}" ${userForm.user.gender.value==gender.value?'selected="selected"':""}>${gender.title}</option>
	</c:forEach>
</select>
--%>
<html:select property="user.gender">
	<html:optionsCollection name="genders" value="value" label="title"/>
</html:select>

<br>
<html:file property="user.photo" ></html:file><br>
你的简历：
<script type="text/javascript">
			<!--
			// Automatically calculates the editor base path based on the _samples directory.
			// This is usefull only for these samples. A real application should use something like this:
			// oFCKeditor.BasePath = '/fckeditor/' ;	// '/fckeditor/' is the default value.
			var sBasePath = document.location.href.substring(0,document.location.href.lastIndexOf('_samples')) ;
			
			var oFCKeditor = new FCKeditor( 'user.resume' ) ;
			oFCKeditor.BasePath	= "${pageContext.request.contextPath}/js/fckeditor/" ;
			oFCKeditor.Height	= 300 ;
			oFCKeditor.Value	= '${userForm.user.resume}' ;
			oFCKeditor.Create() ;
			//-->
</script>

<html:submit titleKey="info.submit" bundle="xxx"><bean:message key='info.submit' bundle='xxx'/></html:submit><html:checkbox property="autoLogon" ></html:checkbox>两星期自动登陆
<input type="checkbox" name="autoLogon" ${userForm.autoLogon?'checked="checked"':''} />
 </html:form >
 
 <hr>
 <html:errors  property="password2"  header="" footer="" prefix="" suffix=""/> 
<form action="<html:rewrite action="/RegUser"/>">
用户名：<input type="text" name="user.username" value="${userForm.user.username }"/><html:errors property="username" header="" footer="" prefix="" suffix=""/><br>
密码：<input type="password" name="user.password"  value="${userForm.user.password}"/><br>
确认密码：<input type="password" name="password2"  value="${userForm.password2 }"/><html:errors property="password2"  header="" footer="" prefix="" suffix=""/><br>
身高：<input type="text" name="user.height" value="${userForm.user.username }"/>
<input type="submit"  value="<bean:message key='info.submit' bundle='xxx'/>"/>
<html:submit titleKey="info.submit" ><bean:message key='info.submit' bundle='xxx'/></html:submit>
</form>


    <c:forEach items="${sessionScope}" var="oneAttr">
    	${oneAttr.key }----->${oneAttr.value  }<br>
    </c:forEach>
  </body>
</html>
