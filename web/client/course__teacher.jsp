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
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
    session.setAttribute("course", request.getParameter("course"));
//    out.print(session.getAttribute("course"));
%>
<center>

    <div class="site-login-wrapper-test">
        <div class="ThreeDee">
            <h2>  课堂—教师</h2>
        </div>
        <div class="login-form-test">
            <h2><a href="showlist.jsp">管理学生</a></h2>
            <jsp:include page="/web/ShowTaskServlet"/>
            <jsp:include page="/ListenerPackage/LoginServlet"/>
        </div>
        <jsp:include page="/client/footer.jsp"/>
    </div>
</center>
</body>
</html>
