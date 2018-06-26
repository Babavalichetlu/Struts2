<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<body>
<h3>Validation through XML</h3>    
     <b>Enter Employee Details</b>
        <s:form action="EmployeeAction">        
        <s:textfield label="Enter id" name="id"/>
        <s:textfield label="Enter Name" name="name"/>
  <s:password label="Enter Password" name="password1"/>
  <s:password label="Re-Enter Password" name="password2"/>
        <s:textfield label="Enter DOB" name="dob"/>
        <s:textfield label="Enter Salary" name="salary" value="0"/>
        <s:textfield label="City" name="city"/>
        <s:textfield label="Enter eMail" name="email"/>
  <s:submit value="Register Employee"/>
        </s:form> 
</body>
</html>