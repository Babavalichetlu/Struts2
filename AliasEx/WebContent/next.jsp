<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8">
        <title> Details Page </title>
    </head>
    <body>
        <h1> Details of student:       </h1>
        <hr/>
        <h4>
          Student ID : <s:property value = "studentid"/>
        </h4> 
        <h4>
          Student Name: <s:property value = "studentname"/>
        </h4>
        <h4>
         Student Average Score: <s:property value = "answer"/>
        </h4>
    </body>
</html>