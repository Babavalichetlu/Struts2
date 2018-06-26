<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>File Upload Interceptor</title>
</head>
<body>
<ul>
  <li>ContentType: <s:property value="uploadContentType" />
  </li>
  <li>FileName: <s:property value="uploadFileName" />
  </li>
  <li>File: <s:property value="upload" />
  </li>
  <li>Caption:<s:property value="caption" />
  </li>
    </ul>
  <h2>Application is working successfully</h2>
  <a href="index.jsp">Try Again</a>

</body>
</html>