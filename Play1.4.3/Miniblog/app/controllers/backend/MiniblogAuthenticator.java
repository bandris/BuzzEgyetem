package controllers.backend;

import controllers.Secure;

public class MiniblogAuthenticator extends Secure.Security {
    
    public static boolean authenticate(String username, String password) {
    	return false; //TODO: ide megírni egy db-hez kapcsolódo authentikálást
    }

}
