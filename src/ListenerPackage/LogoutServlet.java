package ListenerPackage;

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
 * Created by hp on 2017/6/1.
 */
    @WebServlet(name = "LogoutServlet",urlPatterns="/ListenerPackage/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");    //设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        //根据不同的用户类型进行传session
        HttpSession session = request.getSession();

        String type = (String) session.getAttribute("user_type");

        //销毁会话,会触发SessionLinstener中的sessionDestroyed方法
        request.getSession().invalidate();

        //从应用上下文中获取在线用户名列表
List<String> online = (List<String>) getServletContext().getAttribute("online");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(" <link href=\"/css/CSS.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println("<body>\n" +
                "<div class=\"site-login-wrapper-test\">\n" +
                "    <div class=\"ThreeDee\">\n" +
                "        <h2>\n" +
                "            退出页面\n" +
                "        </h2>\n" +
                "    </div>\n" +
                "    <div class=\"login-form-test\">");
        out.println("");
        out.println("  <title>用户列表</title>");
        out.println("  ");
        out.print("    <h3>在线用户列表</h3>");

        int size = online == null ? 0 : online.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                out.println("<br>");
            }
            out.println(i + 1 + "." + online.get(i));
        }
        out.println("<hr>        <a href=\"../index.jsp\">登陆主页,进行下一个测试用例</a>\n");
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
        out.println("  ");
        out.println("");
        out.flush();
        out.close();
    }
}
