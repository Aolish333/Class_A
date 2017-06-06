package domain;

/**
 * Created by hp on 2017/6/3.
 */
public class Electives {

    String Electives_OnDuty;
    String Electives_TakeTask;
    String Electives_TR;
    String Course_No;
    String Student_No;
    String Teacher_No;

    public String getTeacher_No() {
        return Teacher_No;
    }

    public void setTeacher_No(String teacher_No) {
        Teacher_No = teacher_No;
    }

    public String getElectives_OnDuty() {
        return Electives_OnDuty;
    }

    public void setElectives_OnDuty(String electives_OnDuty) {
        Electives_OnDuty = electives_OnDuty;
    }

    public String getElectives_TakeTask() {
        return Electives_TakeTask;
    }

    public void setElectives_TakeTask(String electives_TakeTask) {
        Electives_TakeTask = electives_TakeTask;
    }

    public String getElectives_TR() {
        return Electives_TR;
    }

    public void setElectives_TR(String electives_TR) {
        Electives_TR = electives_TR;
    }

    public String getCourse_No() {
        return Course_No;
    }

    public void setCourse_No(String course_No) {
        Course_No = course_No;
    }

    public String getStudent_No() {
        return Student_No;
    }

    public void setStudent_No(String student_No) {
        Student_No = student_No;
    }

}
