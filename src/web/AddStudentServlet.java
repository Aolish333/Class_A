package web;

import dao.TeacherPakage;
import domain.Electives;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hp on 2017/6/9.
 */
@WebServlet(name = "AddStudentServlet",urlPatterns = "/web/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        获取seesion
        HttpSession session = request.getSession();
        String  Course_No = (String) session.getAttribute("course");
        String Student_No = request.getParameter("Student_No");
        Electives electives = new Electives();
        electives.setCourse_No(Course_No);
        electives.setStudent_No(Student_No);
        TeacherPakage teacherPakage = new TeacherPakage();
        int row =  teacherPakage.AttendClass(electives);
        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");

        if (row == 1){
            out.println("添加成功...");
        }else {
            out.println("添加失败...");
        }
        response.setHeader("refresh", "3,URL=/client/add_student_to_course.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
