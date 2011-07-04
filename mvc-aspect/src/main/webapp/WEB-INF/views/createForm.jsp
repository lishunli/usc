<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<META  http-equiv="Content-Type"  content="text/html;charset=UTF-8">
		<title>Create Account</title>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
		<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
	</head>
	<body>
		<h1>
			User Login
		</h1>
		<div class="container">
			<div class="span-12 last">
				<form:form modelAttribute="user" action="user/login" method="post">
					<fieldset>
						<legend>
							User Login
						</legend>
						<p>
							<form:label for="username" path="username" cssErrorClass="error">username</form:label>
							<form:input path="username" />
							<form:errors path="username"></form:errors>
						</p>
						<p>
							<form:label for="password" path="password" cssErrorClass="error">password</form:label>
							<form:password path="password" />
							<form:errors path="password"></form:errors>
						</p>
						<p>
							<input type="submit" />
						</p>
					</fieldset>
				</form:form>
				<hr>
				<ul>
					<li>
						<a href="?locale=en_us">us</a> |
						<a href="?locale=en_gb">gb</a> |
						<a href="?locale=es_es">es</a> |
						<a href="?locale=de_de">de</a>
					</li>
				</ul>
			</div>
	</body>
</html>