

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class Login {

    // @POST
    // @Path("login/logar")
    // @Produces(MediaType.TEXT_PLAIN)
    // @Consumes(MediaType.APPLICATION_JSON)
    
    // public String logar(@PathParam("login") String login, @PathParam("password") String password ) {
    //     return "a";
    // }
    
    
    @GET
    @Path("login/logar")
    @Produces(MediaType.TEXT_PLAIN)
    // @Consumes(MediaType.APPLICATION_JSON)
    
    public String logar( ) {
        return "a";
    }
    
}