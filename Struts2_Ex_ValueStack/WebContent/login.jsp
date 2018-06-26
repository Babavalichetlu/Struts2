<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>Struts 2 ValueStack example</title>
	</head>
	<body>
		<h3>This is a ValueStack example.</h3>
 
		<s:form action="baba">
		 <s:textfield name="userName" label="UserName" />
		 <s:submit value="Hello" align="center"/>
		</s:form>
 
	</body>
</html>