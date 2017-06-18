<%@ page import="dao.Package" %>
<%@ page import="domain.Course" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/7
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除课程信息</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />

</head>
<body>
<%
    Package P=new Package();
    Course C=new Course();
    C.setCourse_No(request.getParameter("X_Course_No"));
    P.DeleteCourse(C);
%>
</body>
</html>
