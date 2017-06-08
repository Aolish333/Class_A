package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by hp on 2017/6/8.
 */
@WebServlet(name = "downloadServlet",urlPatterns = "/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");
        //获取文件名
        String filename=request.getParameter("name");
        //防止读取name名乱码
        filename=new String(filename.getBytes("iso-8859-1"),"utf-8");
//        filename = DownloadUtils.getFilename(request,filename);
        //在控制台打印文件名
        System.out.println("文件名："+filename);

        PrintWriter out = response.getWriter();

        //设置文件MIME类型
        response.setContentType(getServletContext().getMimeType(filename));
        //设置Content-Disposition
//        response.setHeader("Content-Disposition", "attachment;filename="+filename);
        response.setHeader("Content-Disposition", "attachment;filename="
                + new String(filename.getBytes("utf-8"), "iso-8859-1"));

        //获取要下载的文件绝对路径，我的文件都放到WebRoot/download目录下
        ServletContext context=this.getServletContext();
        String fullFileName=context.getRealPath("/upload/"+filename);
        System.out.printf("fullFileName");

        out.println(fullFileName);

        //输入流为项目文件，输出流指向浏览器
        InputStream is=new FileInputStream(fullFileName);
        ServletOutputStream os = null;
        try {
            os =response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

    /*
     * 设置缓冲区
     * is.read(b)当文件读完时返回-1
     */
            int len=-1;
            byte[] b=new byte[1024];
            while((len=is.read(b))!=-1){
                os.write(b,0,len);
            }
            //关闭流
            is.close();
            os.close();
        }
        }


}
