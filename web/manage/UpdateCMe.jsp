<%@ page import="domain.Course" %>
<%@ page import="dao.Package" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/9
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改表单页</title>
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
        <%
    request.setCharacterEncoding("utf-8");
    Course C=new Course();
    C.setCourse_No(request.getParameter("X_Course_No"));
    Package P=new Package();
    List<Course> listall=new ArrayList<Course>();
    listall=P.SelectUserId(C);
    for(Course usera:listall){
%><div id="all">
    <form action="DoUpdateCMe.jsp?X_Course_No=<%=usera.getCourse_No()%>" method="post">
        <p align="center"><b><font size="25px" color="black">修改课程信息</font></b></p>
        </b></b></b>
        <table align="center">
            <tr>
                <td>课程名:</td>
                <td><input type="text" name="X_Course_Name"  value="<%=usera.getCourse_Name()%>"></td>
            </tr>
            <tr>
                <td>课程时长:</td>
                <td><input type="text" name="X_Course_Hours" value="<%=usera.getCourse_Hours()%>"></td>
            </tr>
            <tr>
                <td>课程学分:</td>
                <td><input type="text" name="X_Student_Credit" value="<%=usera.getCourse_Credit()%>"></td>
            </tr>
            <tr>
                <td>课程介绍:</td>
                <td><textarea  name="X_Course_Intro" cols="50" rows="3" wrap="hard"  ><%=usera.getCourse_Intro()%></textarea></td>
            </tr>
            <tr>
                <td>课程内容:</td>
                <td><textarea name="X_Course_Content" cols="50" rows="3" wrap="hard" ><%=usera.getCourse_Content()%></textarea></td>
            </tr>
            <tr align="center">
                <td colspan="3"> <input type="submit" value="确认修改">
                    <input type="reset" value="取消"></td>
            </tr>
        </table>
    </form>
        <% } %>


</div>
    </body>
</html>
