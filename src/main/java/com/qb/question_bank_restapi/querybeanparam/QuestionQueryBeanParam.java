package com.qb.question_bank_restapi.querybeanparam;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;

public class QuestionQueryBeanParam {

    @HeaderParam("Authorization")
    private String authorizationHeader;

    @QueryParam("category")
    private String category;

    @QueryParam("start")
    private int start;

    @QueryParam("end")
    private int end;

    public QuestionQueryBeanParam() {
    }

    public QuestionQueryBeanParam(String category, int start, int end) {
        this.category = category;
        this.start = start;
        this.end = end;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    @Context
    public void setAuthorizationHeader(HttpHeaders httpHeaders) {
        this.authorizationHeader = httpHeaders.getHeaderString("Authorization");
    }
}
