package ht.jy.nanny.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  @author Jeremy Herault
 */
public class Utils {
    
    public static String COUCHDB_URL;
    
    public static String COUCHDB_USER;
    
    public static String COUCHDB_PWD;
    
    public static String NANNY_REDIRECT = "<html><meta http-equiv=\"refresh\" content=\"2;URL=/nanny.html\"><head></head><body>redirecting ...</body></html>";
    
    static {
        
        InputStream in = Utils.class.getClassLoader().getResourceAsStream("couchdb.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            COUCHDB_URL = properties.getProperty("url");
            COUCHDB_USER = properties.getProperty("user");
            COUCHDB_PWD = properties.getProperty("pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
