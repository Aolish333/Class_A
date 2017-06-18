<%@ page import="dao.Package" %>
<%@ page import="domain.Course" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/7
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询课程信息</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
        #all {
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
            课程信息
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <%--<p align="center"><b><font size="25px" color="black">课程信息</font></b></p>--%>
            </b></b></b>
            <%/* request对象接受用户发来的请求，一次请求发生，request只能到一个页面 */%>
            <% request.setCharacterEncoding("utf-8");
                Package P = new Package();
                List<Course> listall = new ArrayList<Course>();
                listall = P.SelectUser();
                Iterator<Course> iter = listall.iterator();
            %>
            <table border="1" align="center">
                <tr>
                    <td>课程名</td>
                    <td>课程时长</td>
                    <td>课程学分</td>
                    <td>课程介绍</td>
                    <td>课程内容</td>
                    <td>操作一</td>
                    <td>操作二</td>
                </tr>
                    <%//用于遍历输出，判断下一个元素是否可以得到 %>
                    <% while(iter.hasNext()){
               Course C =iter.next();
    %>
                <tr>
                    <td><%=C.getCourse_Name()%>
                    </td>
                    <td><%=C.getCourse_Intro()%>
                    </td>
                    <td><%=C.getCourse_Hours()%>
                    </td>
                    <td><%=C.getCourse_Content()%>
                    </td>
                    <td><%=C.getCourse_Credit()%>
                    </td>
                    <td><a href="DeleteCMe.jsp?X_Course_No=<%=C.getCourse_No()%>">删除课程</a></td>
                    <td><a href="UpdateCMe.jsp?X_Course_No=<%=C.getCourse_No()%>">修改课程</a></td>

                </tr>
                    <%
        }
    %>
        </div>
    </center>
</div>
</body>
</html>



