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
import javax.servlet.http.HttpSession;
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
        //根据不同的用户类型进行传session
        HttpSession session = request.getSession();
        session.setAttribute("type",request.getParameter("user_type"));

        PrintWriter out = response.getWriter();
        ResultSet resultSet = null;
        String id = request.getParameter("user");
        String user_psw = request.getParameter("user_psw");
        String type = request.getParameter("user_type");

        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");

//        HttpSession session = req.setAttribute("user",username);
        //用session进行传值

        if (type.equals("student")) {
            Student student = new Student();
            student.setStudent_No(id);
            student.setStudent_Psd(user_psw);
            StudentPakage studentPakage = new StudentPakage();
            resultSet = studentPakage.DoLogin(student);
            if (resultSet != null) {
                //传递seesion值
                session.setAttribute("student_start",student.getStudent_No());
//                out.print(session.getAttribute("student_start"));
                out.print("学生登陆" + student.getStudent_No() + "成功...");
                //学生登陆成功
                response.setHeader("refresh", "3,URL=/web/ObtainClassByStudent");
            }
        } else if (type.equals("teacher")) {
            Teacher teacher = new Teacher();
            teacher.setTeacher_No(id);
            teacher.setTeacher_Pwd(user_psw);
            TeacherPakage teacherPakage = new TeacherPakage();
            resultSet = teacherPakage.DoLogin(teacher);
            if (resultSet != null) {
                //传递seesion值
                session.setAttribute("teacher_start",teacher.getTeacher_No());
                out.print("老师登陆" + teacher.getTeacher_No() + "成功...");
                //学生登陆成功
                response.setHeader("refresh", "2,URL=ObtainClassByTeacher");
            }
        } else if (type.equals("admin")){
            Admin admin = new Admin();
            admin.setManager_Pwd(user_psw);
            admin.setManager_User(id);
            AdminPackage adminPackage = new AdminPackage();
            resultSet =  adminPackage.DoLogin(admin);
            if (resultSet != null) {
                //传递seesion值
                session.setAttribute("admin_start",admin.getManager_User());
                out.print("管理员登陆" + admin.getManager_User() + "成功...");
                //管理员登陆成功
                response.setHeader("refresh", "2,URL=../manage/ShowTwo.jsp");
            }
        }else {
            out.print("密码错误，三秒后将重回主页");
            response.setHeader("refresh", "2,URL=index.jsp");
        }
    }
}
