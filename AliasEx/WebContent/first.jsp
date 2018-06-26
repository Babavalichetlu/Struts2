<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<%@taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8">
        <title> Main Page </title>
    </head>
    <body>
      <s:form action = "click" method = "POST">
         <h1> Student Score Management System </h1>
         <hr/>
        <s:label value = "Student ID"/>
        <s:textfield name = "sid"/>
 
        <s:label value = "Student Name"/>
        <s:textfield name = "sname"/>
 
        <s:label value = "Score of Test 1"/>
        <s:textfield name = "marks1"/>
 
        <s:label value = "Score of Test 2"/>
        <s:textfield name = "marks2"/>
 
        <s:label value = "Score of Test 3"/>
        <s:textfield name = "marks3"/>
 
        <s:submit value = "Get Score" name = "submit" />
 
       </s:form>
    </body>
</html>