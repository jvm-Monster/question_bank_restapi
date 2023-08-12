package com.qb.question_bank_restapi.model;

public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userLevel;
    private String dateCreated;


    public User() {
    }

    public User(int userId, String userName, String userPassword, String userLevel) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userLevel = userLevel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
