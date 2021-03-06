package dao;

import domain.Course;
import domain.Electives;
import domain.Student;
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
     * 显示已经提交作业的同学的作业(实验报告和作业)
     */
    public List<Electives> ShowTask(Electives electives){
        Conn conn = new Conn();
        Connection connection = conn.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Electives> list = new ArrayList<>();
        Electives elect = null;
        String sql = "SELECT DISTINCT X_Electives_TakeTask,X_Electives.X_Student_No ,X_Electives_TR FROM X_Electives,X_Teacher WHERE  x_electives.X_Course_No = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,electives.getCourse_No());
            rs = ps.executeQuery();
            while (rs.next()) {
                elect = new Electives();
                elect.setElectives_TakeTask(rs.getString(1));
                elect.setStudent_No(rs.getString(2));
                elect.setElectives_TR(rs.getString(3));
                list.add(elect);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return list;
    }
    /**
     * 添加学生到该老师的课堂
     */
    public int AttendClass(Electives electives){
        int row = 0;
        String sql_select = "INSERT INTO X_Electives (X_Electives.X_Student_No, X_Electives.X_Course_No) VALUES (?,?);";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setString(1,electives.getStudent_No());
            ps.setString(2, electives.getCourse_No());
//            ps.setString(3,electives.getTeacher_No());
            row  = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return row;
    }
    /**
     * 老师登陆
     */
    public ResultSet DoLogin(Teacher teacher) {
        String sql_select = "SELECT * FROM x_teacher WHERE X_Teacher_No = ? AND X_Teacher_Pwd = ? ";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(sql_select);
            ps.setString(1,teacher.getTeacher_No());
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
        String sql = "SELECT DISTINCT X_Course.X_Course_No,X_Course_Content,X_Course_Credit,X_Course_Hours,X_Course_Name,X_Course_Intro FROM X_Course,X_Electives,X_Teacher WHERE  X_Teacher.X_Teacher_No = X_Electives.X_Teacher_No AND  X_Course.X_Course_No = X_Electives.X_Course_No AND X_Teacher.X_Teacher_No = ?;";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(teacher.getTeacher_No()));
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

    public List<Student> TmanageS(){
        Conn conn=new Conn();
        List<Student> list=new ArrayList<Student>();
        ResultSet rs=null;
        PreparedStatement ps=null;
        String sql="select X_Student.X_Student_No,X_Student_Name from X_Student\n" +
                "  left join X_Electives\n" +
                "    on X_Student.X_Student_No = X_Electives.X_Student_No\n" +
                "where X_Student.X_Student_No not IN (SELECT X_Student.X_Student_No FROM X_Student,X_Electives WHERE X_Student.X_Student_No = X_Electives.X_Student_No);";
        try {
            Connection connection=conn.getConn();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setStudent_No(rs.getString(1));
                student.setStudent_Name(rs.getString(2));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Student> TS(){
        List<Student> list=new ArrayList<Student>();
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            Conn conn=new Conn();
            Connection connection=conn.getConn();
            String sql="SELECT X_Student.X_Student_No,X_Student_Name FROM X_Student,X_Electives WHERE X_Student.X_Student_No = X_Electives.X_Student_No";
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setStudent_No(rs.getString(1));
                student.setStudent_Name(rs.getString(2));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
