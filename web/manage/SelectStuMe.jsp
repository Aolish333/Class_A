<%@ page import="dao.StudentPakage" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Student" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/5
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>查询学生信息</title>
    <link href="/css/CSS.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="site-login-wrapper-test">
    <div class="header">
        <h2>
            查询学生信息
        </h2>
    </div>
    <center>
    <div class="login-form-test">
        <%/* request对象接受用户发来的请求，一次请求发生，request只能到一个页面 */%>
        <% request.setCharacterEncoding("utf-8");
            StudentPakage stu=new StudentPakage();
            List<Student> listall= new ArrayList<Student>();
            listall=stu.SelectUser();
            Iterator<Student> iter=listall.iterator();
        %>
        <table border="1" align="center">
            <tr>
                <td>用户名</td>
                <td>密码</td>
                <td>用户类型</td>
                <td>操作1</td>
                <td>操作2</td>
            </tr>
                <%//用于遍历输出，判断下一个元素是否可以得到 %>
                <% while(iter.hasNext()){
      Student S =iter.next();
    %>
            <tr>
                <td><%=S.getStudent_Name()%></td>
                <td><%=S.getStudent_Psd()%></td>
                <td><%=S.getStudent_User()%></td>
                <td><a href="DeleteStuMe.jsp?id=<%=S.getStudent_No()%>">删除用户</a></td>
                <td><a href="UpdateStuMe.jsp?Student_No=<%=S.getStudent_No()%>">修改用户</a></td>

            </tr>
                <%
        }
    %>
    </div>

    </center>
</div>

</body>
</html>
