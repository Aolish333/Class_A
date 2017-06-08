package dao;

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


}
