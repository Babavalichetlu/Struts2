<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
	 <title>Struts 2 action interface implementation example</title>
	</head>
	<body>
	     <h3>This is a action interface implementation example.</h3>
 
		
 
		<s:form action="Login">
			<s:textfield name="userName" label="UserName" />
			<s:password name="password" label="Password" />
			<s:submit value="login" align="center"/>
		</s:form>
 
	</body>
</html>