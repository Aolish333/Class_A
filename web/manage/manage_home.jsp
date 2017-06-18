<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/5/31
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>管理员界面</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        #container {
            width: 1002px;
            background-image: url(/image/background7.jpg);
            margin: 0px auto;
        }

        #nav {
            height: 128px;

        }

        #nav ul {
            list-style: none;

        }

        #nav1 li {
            width: 100px;
            float: left;
            margin: 100px auto;
        }

        #nav1 {
            margin-top: 10px;
            margin-left: 100px;
        }

        #nav1 a {
            color: black;
            text-decoration: none;
        }

        #header {
            height: 150px;
            width: 1300px;
            background-color: red;
        }

        #main {
            width: 1300px;
            height: 410px;
        }

        #footer {
            width: 1300px;
            height: 100px;
            float: right;
        }

        #leftside {
            width: 892px;
            height: 400px;
            float: left;
            border: 2px black solid;
        }

        #rightside {
            width: 400px;
            height: 400px;
            float: left;
            border: 2px black solid;
        }

        .four {
            width: 422px;
            height: 178px;
            float: left;
            border: 1px black solid;
            margin: 10px;
        }

        #leftimage {
            width: 250px;
            height: 145px;
            float: left;
            margin-left: 20px;
            margin-right: 50px;
            margin-top: 17px;
        }

        #ul {
            line-height: 100px;
        }

        #a {
            text-decoration: none;
        }
    </style>
</head>
    </body>
    <div id="container">
        <div id="nav">
            <ul id="nav1">
                <li><a href="StudentMessage.jsp">用户管理</a></li>
                <li><a href="CourseMessage.jsp">课程管理</a></li>
            </ul>
        </div>
    </div>

</html>
