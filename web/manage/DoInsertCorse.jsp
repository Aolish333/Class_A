<%@ page import="domain.Course" %>
<%@ page import="dao.Package" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/7
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程处理页</title>
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
            注册成功
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <%--<p align="center"><b><font size="25px" color="black">注册成功</font></b></p>--%>
            </b></b></b>
            <%  request.setCharacterEncoding("utf-8");
                Package C=new Package();
                Course S=new Course();
                S.setCourse_Name(request.getParameter("X_Course_Name"));
                S.setCourse_Credit(request.getParameter("X_Course_Credit"));
                S.setCourse_Hours(request.getParameter("X_Course_Hours"));
                S.setCourse_Content(request.getParameter("X_Course_Content"));
                S.setCourse_Intro(request.getParameter("X_Course_Intro"));
                C.InsertCourse(S);
            %>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>
</body>
</html>
