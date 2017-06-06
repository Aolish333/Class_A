<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/4
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传测试</title>
</head>
<body>
<form action="..web/UploadServlet" method="post">
    选择文件<input type="file" name="file1" id="file1"/>
    <input type="submit" name="upload" value="上传">
</form>
<%--<center>--%>
    <%--<form action="../web/GetImageServlet" method="post">--%>
        <%--选择图片：<input type="file" name="image"/><br/><br/>--%>
        <%--<input type="submit" value=" 提 交 "/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value=" 重 置 "/>--%>
    <%--</form>--%>
<%--</center>--%>
</body>
</html>
