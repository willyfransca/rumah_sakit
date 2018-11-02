/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import helper.UserHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.User;

/**
 * REST Web Service
 *
 * @author Windows
 */
@Path("User")
public class UserResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResources
     */
    public UserResources() {
    }

    /**
     * Retrieves representation of an instance of service.UserResources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserResources
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(
            @QueryParam("email") String email, 
            @QueryParam("password") String password){
        UserHelper helper = new UserHelper();
        User hasil = helper.login(email, password);
//        boolean hasil = helper.login(email, password);
        Gson gson = new Gson();
        
         return Response.status(200)
                .entity(gson.toJson(hasil))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age","2")
                .header("Access-Preflight-Maxage", "2")
                .build();
    }
    
     
    @GET
    @Path("login1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogin( @QueryParam("email") String email, 
            @QueryParam("password") String password){
        UserHelper helper = new UserHelper();
        User  user = helper.getUser(email, password);
        Gson gson = new Gson();
        
       return Response
               .status(200)
               .entity(gson.toJson(user))
               .build();
    }
}
