<%@ page import="dao.StudentPakage" %>
<%@ page import="domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/5
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户处理修改页</title>
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
            修改课程信息
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            </b></b></b>
            <%
                request.setCharacterEncoding("utf-8");
                Student usera=new Student();
                usera.setStudent_Name(request.getParameter("Student_Name"));
                usera.setStudent_Psd(request.getParameter("Student_Psd"));
                usera.setStudent_User(request.getParameter("Student_User"));
                usera.setStudent_No(request.getParameter("Student_No"));
                StudentPakage daoadoupdate=new StudentPakage();
                daoadoupdate.UpdateUserId(usera);
            %>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>
</body>
</html>
