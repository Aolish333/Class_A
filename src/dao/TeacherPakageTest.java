package dao;

import domain.Electives;
import domain.Teacher;
import org.junit.Test;

/**
 * Created by hp on 2017/6/4.
 */

public class TeacherPakageTest {
    @Test
    public void test1(){
        Teacher teacher = new Teacher();
        teacher.setTeacher_No("1");
        TeacherPakage teacherPakage = new TeacherPakage();
        teacherPakage.ObtainAllCourse(teacher);
    }
    @Test
    public void addstudent(){
        Electives electives = new Electives();
        electives.setStudent_No("3");
        electives.setCourse_No("2");
        TeacherPakage teacherPakage = new TeacherPakage();
        int row = teacherPakage.AttendClass(electives);
        System.out.print(row);
    }


}
