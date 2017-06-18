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
        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println(" <link href=\"/css/select_class.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println("<body>\n" +
                "<div class=\"site-login-wrapper-test\">\n" +
                "    <div class=\"ThreeDee\">\n" +
                "        <h2>\n" +
                "            学生主页\n" +
                "        </h2>\n" +
                "    </div>\n" +
                "    <div class=\"login-form-test\">");
        for (Course course : courses) {
out.println("<center><div class=\"class\" onclick=\"window.open('../client/course__student.jsp?Course_No="+course.getCourse_No()+"')\">\n" +
        "    <div class=\"left\" align=\"center\">\n" +
        "        <img src=\"/image/background8.jpg\" align=\"middle\" width=\"100%\" height=\"100%\">\n" +
        "    </div>\n" +
        "    <div class=\"right\">\n" +
        "        <div class=\"right_1\">\n" +
        "            <div class=\"right_1_1\">\n" +
        "                <table>\n" +
        "                    <tr>\n" +
        "                        <td>\n" +
        "                            课程：\n" +
        "                        </td>\n" +
        "                        <td>\n" +
       course.getCourse_Name() +
        "                        </td>\n" +
        "                    </tr>\n" +
        "                </table>\n" +
        "            </div>\n" +
        "            <div class=\"right_1_2\">\n" +
        "                <table>\n" +
        "                    <tr>\n" +
        "                        <td>\n" +
        "                            学时：\n" +
        "                        </td>\n" +
        "                        <td>\n" +
        course.getCourse_Hours()+
        "                        </td>\n" +
        "                    </tr>\n" +
        "                </table>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "            <hr/>\n" +
        "        <div class=\"right_2\">\n" +
        "            介绍："+course.getCourse_Intro()+
        "            <hr/>\n" +
        "        </div>\n" +
        "        <div class=\"right_3\">\n" +
        "内容：" +course.getCourse_Content()+
        "        </div>\n" +
        "    </div>\n" +
        "</div></center>");
        }
        //对学生要上的课程进行展示
//        out.print("<center>\n" +
//                "    <h2>同学你好，您有如下课程：详细介绍见下表</h2>\n" +
//                "    <table border=\"1px\" >\n" +
//                "        <tr>\n" +
//                "            <td>课程编号：</td>\n" +
//                "            <td>课程名称：</td>\n" +
//                "            <td>课程内容：</td>\n" +
//                "            <td>课程链接：</td>\n" +
//                "        </tr>");
//        for (Course course:courses){
//            out.print("    <tr>\n" +
//                    "        <td>"+course.getCourse_No()+"</td>\n" +
//                    "        <td>"+course.getCourse_Name()+"</td>\n" +
//                    "        <td>"+course.getCourse_Content()+"</td>\n" +
//                    "        <td>"+"<a href=\"../client/course__student.jsp?Course_No="
//                    +course.getCourse_No()+"\">进入教室</a>"+"</td>\n" +
//                    "    </tr>");
//        }
//        out.println("    </tr>\n" +
//                "</table>\n" +
//                "</center>");
        out.println("    </div>\n" +
                "    <div class=\"footer\">\n" +
                "    <center>\n" +
                "        <div id=\"footer\">\n" +
                "            <div id=\"footer_info\">\n" +
                "                <table>\n" +
                "                    <tr>\n" +
                "                        <th class=\"aboutus\">About Us</th>\n" +
                "                        <th class=\"function\">Friend Link</th>\n" +
                "                        <th class=\"back\">Blogs</th>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td><a href=\"#\">About Redrock</a></td>\n" +
                "                        <td><a href=\"#\">Site Map</a></td>\n" +
                "                        <td><a href=\"#\">Web Department</a></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td><a href=\"#\">Phone：8888-8888888</a></td>\n" +
                "                        <td><a href=\"#\">Second-hand Market</a></td>\n" +
                "                        <td><a href=\"#\">Android Department</a></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td><a href=\"#\">Email：boolean93@163.com</a></td>\n" +
                "                        <td><a href=\"#\">BTdown</a></td>\n" +
                "                        <td><a href=\"#\">&nbsp;</a></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td><a href=\"#\">QQ：360828264</a></td>\n" +
                "                        <td><a href=\"#\">Software Center</a></td>\n" +
                "                        <td><a href=\"#\">&nbsp;</a></td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "                <div style=\"clear:both\"></div>\n" +
                "            </div>\n" +
                "            <div id=\"footer_bottom\"></div>\n" +
                "        </div>\n" +
                "    </center>\n" +
                "</div>" +
                "</div>\n" +
                "</body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req,resp);
    }
}
