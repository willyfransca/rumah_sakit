/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import com.google.gson.Gson;
import helper.klinikHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author basisa21
 */
@Path("klinik")
public class KlinikResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KlinikResource
     */
    public KlinikResource() {
    }
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object\
        klinikHelper k = new klinikHelper();
        Gson g = new Gson();
                return Response.status(Response.Status.OK)
       .entity(g.toJson(k.bacaSemuaKlinik()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "20")
                .header("Access-Preflight-Maxage", "20")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of lokasiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
