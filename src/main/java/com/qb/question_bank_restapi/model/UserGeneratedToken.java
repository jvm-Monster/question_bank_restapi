package com.qb.question_bank_restapi.model;

public class UserGeneratedToken {
    private String refreshToken;
    private String accessToken;
    private String dateCreated;

    public UserGeneratedToken() {
    }

    public UserGeneratedToken(String refreshToken, String accessToken, String dateCreated) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.dateCreated = dateCreated;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
