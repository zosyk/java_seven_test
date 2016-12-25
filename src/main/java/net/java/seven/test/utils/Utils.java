package net.java.seven.test.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    public static Authentication getAuth(){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return auth;
    }
}
