package dao;

import domain.Electives;
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
}
