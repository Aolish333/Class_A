<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/4/9
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../lib/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="S A Bokhari">
    <meta name="description" content="Slide In/Out Navigation">
    <meta name="keywords" content="Slide In/Out Navigation">
    <title>管理中心</title>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
        }

        body {
            font-family: sans-serif;
            overflow: hidden;
        }

        a {
            text-decoration: none;
            color: #00A5CC;
        }

        li {
            list-style-type: none;
        }

        header {
            width: 100%;
            height: 50px;
            margin: auto;
            border-bottom: 1px solid #EEE;
        }

        #brand {
            float: inherit;
            line-height: 50px;
            color: #E5DAC0;
            font-size: 25px;
            font-weight: bolder;
        }

        nav {
            width: 100%;
            text-align: center;
        }

        nav a {
            display: block;
            padding: 15px 0;
            border-bottom: 1px solid #C3AA6E;
            color: #F0EADC;
        }

        nav a:hover {
            background: #E5DAC0;
            color: #FFF;
        }

        nav li:last-child a {
            border-bottom: none;
        }

        /*-----------------------------------------*/
        .menu {
            width: 240px;
            height: 100%;
            position: absolute;
            background: #D9C9A3;
            left: -240px;
            transition: all .3s ease-in-out;
            -webkit-transition: all .3s ease-in-out;
            -moz-transition: all .3s ease-in-out;
            -ms-transition: all .3s ease-in-out;
            -o-transition: all .3s ease-in-out;

        }

        .menu-icon {
            padding: 10px 20px;
            background: #E5DAC0;
            color: #987D3E;
            cursor: pointer;
            float: right;
            margin-top: 4px;
            border-radius: 5px;
        }

        #menuToggle {
            display: none;
        }

        #menuToggle:checked ~ .menu {
            position: absolute;
            left: 0;
        }

        /*.content{*/
        /*width:100%;*/
        /*height: 200px;*/
        /*text-align: center;*/
        /*line-height: 200px;*/
        /*font-size:200px;*/
        /*background: pink;*/
        /*margin-bottom: 20px;*/
        /*display: none;*/
        /*}*/
    </style>
    <script type="text/javascript">
        $(function () {
            $(".first").click(function () {
                $(".con_1").css("display", "block");
                $(".con_2").css("display", "none");
            });
            $(".two").click(function () {
                $(".con_1").css("display", "none");
                $(".con_2").css("display", "block");
            });
        })

    </script>
</head>

<body>

<input type="checkbox" id="menuToggle">
<label for="menuToggle" class="menu-icon">&#9776;</label>

<header>
    <div id="" align="left">
        <center>
        <div align="right">
            你好，<u><%=session.getAttribute("admin_start")%></u>，欢迎回来！
        </div>
        </center>
    </div>
</header>

<nav class="menu">
    <ul>
        <li><a class="first" href="#">用户管理</a></li>
        <li><a class="two" href="#">课程管理</a></li>
    </ul>
</nav>

<div class="con_1 content " align="center">
    <jsp:include page="StudentMessage.jsp"/>
</div>
<div class="con_2 content" align="center" style="display:none">
    <jsp:include page="CourseMessage.jsp"/>
</div>
</body>
</html>
