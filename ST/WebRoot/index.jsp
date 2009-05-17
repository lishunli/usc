<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for IndexForm form</title>
		<script type="text/javascript" language="javascript">
		function send(){
	document.forms[0].action="index.do?cmd=B"
	document.forms[0].submit()
		}
	
		</script>
	</head>
	<body>
		<html:form action="/index?cmd=A">
			uname : <html:text property="uname" /><html:errors property="uname"/><br/>
			upass : <html:text property="upass" /><html:errors property="upass"  /><br/>
			<html:submit property="login" value="login"/>
			<html:button property="reg"  value="reg" onclick="send()"></html:button>
			<html:button property="check"  value="check" onclick="JavaScript:location.href='check.do?cc=df'"></html:button>
		</html:form>
	</body>
</html>

