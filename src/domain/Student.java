package domain;

/**
 * Created by hp on 2017/5/31.
 */
public class Student {
    String Student_Name;
    String Student_User;
    String Student_Psd;
    String Student_No;

    @Override
    public String toString() {
        return "Student{" +
                "Student_Name='" + Student_Name + '\'' +
                ", Student_User='" + Student_User + '\'' +
                ", Student_Psd='" + Student_Psd + '\'' +
                ", Student_No='" + Student_No + '\'' +
                '}';
    }
    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStudent_User() {
        return Student_User;
    }

    public void setStudent_User(String student_User) {
        Student_User = student_User;
    }

    public String getStudent_Psd() {
        return Student_Psd;
    }

    public void setStudent_Psd(String student_Psd) {
        Student_Psd = student_Psd;
    }

    public String getStudent_No() {
        return Student_No;
    }

    public void setStudent_No(String student_No) {
        Student_No = student_No;
    }


}
