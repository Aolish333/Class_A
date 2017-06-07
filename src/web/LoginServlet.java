package web;

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
@WebServlet(name = "LoginServlet",urlPatterns = "/web/GetImageServlet")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        String id = req.getParameter("id");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ResultSet resultSet = null;
        String user = req.getParameter("user");
        String user_psw = req.getParameter("user_psw");
        String type = req.getParameter("user_psw");
//        HttpSession session = req.setAttribute("user",username);
        //用session进行传值
        req.getSession().setAttribute("user", user);
        if (type.equals("student")){
            Student student = new Student();
            student.setStudent_User(user);
            student.setStudent_Psd(user_psw);
            StudentPakage studentPakage = new StudentPakage();
            resultSet = studentPakage.DoLogin(student);
            if (resultSet!=null){
                out.print("登陆"+student.getStudent_User()+"成功...");
                //教师登陆成功
                resp.setHeader("refresh","3,URL=ObtainClassByStudent");
            }
        }else if (type.equals("teacher")){
            Teacher teacher = new Teacher();
            teacher.setTeacher_User(user);
            teacher.setTeacher_Pwd(user_psw);
            TeacherPakage teacherPakage = new TeacherPakage();
            resultSet = teacherPakage.DoLogin(teacher);
            if (resultSet!=null){
                out.print("登陆"+teacher.getTeacher_User()+"成功...");
                //学生登陆成功
                resp.setHeader("refresh","3,URL=ObtainClassByTeacher");
            }
        }else {
            Admin admin = new Admin();
            admin.setManager_Pwd(user_psw);
            admin.setManager_User(user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
    }
}
