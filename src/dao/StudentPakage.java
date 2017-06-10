package dao;

import domain.Course;
import domain.Electives;
import domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/5/31.
 */
public class StudentPakage {
    /**
     * 上传实验报告
     */
    public int UpLoadTR(Electives electives){
        String sql="UPDATE X_Electives" +
                "SET X_Electives.X_Electives_TR = ?" +
                "WHERE X_Electives.X_Course_No = ? AND X_Electives.X_Student_No = ?;";
        int ret = 0;
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql);
            ps.setString(1,electives.getElectives_TR());
            ps.setInt(2, Integer.parseInt(electives.getCourse_No()));
            ps.setInt(3, Integer.parseInt(electives.getStudent_No()));
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseAll(connection, rs, ps);
        }
        return ret;

    }
    /**
     * 上传作业文件
     */
    public int UpLoadTakeTask(Electives electives) {
        String sql="UPDATE X_Electives SET X_Electives_TakeTask = ? WHERE X_Electives.X_Course_No = ? AND X_Electives.X_Student_No = ?;";
        int ret = 0;
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql);
            ps.setString(1,electives.getElectives_TakeTask());
            ps.setInt(2, Integer.parseInt(electives.getCourse_No()));
            ps.setInt(3, Integer.parseInt(electives.getStudent_No()));
            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseAll(connection, rs, ps);
        }

        return ret;
    }

    /**
     * 学生登陆
     * @param student
     * @return
     */
    public ResultSet DoLogin(Student student) {
        String sql_select = "SELECT X_Student_User,X_Student_Pwd , X_Student_No FROM x_student WHERE  X_Student_No= ? AND X_Student_Pwd = ? ";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setString(1,student.getStudent_No());
            ps.setString(2, student.getStudent_Psd());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return rs;
    }
    public List<Course> ObtainAllCourse(Student student) {
        Conn conn = new Conn();
        Connection connection = conn.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> list = new ArrayList<>();
        Course course = null;
        String sqlByStudent = "SELECT DISTINCT X_Course.X_Course_No,X_Course_Content,X_Course_Credit,X_Course_Hours,X_Course_Name,X_Course_Intro ,x_student.X_Student_No  FROM X_Course,X_Electives ,x_student WHERE  x_student.X_Student_No = X_Electives.X_Student_No AND X_Course.X_Course_No = X_Electives.X_Course_No AND X_Student.X_Student_No = ?;";
        try {
            ps = connection.prepareStatement(sqlByStudent);
            //添加
            ps.setInt(1, Integer.parseInt(student.getStudent_No()));
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
