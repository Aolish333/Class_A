package dao;

import domain.Electives;
import domain.Student;
import org.junit.Test;


/**
 * Created by hp on 2017/6/10.
 */

public class StudentPakageTest {
    @Test
    public void tst()  {
        Electives electives = new Electives();
        electives.setElectives_TR("1");
        electives.setStudent_No("1");
        electives.setCourse_No("1");
        StudentPakage studentPakage = new StudentPakage();
        studentPakage.UpLoadTR(electives);
    }
    @Test
    public void tfsdst()  {
        Student electives = new Student();
        electives.setStudent_No("3");
        StudentPakage studentPakage = new StudentPakage();
        studentPakage.DeleteUser(electives);
    }
}
