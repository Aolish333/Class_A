<%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/5
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户信息</title>
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
<div class="site-login-wrapper-test">
    <div class="header">
        <h2>
            注册用户页面
        </h2>
    </div>
    <div class="login-form-test">
        <center>
        <form action="DoInsertStuMe.jsp" method="post">
            <%--<p align="center"><b><font size="25px" color="black">注册用户页面</font></b></p>--%>
            </b></b></b>
            <table align="center">
                <tr>
                    <td>用户：</td>
                    <td><input type="text" name="X_Student_Name" value=""></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="X_Student_Psd" value=""></td>
                </tr>
                <tr>
                    <td>用户类型:</td>
                    <td><select name="X_Student_User">
                        <option value="学生">学生</option>
                        <option value="教师">教师</option>
                    </select>
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="3"><input type="submit" value="注册">
                        <input type="reset" value="取消"></td>
                </tr>
            </table>
        </form>
        </center>
    </div>
    <jsp:include page="/client/footer.jsp"/>
</div>

</body>
</html>
