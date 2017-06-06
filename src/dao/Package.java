package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hp on 2017/5/31.
 */
public class Package {
    //把照片的地址存储到数据库中
    public void setPictureUrl(String path) {
        String sql = "insert into images(image_ID,image_Path) values (?,?)";
        Conn con = new Conn();
        PreparedStatement ps;
        int rs;
        try {
            
            ps = con.getConn().prepareStatement(sql);
            ps.setString(1,"1");
            ps.setString(2,path);
            // 对SQL语句的占位符参数进行动态赋值
            rs = ps.executeUpdate();
            System.out.println("【图片信息成功进入数据库】");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获得数据库的地址
    public String getPictureUrl(int num) {
        String sql = "select image_Path from images where image_ID = ?";
        Conn con = new Conn();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getConn().prepareStatement(sql);
            ps.setInt(1, num);
            // 对SQL语句的占位符参数进行动态赋值
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("【成功在数据库中取出】");
                return rs.getString("image_Path");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
