package com.FilmReviewWeb.Model;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    //权限 普通用户为0，管理员为1
    private Integer power;
    private String registDate;
    //最后在线日期
    private String lastOnlineDate;
    private String gender;

    public User() {
    }

    public User(Integer userId, String userName, String password, Integer power, String registDate, String lastOnlineDate, String gender) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.power = power;
        this.registDate = registDate;
        this.lastOnlineDate = lastOnlineDate;
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getLastOnlineDate() {
        return lastOnlineDate;
    }

    public void setLastOnlineDate(String lastOnlineDate) {
        this.lastOnlineDate = lastOnlineDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
