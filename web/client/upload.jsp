<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/8
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<center>
<form method="post" action="/web/UpLoadServlet" enctype="multipart/form-data">
    提交实验报告:
    <input type="file" name="uploadFile" />
    <input type="submit" value="上传" />
</form>
</center>
</body>
</html>
