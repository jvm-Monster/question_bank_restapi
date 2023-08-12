package com.qb.question_bank_restapi.resources;

import com.qb.question_bank_restapi.model.User;
import com.qb.question_bank_restapi.querybeanparam.QuestionQueryBeanParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/questions")
public class QuestionResource {


    @GET
    @Path("/unanswered")
    public Response userUnAnsweredQuestions(@BeanParam QuestionQueryBeanParam questionQueryBeanParam){

        return Response.status(200).build();
    }

    @GET()
    @Path("/answered")
    public Response userAnsweredQuestions(@BeanParam QuestionQueryBeanParam questionQueryBeanParam){

        return Response.status(200).entity("TESTING QUESTIONS").build();
    }

    @POST
    public Response answeringQuestions(){

        return Response.status(200).entity("").build();
    }


}
