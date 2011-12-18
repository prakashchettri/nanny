package ht.jy.nanny.rest;

import ht.jy.nanny.couchdb.CouchDB;
import ht.jy.nanny.utils.Utils;
import org.codehaus.jackson.JsonNode;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Jeremy Herault
 */
@Path("/login")
public class Login {

    @POST
    public String login(@FormParam("login") String login, @FormParam("pwd") String password){

        JsonNode nanny = CouchDB.getInstance().connect(login);
        return nanny.get("password").getTextValue().equals(password) ? Utils.NANNY_REDIRECT : "BAD BAD BAD I'M BAD...";
    }
}
