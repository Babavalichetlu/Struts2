<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Logger Interceptor Demo</title>
</head>
<body>
<h2>Logger Interceptor Demo</h2>
<s:form action="Login" method="post">
<s:textfield name="lid" label="Login Id" />
<s:textfield name="lpass" label="Password" />
<s:submit value="Login" name="submit"/>
<s:reset value="Reset"/>
</s:form>
</body>
</html>


