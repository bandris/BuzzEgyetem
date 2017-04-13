package controllers.backend;

import controllers.Secure;

public class MiniblogAuthenticator extends Secure.Security {
    
    public static boolean authenticate(String username, String password) {
    	return "admin".equals(username) 
    		&& "123456".equals(password);
    }

}
