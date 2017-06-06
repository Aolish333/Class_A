package domain;

/**
 * Created by hp on 2017/5/31.
 */
public class Teacher {
    String Teacher_Name;
    String Teacher_Pwd;
    String Teacher_User;
    String Teacher_No;

    @Override
    public String toString() {
        return "Teacher{" +
                "Teacher_Name='" + Teacher_Name + '\'' +
                ", Teacher_Pwd='" + Teacher_Pwd + '\'' +
                ", Teacher_User='" + Teacher_User + '\'' +
                ", Teacher_No='" + Teacher_No + '\'' +
                '}';
    }


    public String getTeacher_Name() {
        return Teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        Teacher_Name = teacher_Name;
    }

    public String getTeacher_Pwd() {
        return Teacher_Pwd;
    }

    public void setTeacher_Pwd(String teacher_Pwd) {
        Teacher_Pwd = teacher_Pwd;
    }

    public String getTeacher_User() {
        return Teacher_User;
    }

    public void setTeacher_User(String teacher_User) {
        Teacher_User = teacher_User;
    }

    public String getTeacher_No() {
        return Teacher_No;
    }

    public void setTeacher_No(String teacher_No) {
        Teacher_No = teacher_No;
    }
}
