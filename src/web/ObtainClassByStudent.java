package web;

import dao.StudentPakage;
import domain.Course;
import domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by hp on 2017/6/3.
 */
@WebServlet(name = "ObtainClassByStudent",urlPatterns = "/web/ObtainClassByStudent")
/**
 * 参照教师的写
 */
public class ObtainClassByStudent extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //     super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //传值
        HttpSession session = req.getSession();
        String  Student_No = (String) session.getAttribute("student_start");

        Student student = new Student();
        student.setStudent_No(Student_No);
        StudentPakage studentPakage = new StudentPakage();
        List<Course> courses =  studentPakage.ObtainAllCourse(student);
        //对学生要上的课程进行展示
        out.print("<center>\n" +
                "    <h2>同学你好，您有如下课程：详细介绍见下表</h2>\n" +
                "    <table border=\"1px\" >\n" +
                "        <tr>\n" +
                "            <td>课程编号：</td>\n" +
                "            <td>课程名称：</td>\n" +
                "            <td>课程内容：</td>\n" +
                "            <td>课程链接：</td>\n" +
                "        </tr>");
        for (Course course:courses){
            out.print("    <tr>\n" +
                    "        <td>"+course.getCourse_No()+"</td>\n" +
                    "        <td>"+course.getCourse_Name()+"</td>\n" +
                    "        <td>"+course.getCourse_Content()+"</td>\n" +
                    "        <td>"+"<a href=\"../client/course__student.jsp?Course_No="
                    +course.getCourse_No()+"\">进入教室</a>"+"</td>\n" +
                    "    </tr>");
        }
        out.println("    </tr>\n" +
                "</table>\n" +
                "</center>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
    }
}
