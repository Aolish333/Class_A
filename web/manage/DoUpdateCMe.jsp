<%@ page import="domain.Course" %>
<%@ page import="dao.Package" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/9
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理修改课程表单页</title>
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
            修改用户信息
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <%--<p align="center"><b><font size="25px" color="black">修改用户信息</font></b></p>--%>
            </b></b></b>
            <%
                request.setCharacterEncoding("utf-8");
                Course C =new Course();
                C.setCourse_Name(request.getParameter("X_Course_Name"));
                C.setCourse_Content(request.getParameter("X_Course_Content"));
                C.setCourse_Intro(request.getParameter("X_Course_Intro"));
                C.setCourse_Credit(request.getParameter("X_Student_Credit"));
                C.setCourse_Hours(request.getParameter("X_Course_Hours"));
                C.setCourse_No(request.getParameter("X_Course_No"));
                Package P=new Package();
                P.UpdateUserId(C);
            %>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>
</body>
</html>
