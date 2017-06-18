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
import java.util.List;

/**
 * Created by hp on 2017/6/10.
 */
@WebServlet(name = "ShowTaskServlet",urlPatterns = "/web/ShowTaskServlet")
public class ShowTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        获取seesion
        HttpSession session = request.getSession();
//        String  Course_No = (String) session.getAttribute("Course_No");
        String Course_No = request.getParameter("Course_No");
        Electives electives = new Electives();
        electives.setCourse_No(Course_No);
        TeacherPakage teacherPakage = new TeacherPakage();
        List<Electives> list =  teacherPakage.ShowTask(electives);
        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println("<center>\n" +
                "<table border=\"1px\">\n" +
                "    <tr>\n" +
                "        <td>学号</td>\n" +
                "        <td>实验报告</td>\n" +
                "        <td>平时作业</td>\n" +
                "    </tr>");
        for (Electives electives1 :list) {
            out.println("    <tr>\n" +
                    "        <td>"+electives1.getStudent_No()+"</td>\n" +
                    "      <td><a href=\"/web/downloadServlet?name="+electives1.getElectives_TR()+"\" rel=\"nofollow\" >"+electives1.getElectives_TR()+"</a></td>\n" +                    "      <td><a href=\"/web/downloadServlet?name="+electives1.getElectives_TakeTask()+"\" rel=\"nofollow\" >"+electives1.getElectives_TakeTask()+"</a></td>\n" +
                    "    </tr>");
        }
        out.println("</table>\n" +
                "</center>\n");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
