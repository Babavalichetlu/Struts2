<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Struts2 alias interceptor</title>
<s:head/>
<body>
<h2>Sum of Two values</h2>
<s:form action="sum" method = "POST">
<s:textfield name="x" label="Enter value 1"/>
<s:textfield name="y" label="Enter value 2"/>
<s:submit label="Submit"/>
</s:form>
</body>
</html>