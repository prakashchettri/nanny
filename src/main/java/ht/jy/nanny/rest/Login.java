package ht.jy.nanny.rest;

import ht.jy.nanny.couchdb.CouchDB;
import ht.jy.nanny.utils.Utils;
import org.codehaus.jackson.JsonNode;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Jeremy Herault
 */
@Path("/login")
public class Login {

    @POST
    @Produces(MediaType.TEXT_HTML)
    public String login(@FormParam("login") String login, @FormParam("pwd") String password){

        String html = "BAD LOGIN";
        JsonNode nanny = CouchDB.getInstance().connect(login);
        //bad login
        if (nanny != null){
            if (nanny.get("password").getTextValue().equals(password)){
                html = Utils.NANNY_REDIRECT;
            }else{
                html = "BAD PWD";
            }
        }
        return html;
    }
}
