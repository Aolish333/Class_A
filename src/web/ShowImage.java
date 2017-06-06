package web;

import dao.Package;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hp on 2017/6/4.
 */
@WebServlet(name = "ShowImage",urlPatterns = "/web/ShowImage")

public class ShowImage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Package dao = new Package();
        String path = this.getServletContext().getRealPath("/image");
        //选择要显示图片的id
//        String pnum = (String) req.getParameter("id");
//        int num = Integer.parseInt(pnum);
        int num=1;
        //获取图片的地址
        String picUrl = dao.getPictureUrl(num);
        String filepath = path + "\\" +picUrl;
        req.setAttribute("picUrl", filepath);
        PrintWriter out = resp.getWriter();
        out.print(filepath);
        out.print("<img src=\""+filepath+"\"  alt=\"测试\" />");
        System.out.println("【显示图片成功】");
//        resp.setHeader("refresh","3;URL=""");
//        req.getRequestDispatcher("show.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        doGet(req, resp);
    }
}
