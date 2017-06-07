package dao;

import domain.Course;
import domain.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/5/31.
 */
public class TeacherPakage {
    /**
     * 老师登陆
     */
    public ResultSet DoLogin(Teacher teacher) {
        String sql_select = "SELECT X_Teacher_User,X_Teacher_Pwd FROM x_teacher WHERE X_Teacher_User = ? AND X_Teacher_Pwd = ? ";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareCall(sql_select);
            ps.setString(1,teacher.getTeacher_User());
            ps.setString(2, teacher.getTeacher_Pwd());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return rs;
    }

    /**
     * 获取某位老师所带的所有课程
     * @param teacher
     * @return
     */

    public List<Course> ObtainAllCourse(Teacher teacher) {
        Conn conn = new Conn();
        Connection connection = conn.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList<>();
        Course course = null;
        String sql = "SELECT DISTINCT X_Course.X_Course_No,X_Course_Content,X_Course_Credit,X_Course_Hours,X_Course_Name,X_Course_Intro,X_Teacher.X_Teacher_No FROM X_Course,X_Electives,X_Teacher WHERE  X_Teacher.X_Teacher_No = X_Electives.X_Teacher_No AND X_Teacher.X_Teacher_No = 1;";
        try {
            ps = connection.prepareStatement(sql);
//            ps.setString(teacher.setTeacher_No());
            rs = ps.executeQuery();
            while (rs.next()){
                course = new Course();
                course.setCourse_No(rs.getString(1));
                course.setCourse_Content(rs.getString(2));
                course.setCourse_Credit(rs.getString(3));
                course.setCourse_Hours(rs.getString(4));
                course.setCourse_Name(rs.getString(5));
                course.setCourse_Intro(rs.getString(6));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseAll(connection, rs, ps);
        }
        return list;
    }

    /**
     * 关闭流
     * @param cn
     * @param rs
     * @param ps
     */
    public void CloseAll(Connection cn, ResultSet rs, PreparedStatement ps) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
