<%@ taglib  uri="/struts-tags" prefix="s"%>  
<html>  
<body>  
<h1>Registration Form.............</h1>  
  
<s:form action="register">  
<s:textfield name="name" label="Username"></s:textfield>  
<s:textfield name="email" label="Email ID"></s:textfield>  
<s:password name="password" label="Password"></s:password>  
<s:submit validate="true" type="image" src="register-now.jpg">  
</s:submit>  
</s:form>  
  
</body>  
</html>  