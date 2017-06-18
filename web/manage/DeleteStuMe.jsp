<%@ page import="dao.StudentPakage" %>
<%@ page import="domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/6
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除学生信息</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />

</head>
<body>
<p align="center"><b><font size="25px" color="black">删除学生信息</font></b></p>
</b></b></b>
<%--<%=request.getParameter("id")%>--%>
<%
    StudentPakage stu=new StudentPakage();
    Student S=new Student();
    S.setStudent_No(request.getParameter("id"));
    stu.DeleteUser(S);
%>

</body>
</html>
