package ht.jy.nanny.rest;

import com.sun.jersey.api.view.Viewable;
import ht.jy.nanny.couchdb.CouchDB;
import ht.jy.nanny.utils.Utils;
import org.codehaus.jackson.JsonNode;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

/**
 * @author Jeremy Herault
 */
@Path("/login")
public class Login {

    @POST
    public Response login(@FormParam("login") String login, @FormParam("pwd") String password) {
        Viewable view;
        NewCookie cookie;
        Response response = null;
        JsonNode nanny = CouchDB.getInstance().connect(login);

        //bad login
        if (nanny != null) {
            if (nanny.get("password").getTextValue().equals(password)) {
                view = new Viewable("/html/nanny.html");
                cookie = new NewCookie("connected", "true");
            } else {
                view = new Viewable("/html/index.html");
                cookie = new NewCookie("password", "false");
            }
        } else {
            view = new Viewable("/html/index.html");
            cookie = new NewCookie("login", "false");
        }

        Response.ResponseBuilder builder = Response.ok(view)
                .header("Set-Cookie", "connected=deleted;")
                .header("Set-Cookie", "password=deleted;")
                .header("Set-Cookie", "login=deleted;");

        response = builder.cookie(cookie).build();

        return response;
    }
}
