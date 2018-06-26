<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Struts2 Alias interceptor</title>
<s:head />
<body>
<h2>Employee Details are<br/>
<hr>
Code : <s:property value="empCode" /><br>
Name : <s:property value="empName" /><br>
City : <s:property value="empCity" /><br>
Salary : <s:property value="empSalary" /><br>
</h2>
<a href="index.jsp">Try Again</a>
</body>
</html>