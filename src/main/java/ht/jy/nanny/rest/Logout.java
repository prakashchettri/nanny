package ht.jy.nanny.rest;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Jeremy Herault
 */

@Path("/logout")
public class Logout {

    @GET
    public Response logout(@Context UriInfo uriInfo) throws URISyntaxException {
        Viewable view;
        Response response = null;
        
        String baseUri =  uriInfo.getBaseUri().toString();
        baseUri = baseUri.substring(0, baseUri.indexOf("/rest"));

        response = Response.seeOther(new URI(baseUri + "/html/nanny.html"))
                .header("Set-Cookie", "connected=deleted;")
                .header("Set-Cookie", "password=deleted;")
                .header("Set-Cookie", "login=deleted;")
                .build();

        return response;
    }
    
}
