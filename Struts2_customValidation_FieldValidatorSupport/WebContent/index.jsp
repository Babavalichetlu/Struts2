<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custom validation demo</title>
<style>
<!--
.errorMessage{
color:red;
}
-->
</style>
</head>
<body>
<s:form action="submitform"  method="post">
	<s:textfield name="username" label="User Name"/>
	<s:textfield name="email" label="Email "/>
	<s:submit />
</s:form>

<s:debug></s:debug>
</body>
</html>