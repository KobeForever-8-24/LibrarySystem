package com.example.kevinzhou.demo.user;

public class User {
    public String userId;
    public String user;
    public String psd;
    public String phone;
    public String token;
    private String permission;
    public int borrowCount;

    public User() {
    }

    public User(String userId, String user, String psd, String phone, String token, String permission, int borrowCount) {
        this.userId = userId;
        this.user = user;
        this.psd = psd;
        this.phone = phone;
        this.token = token;
        this.permission = permission;
        this.borrowCount = borrowCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }
}
