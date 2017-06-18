<%@ page import="dao.StudentPakage" %>
<%@ page import="domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/5
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册处理页</title>
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
            <% request.setCharacterEncoding("utf-8"); %>
            <%StudentPakage stu=new StudentPakage();
                Student S=new Student();
                S.setStudent_Name(request.getParameter("X_Student_Name"));
                S.setStudent_Psd(request.getParameter("X_Student_Psd"));
                S.setStudent_User(request.getParameter("X_Student_User"));
                stu.InsertUser(S);
            %>
            添加成功<br>
            <a href="../index.jsp
">进入登陆页面</a>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>

</body>
</html>
