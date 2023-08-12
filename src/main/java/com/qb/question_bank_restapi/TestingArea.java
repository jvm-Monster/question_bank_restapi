package com.qb.question_bank_restapi;

import com.qb.question_bank_restapi.model.User;
import com.qb.question_bank_restapi.security.QbPassword;
import com.qb.question_bank_restapi.security.QbPasswordHasher;
import com.qb.question_bank_restapi.security.QbPasswordVerifier;

public class TestingArea {
    public static void main(String[] args){
        User user = new User();
        user.setUserName("VI-tex");
        user.setUserLevel("100L");
        user.setUserPassword("emmanuel");

        QbPassword password = new QbPasswordVerifier();
        try{
            System.out.println(password.verifyPassword(user));
        }catch (Exception e){

        }


    }
}
