import ht.jy.nanny.couchdb.CouchDB;
import org.codehaus.jackson.JsonNode;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Jeremy Herault
 */
public class CouchDBTest {


   // @Test
    public void testNannyAccess(){

        CouchDB db = CouchDB.getInstance();
        JsonNode nanny = db.connect("amandine");
        System.out.println(nanny.get("password").getTextValue());

    }

}
