package ht.jy.nanny.rest;

import com.sun.jersey.api.client.ClientResponse.Status;
import ht.jy.nanny.couchdb.CouchDB;
import org.codehaus.jackson.JsonNode;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *  @author Jeremy Herault
 */

@Path("nanny")
public class Nanny {

    @POST
    public String connect(@FormParam("user") String username, @FormParam("pwd") String password){
        String res = Status.OK.toString();
        JsonNode nanny = CouchDB.getInstance().connect(username);
        res = nanny != null ? (nanny.get("password").getTextValue().equals(password) ?  res : Status.FORBIDDEN.toString()) : Status.NOT_FOUND.toString();
        return res;
    }






}
