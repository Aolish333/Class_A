<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/5/29
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        .login_in {;
            background-color: moccasin;
            width: 300px; /*元素的宽度*/
            height: 260px; /*元素的高度*/
            position: absolute;
            left: 50%; /*配合margin-left的负值实现水平居中*/
            margin-left: -100px; /*值的大小等于元素宽度的一半*/
            top: 50%; /*配合margin-top的负值实现垂直居中*/
            margin-top: -100px; /*值的大小等于元素高度的一半*/
        }
    </style>
</head>
<body>
<form action="web" method="post" class="login_in">

    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <h1>用户登陆</h1>
    <table>
        <tr>
            <td>用户名：</td>
            <td><input style="text" name="user"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input style="password" name="user_psw"></td>
        </tr>
        <tr>
            <td>类型：</td>
            <td><input type="radio" name="user_type" value="student">学生
                <input type="radio" name="user_type" value="teacher">老师
                <input type="radio" name="user_type" value="admin">管理员
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="重置"</td>
        </tr>
        <tr>
            <td><a href="#">忘记密码？</a><br></td>
            <td><a href="#">老师学生注册</a></td>
        </tr>
    </table>
</form>
</body>
</html>
