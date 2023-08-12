package com.qb.question_bank_restapi.services;

import com.qb.question_bank_restapi.database.LoginOrRegisterUser;
import com.qb.question_bank_restapi.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServices {

    private final User user;
    LoginOrRegisterUser storeUser;
    private static final List<String> levels = new ArrayList<>();
     public UserServices (User user){
        levels.add("100L");
        levels.add("200L");
        levels.add("300L");
        levels.add("400L");
        levels.add("500L");

        this.user=user;
    }

    public boolean storeTheUser(){

        if(user.getUserName() != null && user.getUserPassword() != null
                &&
                user.getUserLevel()!=null &&levels.contains(user.getUserLevel()))
        {
            storeUser= new LoginOrRegisterUser(user);
            return storeUser.registerUser();

        }

        return false;
    }
}
