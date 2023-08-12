package com.qb.question_bank_restapi.model;

import java.util.List;
import java.util.Map;

public class Question {

    private int questionId;
    private String questionSubject;
    private String questionLevel;
    private String question;
    private List<String> options;
    private String questionAnswer;
    private String dateAdded;

    public Question(int questionId, String questionSubject, String questionLevel, String question, List<String> options, String questionAnswer, String dateAdded) {
        this.questionId = questionId;
        this.questionSubject = questionSubject;
        this.questionLevel = questionLevel;
        this.question = question;
        this.options = options;
        this.questionAnswer = questionAnswer;
        this.dateAdded = dateAdded;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionSubject() {
        return questionSubject;
    }

    public void setQuestionSubject(String questionSubject) {
        this.questionSubject = questionSubject;
    }
    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
