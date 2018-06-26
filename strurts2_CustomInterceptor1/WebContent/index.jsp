<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<s:form action="user">
		<s:textfield name="name" label="Enter your name" />
		<s:submit name="submit" label="Print my name" />
	</s:form>
</body>
</html>