<%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/7
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息界面</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />

    <style type="text/css">
        #all{
            width: 646px;
            height: 408px;
            margin-left: 350px;
            margin-right: 150px;
            /*background: url(/image/background4.jpg);*/
        }
    </style>
</head>
<body>
<div class="site-login-wrapper-test">
    <div class="header">
        <h2>
            课程信息界面
        </h2>
    </div>
    <center>
    <div class="login-form-test">
        <%--<p align="center"><b><font size="25px" color="black">课程信息界面</font></b></p>--%>
        <table align="center">
            <tr>
                <td> <a href="SelectCourseMe.jsp">查询课程信息</a>
                </td>
            </tr>
            <tr>
                <td> <a href="InsertCorseMe.jsp">添加课程信息</a></td>
            </tr>
        </table>
    </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>
</body>
</html>
