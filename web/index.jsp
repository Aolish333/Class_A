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
    <title>登陆首页</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="site-login-wrapper">
    <div class="header">
        <h2>Login to
            <img src="image/font.png" alt="logo">
        </h2>
    </div>
    <div class="login-form">
        <form action="/web/AllLoginServlet" method="post">
            <ul class="form-content">
                <li class="login-items">
                    <span class="iconfont icon-yonghuming pics"></span><!--(矢量图库)-->
                    <input class="login-user" name="user" type="text" placeholder="IconDeposit">
                </li>
                <li class="login-items">
                    <span class="iconfont icon-mima pics"></span>
                    <input class="login-pwd" name="user_psw" type="password" placeholder="••••••••••••••">
                </li>
                <li class="login-items">
                    <span class="iconfont icon-mima pics"></span>
                    <select name="user_type" class="login-user">
                        <option value="student">学生</option>
                        <option value="teacher">老师</option>
                        <option value="admin">管理员</option>
                    </select>
                </li>
                <li class="login-items rmb">
                    <input id="checkbox" type="checkbox" checked>
                    <label class="square" for="checkbox"></label>
                    <label class="remember" for="checkbox">记住密码</label>
                </li>
                <li class="login-items rmb">
                    <a class="forget" href="">Forgot username or password?</a>
                </li>
                <li class="login-items">
                    <button type="submit" class="login-btn">Login</button>
                </li>
            </ul>
        </form>
    </div>
    <div class="footer">
    </div>
</div>
</body>
</html>
