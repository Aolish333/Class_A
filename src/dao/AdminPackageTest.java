package dao;

import domain.Admin;
import org.junit.Test;

/**
 * Created by hp on 2017/6/7.
 */

public class AdminPackageTest {
    @Test
    public void doLogin()  {
        Admin admin = new Admin();
        admin.setManager_User("6666666");
        admin.setManager_Pwd("6666666");
        AdminPackage adminPackage = new AdminPackage();
        adminPackage.DoLogin(admin);
        System.out.println(adminPackage.DoLogin(admin));
    }



}
