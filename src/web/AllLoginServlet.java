package web;

import dao.AdminPackage;
import dao.StudentPakage;
import dao.TeacherPakage;
import domain.Admin;
import domain.Student;
import domain.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

/**
 * Created by hp on 2017/6/7.
 */
@WebServlet(name = "AllLoginServlet" ,urlPatterns ="/web/AllLoginServlet")
public class AllLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResultSet resultSet = null;
        String user = request.getParameter("user");
        String user_psw = request.getParameter("user_psw");
        String type = request.getParameter("user_type");
        out.print(type);

//        HttpSession session = req.setAttribute("user",username);
        //用session进行传值
        request.getSession().setAttribute("user", user);
        if (type.equals("student")) {
            Student student = new Student();
            student.setStudent_User(user);
            student.setStudent_Psd(user_psw);
            StudentPakage studentPakage = new StudentPakage();
            resultSet = studentPakage.DoLogin(student);
            if (resultSet != null) {
                out.print("登陆" + student.getStudent_User() + "成功...");
                //学生登陆成功
                response.setHeader("refresh", "3,URL=/web/ObtainClassByStudent");
            }
        } else if (type.equals("teacher")) {
            Teacher teacher = new Teacher();
            teacher.setTeacher_User(user);
            teacher.setTeacher_Pwd(user_psw);
            TeacherPakage teacherPakage = new TeacherPakage();
            resultSet = teacherPakage.DoLogin(teacher);
            if (resultSet != null) {
                out.print("登陆" + teacher.getTeacher_User() + "成功...");
                //学生登陆成功
                response.setHeader("refresh", "3,URL=ObtainClassByTeacher");
            }
        } else if (type.equals("admin")){
            Admin admin = new Admin();
            admin.setManager_Pwd(user_psw);
            admin.setManager_User(user);
            AdminPackage adminPackage = new AdminPackage();
            resultSet =  adminPackage.DoLogin(admin);
            if (resultSet != null) {
                out.print("登陆" + admin.getManager_User() + "成功...");
                //管理员登陆成功
                response.setHeader("refresh", "3,URL=../client/manage_home.jsp");
            }
        }else {
            out.print("密码错误，三秒后将重回主页");
            response.setHeader("refresh", "3,URL=index.jsp");
        }
    }
}
