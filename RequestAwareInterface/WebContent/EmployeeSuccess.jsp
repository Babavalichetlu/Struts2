<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Employee Suucess Page</title>
</head>
<body>
<h2>
Employee details are from Request object<br>
<hr>
<s:property value="#request.msg" />
<br> Code :
<s:property value="#request.code" />
<br> Name :
<s:property value="#request.name" />
<br> City :
<s:property value="#request.city" />
<br> Salary :
<s:property value="#request.salary" />
<br>
<hr>
<a href="index.jsp"> Try Again</a>
</h2>
</body>
</html>