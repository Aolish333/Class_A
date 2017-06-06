package domain;

/**
 * Created by hp on 2017/5/31.
 */
public class Admin {

    String Manager_User;
    String Manager_Pwd;
    String Manager_ID;

    @Override
    public String toString() {
        return "Admin{" +
                "Manager_User='" + Manager_User + '\'' +
                ", Manager_Pwd='" + Manager_Pwd + '\'' +
                ", Manager_ID='" + Manager_ID + '\'' +
                '}';
    }
    public String getManager_User() {
        return Manager_User;
    }

    public void setManager_User(String manager_User) {
        Manager_User = manager_User;
    }

    public String getManager_Pwd() {
        return Manager_Pwd;
    }

    public void setManager_Pwd(String manager_Pwd) {
        Manager_Pwd = manager_Pwd;
    }

    public String getManager_ID() {
        return Manager_ID;
    }

    public void setManager_ID(String manager_ID) {
        Manager_ID = manager_ID;
    }
}
