<%@ page import="dao.TeacherPakage" %>
<%@ page import="domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/6/8
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生到课堂</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
    <style>
        .text{
            float: left;
            width: 100%;
        }
        #a{
            width: 50%;
            float: left;
        }
        #b{
            width: 50%;
            float: right;
        }
    </style>
</head>
<body>
<div class="site-login-wrapper-test">
    <div class="header">
        <h2>
管理学生
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <div class="text">
                <div class="" id="a">
                    添加学生
                    <%TeacherPakage teacherPakage=new TeacherPakage();%>
                    <%
                        request.setCharacterEncoding("utf-8");
                        List<Student> studentList = teacherPakage.TmanageS();
                    %>
                    <table border="1">
                        <tr>
                            <td>学号</td>
                            <td>姓名</td>
                            <td>操作</td>
                        </tr>
                        <%
                            for (Student student : studentList) {
                        %>
                        <tr>
                            <td><%=student.getStudent_No()%></td>
                            <td><%=student.getStudent_Name()%></td>
                            <td><a href="../web/AddStudentServlet?Student_No=<%=student.getStudent_No()%>">添加学生</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
                <div class="" id="b">
                    已添加的学生
                    <%
                        request.setCharacterEncoding("utf-8");
                        List<Student> stlist=teacherPakage.TS();
                    %>

                    <table border="1">
                        <tr>
                            <td>学号</td>
                            <td>姓名</td>
                        </tr>
                        <%
                            for (Student student : stlist) {
                        %>
                        <tr>
                            <td><%=student.getStudent_No()%></td>
                            <td><%=student.getStudent_Name()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>

</body>
</html>
