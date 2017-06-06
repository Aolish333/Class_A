package web;

import dao.Package;
import org.lxh.smart.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 2017/6/4.
 */
@WebServlet(name = "GetImageServlet",urlPatterns = "/web/GetImageServlet")

public class GetImageServlet extends HttpServlet {
    /**
     * 支持文件的上传和图片的上传
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        /*上存图片到本地*/
        SmartUpload su = new SmartUpload();
        //初始化
        su.initialize(this.getServletConfig(), request, response);
        String filepath = this.getServletContext().getRealPath("/image");
        try {
            su.upload();
            /*上存图片地址到数据库中*/
            String picname = su.getFiles().getFile(0).getFileName();
            //String picname = su.getRequest().getParameter("img");

            //将图片名字上存到数据库
            Package dao = new Package();
            dao.setPictureUrl(picname);
            su.save(filepath);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("                                                                                            【图片上存本地成功】");
        response.setHeader("refresh","3;URL=ShowImage");
//        request.getRequestDispatcher("ShowImage").forward(request, response);
    }
}
