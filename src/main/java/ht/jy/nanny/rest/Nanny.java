package ht.jy.nanny.rest;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *  @author Jeremy Herault
 */

@Path("nanny")
public class Nanny {

       public Response update(@QueryParam("nanny") String nanny){
           
          Response response = Response.ok().build();
           
          return response;
       } 
}
