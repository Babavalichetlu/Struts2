<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
</head>
<body id="ID">
  <h3>Employee details</h3>
  <hr>
  Id : <s:property value="id" /><br> 
  Name : <s:property value="name" /><br> 
  Password1 : <s:property value="password1" /><br> 
  Password2 : <s:property value="password2" /><br> 
  Date of birth :<s:property value="dob" /><br>
  Salary : <s:property value="salary"/><br>
  City : <s:property value="city"/><br>
  Email : <s:property value="email"/><br>
  <hr>
  <a href="index.jsp">Try Again</a>
</body>
</html>