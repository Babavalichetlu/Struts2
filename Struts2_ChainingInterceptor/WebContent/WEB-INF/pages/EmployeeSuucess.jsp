<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Employee Suucess Page</title>
</head>
<body>
<h2>Employee details from two Actions<br>
<hr/>
Employee Code :<s:property value="id"/><br>
Employee Name :<s:property value="name"/><br>
Employee City :<s:property value="city"/><br>
Employee Salary :<s:property value="salary"/><br>
<hr/>
<a href="index.jsp"> Try Again</a>
</h2>
</body>
</html>