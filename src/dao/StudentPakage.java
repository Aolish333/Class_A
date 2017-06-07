package dao;

import domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hp on 2017/5/31.
 */
public class StudentPakage {
    public ResultSet DoLogin(Student student) {
        String sql_select = "SELECT X_Student_User,X_Student_PwdFROM x_student WHERE  X_Student_User= ? AND X_Student_Pwd = ? ";
        Conn conn = new Conn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareCall(sql_select);
            ps.setString(1,student.getStudent_User());
            ps.setString(2, student.getStudent_Psd());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseAll(connection, rs, ps);
        }
        return rs;
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
