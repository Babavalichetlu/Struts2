<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Insert title here</title>
<%-- <sx:head extraLocales="en-us" /> --%>
</head>
<body>
<h1>Enter Employee Details:</h1>
<s:form action="EmpRegAction" method="post">
<s:textfield label="Employee Id" name="eid" />
<s:textfield label="Employee Name" name="name" />
<s:textfield label="Employee City" name="city" />
<s:textfield label="Enter Email" name="email"/>
<%-- <sx:datetimepicker name="dob" label="Select DOB" displayFormat="dd-MMM-yyyy"/> --%>

<s:textfield label="Employee Salary" name="salary" value="0" />
<s:submit label="submit"/>
<s:reset label="reset" value="Reset" />
</s:form>
</body>
</html>