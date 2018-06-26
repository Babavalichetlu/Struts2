<%@ page session="false"%>
<%@page import="org.myorg1.example1.core.HelloService"%>
<%@ taglib prefix="sling"
	uri="http://sling.apache.org/taglibs/sling/1.0"%>
<sling:defineObjects />

<%
HelloService helloService = sling.getService(org.myorg1.example1.core.HelloService.class);
%>

<div>component 2 uses the HelloService:</div>
<div>
	HelloService says:
	<%=helloService.getMessage()%></div>