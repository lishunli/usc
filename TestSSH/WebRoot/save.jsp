<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>Save User</title>
		


	<script type="text/javascript">
	function del()
	{
		if(confirm("你真的想删除该记录么？"))
		{
			return true;
		}
		return false;
	}
	</script>

	</head>
	

	
	<body>

		<h1>
			<font color="red">Save User</font>
		</h1>
		<s:action name="UsersAction" id="UsersAction"/>  
	
		<s:form action="saveUser">
			<s:textfield name="user.firstname" label="%{getText('firstname')}"></s:textfield>
			
			<s:select list="{'m','w'}" name="sex" label="sex"></s:select>
			<s:select list="#UsersAction.users" name="mz" label="mz"></s:select>
			<s:textfield name="user.lastname" label="%{getText('lastname')}"></s:textfield>
			<s:textfield name="user.age" label="%{getText('age')}"></s:textfield>
			<s:submit value="%{getText('submit')}"></s:submit>

		</s:form>

	</body>
</html>
