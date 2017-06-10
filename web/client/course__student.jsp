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
</head>
<body>
<%
    session.setAttribute("Course_No", request.getParameter("Course_No"));
%>
<jsp:include page="upload.jsp"/>
<jsp:include page="/ListenerPackage/LoginServlet"/>
<jsp:include page="footer.jsp"/>
</body>
</html>
