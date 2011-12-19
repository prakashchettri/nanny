package ht.jy.nanny.couchdb;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import ht.jy.nanny.utils.Utils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 *  @author Jeremy Herault
 */
public class CouchDB {

    private static final CouchDB instance;

    private WebResource resource;

    static {
        instance = new CouchDB();
    }

    private CouchDB(){
        Client client =  Client.create();
        client.addFilter(new HTTPBasicAuthFilter(Utils.COUCHDB_USER, Utils.COUCHDB_PWD));
        resource = client.resource(Utils.COUCHDB_URL);
    }

    public static CouchDB getInstance(){
        return instance;
    }

    public JsonNode connect(String nanny_name){
        String pwd = null;
        JsonNode nanny = null;
        try {
            String json = resource.path("nanny").path(nanny_name).get(String.class);
            ObjectMapper mapper = new ObjectMapper();

            nanny = mapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(UniformInterfaceException e){
            e.printStackTrace();
        }
        return nanny;
    }

    public JsonNode getFamilly(String familly_name){
        String json = resource.path("familly").path(familly_name).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode familly = null;
        try {
            familly = mapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return familly;
    }
}
