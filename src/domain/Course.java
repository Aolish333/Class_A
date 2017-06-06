package domain;

/**
 * Created by hp on 2017/5/31.
 */
public class Course {
    String Course_Content;//课程内容
    String Course_Intro;//课程信息
    String Course_Credit;//课程学分
    String Course_Hours;
    String Course_No;
    String Course_Name;

    @Override
    public String toString() {
        return "Course{" +
                "Course_Content='" + Course_Content + '\'' +
                ", Course_Intro='" + Course_Intro + '\'' +
                ", Course_Credit='" + Course_Credit + '\'' +
                ", Course_Hours='" + Course_Hours + '\'' +
                ", Course_No='" + Course_No + '\'' +
                ", Course_Name='" + Course_Name + '\'' +
                '}';
    }

    public String getCourse_Content() {
        return Course_Content;
    }

    public void setCourse_Content(String course_Content) {
        Course_Content = course_Content;
    }

    public String getCourse_Intro() {
        return Course_Intro;
    }

    public void setCourse_Intro(String course_Intro) {
        Course_Intro = course_Intro;
    }

    public String getCourse_Credit() {
        return Course_Credit;
    }

    public void setCourse_Credit(String course_Credit) {
        Course_Credit = course_Credit;
    }

    public String getCourse_Hours() {
        return Course_Hours;
    }

    public void setCourse_Hours(String course_Hours) {
        Course_Hours = course_Hours;
    }

    public String getCourse_No() {
        return Course_No;
    }

    public void setCourse_No(String course_No) {
        Course_No = course_No;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }
}
