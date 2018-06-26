<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>

</head>
<body>
<h2>Employee Registration - RequestAware Demo</h2>
<s:form action="EmployeeAction1" method="post">
<s:textfield label="Enter Code" name="code"/>
<s:textfield label="Enter Name" name="name"/>
<s:textfield label="Enter City" name="city"/>
<s:textfield label="Enter Salary" name="salary" value="0"/>
<s:submit label="Submit"/>
<s:reset label="Reset"/>
</s:form>
</body>
</html>