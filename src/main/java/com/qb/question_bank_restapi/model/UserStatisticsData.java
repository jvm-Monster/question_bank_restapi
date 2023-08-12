package com.qb.question_bank_restapi.model;

public class UserStatisticsData {
    private int userId;
    private int successQuestions;
    private int failedQuestions;

    private int totalQuestionsAnswered;

    public UserStatisticsData() {
    }

    public UserStatisticsData(int userId, int successQuestions, int failedQuestions, int totalQuestionsAnswered) {
        this.userId = userId;
        this.successQuestions = successQuestions;
        this.failedQuestions = failedQuestions;
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSuccessQuestions() {
        return successQuestions;
    }

    public void setSuccessQuestions(int successQuestions) {
        this.successQuestions = successQuestions;
    }

    public int getFailedQuestions() {
        return failedQuestions;
    }

    public void setFailedQuestions(int failedQuestions) {
        this.failedQuestions = failedQuestions;
    }

    public int getTotalQuestionsAnswered() {
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
    }
}
