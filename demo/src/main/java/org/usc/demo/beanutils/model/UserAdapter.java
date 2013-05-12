package org.usc.demo.beanutils.model;

public class UserAdapter {
    private String userName;
    private String passWord;

    public UserAdapter() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserAdapter [userName=" + userName + ", passWord=" + passWord + "]";
    }

}
