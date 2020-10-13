package com.example.kevinzhou.demo.model;

public class ResetPsdRequest {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getUserNewPsd() {
        return userNewPsd;
    }

    public void setUserNewPsd(String userNewPsd) {
        this.userNewPsd = userNewPsd;
    }

    private String userPsd;
    private String userNewPsd;


}
