package web;

import dao.TeacherPakage;
import domain.Course;
import domain.Teacher;

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
@WebServlet(name = "ObtainClassByTeacher",urlPatterns = "/web/ObtainClassByTeacher")
public class ObtainClassByTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  //      super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //得到该老师的工号
        HttpSession session = req.getSession();
        String  Teacher_No = (String) session.getAttribute("teacher_start");
        Teacher teacher = new Teacher();
        teacher.setTeacher_No(Teacher_No);
        //对数据表进行连接获取与该教师相关的课程
        TeacherPakage teacherPakage = new TeacherPakage();
        List<Course> courses = teacherPakage.ObtainAllCourse(teacher);
        //对获取的数据进行展示
        out.println("<center>\n" +
                "    <h2>老师你好，您所带的课程有如下几门：详细介绍见下表</h2>\n" +
                "<table border=\"1px\" >\n" +
                "    <tr>\n" +
                "        <td>课程编号：</td>\n" +
                "        <td>课程名称：</td>\n" +
                "        <td>课程内容：</td>\n" +
                "        <td>课程链接：</td>\n" +
                "    </tr>");
        for (Course course:courses){
            out.print("    <tr>\n" +
                    "        <td>"+course.getCourse_No()+"</td>\n" +
                    "        <td>"+course.getCourse_Name()+"</td>\n" +
                    "        <td>"+course.getCourse_Content()+"</td>\n" +
                    "         <td>"+"<a href=\"../client/course__teacher.jsp?course="
                    +course.getCourse_No()+"\">进入课堂</a>"+"</td>\n" +
                    "    </tr>");
        }
        out.println("    </tr>\n" +
                "</table>\n" +
                "</center>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //     super.doPost(req, resp);
        doGet(req, resp);
    }
}
