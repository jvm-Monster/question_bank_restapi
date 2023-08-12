package com.qb.question_bank_restapi.exceptions.normalexceptions;

public class PasswordHashingException extends RuntimeException{

    public PasswordHashingException(String message, Throwable cause){
        super(message,cause);
    }
}
