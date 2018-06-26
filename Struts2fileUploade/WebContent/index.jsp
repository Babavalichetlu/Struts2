<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>File Upload Interceptor Demo</title>
</head>
<body>
  <h2>Struts2 File Upload Interceptor Demo</h2>
  <s:actionerror/>
  <s:fielderror/>
  <s:form action="doUpload" method="POST" enctype="multipart/form-data">
    <s:file name="upload" label="File" />
    <s:textfield name="caption" label="Caption" />
    <s:submit/>
  </s:form>
</body>
</html>