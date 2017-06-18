<%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/7
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程信息</title>
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
<% request.setCharacterEncoding("utf-8"); %>
<head>
    <title>Title</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="site-login-wrapper-test">
    <div class="header">
        <h2>
            添加课程页面
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <form action="DoInsertCorse.jsp" method="post">
                <%--<p align="center"><b><font size="25px" color="black">添加课程页面</font></b></p>--%>
                </b></b></b>
                <table align="center">
                    <tr>
                        <td>课程名:</td>
                        <td><input type="text" name="X_Course_Name" value=""></td>
                    </tr>
                    <tr>
                        <td>课程时长:</td>
                        <td><input type="text" name="X_Course_Hours" value=""></td>
                    </tr>
                    <tr>
                        <td>课程学分:</td>
                        <td><input type="text" name="X_Course_Credit" value=""></td>
                    </tr>
                    <tr>
                        <td>课程介绍:</td>
                        <td><textarea name="X_Course_Intro" cols="50" rows="3" value=""></textarea></td>
                    </tr>
                    <tr>
                        <td>课程内容:</td>
                        <td><textarea name="X_Course_Content" cols="50" rows="3" value=""></textarea></td>
                    </tr>
                    <tr align="center">
                        <td colspan="3"> <input type="submit" value="确认添加">
                            <input type="reset" value="取消"></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>
</body>
</html>
