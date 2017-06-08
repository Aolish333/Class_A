<%@ page import="dao.TeacherPakage" %>
<%@ page import="domain.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2017/6/6
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理学生</title>
    <style type="text/css">
        #all{
            align-content: center;
            float: left;
            width: 50%;
        }
        #left{
            width: 100%;
            /*vertical-align: middle;*/
        }
        #right{
            width:100%;
            text-align: center;
            /*border: 1px solid #EEE;*/
            /*vertical-align: middle;*/
        }
    </style>
</head>
<body>
<%TeacherPakage teacherPakage=new TeacherPakage();%>
<div id="all">
    <div id="left">
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
            <%--<%--%>
                <%--for (Student student : studentList) {--%>
            <%--%>--%>
            <%--<tr>--%>
                <%--<td><%=student.getStudent_No()%></td>--%>
                <%--<td><%=student.getStudent_Name()%></td>--%>
                <%--<td><a href='add_student_to_course.jsp'>添加学生</a></td>--%>
            <%--</tr>--%>
            <%--<%--%>
                <%--}--%>
            <%--%>--%>
        </table>
    </div>
    <div id="right">
        <%
            request.setCharacterEncoding("utf-8");
            List<Student> stlist=teacherPakage.TS();
        %>

        <table border="1">
            <tr>
                <td>学号</td>
                <td>姓名</td>
            </tr>
            <%--<%--%>
                <%--for (Student student : stlist) {--%>
            <%--%>--%>
            <%--<tr>--%>
                <%--<td><%=student.getStudent_No()%></td>--%>
                <%--<td><%=student.getStudent_Name()%></td>--%>
            <%--</tr>--%>
            <%--<%--%>
                <%--}--%>
            <%--%>--%>
        </table>
    </div>
</div>
</body>
</html>