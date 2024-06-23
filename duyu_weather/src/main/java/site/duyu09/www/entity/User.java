package site.duyu09.www.entity;

public class User {
    private Long id;
    private String phoneNum;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
         this.password = password;
    }

    public String getPhoneNum() {
         return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
         this.phoneNum = phoneNum;
    }
}
