<%@taglib uri="/struts-tags" prefix="s"%><%@ page language="java"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>Employee details</h2>
Code : <s:property value="code" />
<br> Name : <s:property value="name" />
<br> City : <s:property value="city" />
<br> Salary : <s:property value="salary" />
<br>
<a href="index.jsp">Try Agaian</a>
</body>
</html>