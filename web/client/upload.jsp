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
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>

    <form method="post" action="/web/UpLoadServlet?id=1;" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    提交实验报告:
                </td>
                <td>
                    <input type="file" name="uploadFile" />
                </td>
                <td>
                    <input type="submit" value="上传" />
                </td>
            </tr>
        </table>
    </form>

    <form method="post" action="/web/UpLoadServlet?id=2" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    提交作业:
                </td>
                <td>
                    <input type="file" name="uploadFile" />
                </td>
                <td>
                    <input type="submit" value="上传" />
                </td>
            </tr>
        </table>
    </form>

</center>
</body>
</html>
