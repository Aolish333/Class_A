<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/5/31
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老师教师界面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
    session .setAttribute("course",request.getParameter("course")
    );
%>
    <center>
    <h2><a href="showlist.jsp">管理学生</a></h2>
</center>
<jsp:include page="footer.jsp"/>
</body>
</html>
