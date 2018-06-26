<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Debuging Interceptor Example</h2>
<s:form action="EmpDebugAction.action" method="get">
<s:hidden name="debug" value="browser"></s:hidden>
<s:textfield label="Enter Code" name="code" />
<s:textfield label="Enter Name" name="name" />
<s:textfield label="Enter City" name="city" />
<s:textfield label="Enter Salary" name="salary" value="0" />
<s:submit label="Submit" />
<s:reset label="Reset" />
</s:form>
</body>
</html>