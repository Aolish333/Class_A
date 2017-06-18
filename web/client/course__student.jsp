<%@ page import="domain.Course" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/5/31
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生教室界面</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
    <style>
        .ThreeDee {
            text-align: center;
            font-family: 'Microsoft YaHei';
            line-height: 1em;
            color: #fff9d6;
            font-weight:bold;
            font-size: 25px;
            text-shadow:0px 0px 0 rgb(197,197,197),1px 1px 0 rgb(169,169,169),2px 2px 0 rgb(141,141,141),3px 3px 0 rgb(113,113,113), 4px 4px 0 rgb(85,85,85),5px 5px 4px rgba(0,0,0,0.4),5px 5px 1px rgba(0,0,0,0.5),0px 0px 4px rgba(0,0,0,.2);}
    </style>
</head>
<body>
<%
    session.setAttribute("Course_No", request.getParameter("Course_No"));
%>
<div class="site-login-wrapper-test">
    <div class="ThreeDee">
        <h2>
            学生课堂
        </h2>
    </div>
    <center>
    <div class="login-form-test">
        <jsp:include page="upload.jsp"/>
        <jsp:include page="/ListenerPackage/LoginServlet"/>
    </div>
    <div id="footer">
        <jsp:include page="../client/footer.jsp"/>
    </div>
    </center>
</div>

</body>
</html>
