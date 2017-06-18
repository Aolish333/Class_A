<%@ page import="domain.Student" %>
<%@ page import="dao.StudentPakage" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: shihuanting
  Date: 2017/6/5
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
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
            修改用户信息
        </h2>
    </div>
    <center>
        <div class="login-form-test">
            <%
                request.setCharacterEncoding("utf-8");
                Student user=new Student();
                user.setStudent_No(request.getParameter("Student_No"));
                StudentPakage dao=new StudentPakage();
                List<Student> listall=new ArrayList<Student>();
                listall=dao.SelectUserId(user);
                for(Student usera:listall){
            %>

            <form action="DoUpdateStu.jsp?Student_No=<%=usera.getStudent_No()%>" method="post">
                <%--<p align="center"><b><font size="25px" color="black">修改用户信息</font></b></p>--%>
                </b></b></b>
                <table align="center">
                    <tr><td>用户名：</td>
                        <td><input type="text" name="Student_Name" value="<%=usera.getStudent_Name()%>"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="text" name="Student_Psd" value="<%=usera.getStudent_Psd()%>"></td>
                    </tr>
                    <tr>
                        <td>用户类型：</td>
                        <td><select name="Student_User">
                            <option value="管理员">管理员</option>
                            <option value="学生">学生</option>
                            <option value="教师">教师</option>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="确认修改">
                            <input type="reset" value="取消"></td>
                    </tr>
                </table>
            </form>
            <% } %>

        </div>
    </center>
    <jsp:include page="/client/footer.jsp"/>
</div>



</body>
</html>
