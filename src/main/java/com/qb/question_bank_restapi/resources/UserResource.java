package com.qb.question_bank_restapi.resources;

import com.qb.question_bank_restapi.model.User;
import com.qb.question_bank_restapi.database.CachingSystem;
import com.qb.question_bank_restapi.services.UserServices;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {
    UserServices userService;


    public UserResource(){

    }

    @POST
    public Response registerUser(User user) {
        String username=user.getUserName();

        if(CachingSystem.getUsernameCache(username)!=null){
            System.out.println("checks caching");
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Username already exists").build();
        }
        // Implementation code for registering a user
        userService=new UserServices(user);
        boolean registered = userService.storeTheUser();
        if(registered){
            CachingSystem.setUsernameCache(username);
            return Response.ok("register user is working").build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Not Acceptable username or password").build();
    }

    @POST
    @Path("/{userId}")
    public Response loginUser(@PathParam("userId") String userId, User user) {
        // Implementation code for logging in a user
        return Response.ok("login user now, name: " + user.getUserName()).build();
    }


    @Path("/{userId}/questions")
    public QuestionResource getQuestionResource(){
        return new QuestionResource();
    }

}
