package dao;

import domain.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/5/31.
 */
public class Package {
    public int InsertCourse(Course C ){
        int rs=0;
        try {
            Conn conn=new Conn();
            Connection dbc=conn.getConn();
            //问号占位
            String sql_insert="insert into x_course(X_Course_Name,X_Course_Intro,X_Course_Hours,X_Course_Content,X_Course_Credit) value(?,?,?,?,?) ";
            //Statement接口提供了查询语句和获取查询结果的基本方法
            PreparedStatement pst=dbc.prepareStatement(sql_insert);
            //给问号赋值1，2，3代表第几个问号
            pst.setString(1,C.getCourse_Name());
            pst.setString(2,C.getCourse_Intro());
            pst.setString(3,C.getCourse_Hours());
            pst.setString(4,C.getCourse_Content());
            pst.setString(5,C.getCourse_Credit());
            rs=pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    //查询数据
    public List<Course> SelectUser(){
        List<Course> list=new ArrayList<Course>();
        //ResultSet对象接收查询结果集
        //ResultSet对象包含了符合SQL语句的所有行，针对java中的数据类型提供了一套get。。。方法，
        //根据这个方法可以获得每一行的数据
        ResultSet rs=null;
        try{
            Conn conn=new Conn();
            Connection dbc=conn.getConn();
            String sql_select="select * from x_course";
            PreparedStatement pst=dbc.prepareStatement(sql_select);
            rs=pst.executeQuery();
            while(rs.next()){
                Course C=new Course();
                C.setCourse_Intro(rs.getString(2));
                C.setCourse_Content(rs.getString(1));
                C.setCourse_Credit(rs.getString(3));
                C.setCourse_Hours(rs.getString(4));
                C.setCourse_Name(rs.getString("X_Course_Name"));
                C.setCourse_No(rs.getString(5));
                list.add(C);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    //删除数据
    public int DeleteCourse(Course C){
        int rs=0;
        try {
            Conn conna=new Conn();
            Connection dbc=conna.getConn();
            String sql_delete="delete from x_course where X_Course_No=?";
            PreparedStatement pst=dbc.prepareStatement(sql_delete);
            //对sql语句中的第一个参数赋值
            pst.setString(1, C.getCourse_No());
            rs=pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    public  List<Course> SelectUserId(Course C){
        List<Course> list=new ArrayList<Course>();
        ResultSet rs=null;
        try {
            Conn conna=new Conn();
            Connection dbc=conna.getConn();
            String sql_select_id="select * from x_course where X_Course_No=?";
            PreparedStatement pst=dbc.prepareStatement(sql_select_id);
            pst.setString(1, C.getCourse_No());
            rs=pst.executeQuery();
            if(rs.next()){
                C.setCourse_Name(rs.getString("X_Course_Name"));
                C.setCourse_Hours(rs.getString(4));
                C.setCourse_Credit(rs.getString(3));
                C.setCourse_Intro(rs.getString(2));
                C.setCourse_Content(rs.getString(1));
                C.setCourse_No(rs.getString(5));
                list.add(C);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list ;
    }
    //2.接受用户修改后的值，修改当前记录
    public int UpdateUserId(Course C){
        int rs=0;
        try {
            Conn dbc=new Conn();
            Connection conn=dbc.getConn();
            String sql_update="update x_course set X_Course_Name=?,X_Course_Intro=?,X_Course_Hours=?,X_Course_Content=?,X_Course_Credit=? where X_Course_No=?";
            PreparedStatement pst=conn.prepareStatement(sql_update);
            pst.setString(1,C.getCourse_Name());
            pst.setString(2,C.getCourse_Intro());
            pst.setString(3,C.getCourse_Hours());
            pst.setString(4,C.getCourse_Content());
            pst.setString(5,C.getCourse_Credit());
            pst.setString(6,C.getCourse_No());
            rs=pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
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
