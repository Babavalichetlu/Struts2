<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Execute and Wait interceptor</title>
</head>
<body>
<h2>Application is working successfully</h2>
<h2>
Login credential is <br>
Login Id : <s:property value="lid"/> and Password :
<s:property value="lpass"/>
</h2>
<a href="index.jsp">Try Again</a>
</body>
</html>