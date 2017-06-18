<%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/5
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息表</title>
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
            用户信息界面
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <%--<p align="center"><b><font size="25px" color="black">用户信息界面</font></b></p>--%>
            </b></b></b>

            <table align="center">
                <tr>
                    <td> <a href="SelectStuMe.jsp">查询用户信息</a>
                    </td>
                </tr>
                <tr>
                    <td> <a href="InsterStuMe.jsp">添加用户信息</a></td>
                </tr>
            </table>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>
</body>
</html>
