package com.hospital.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {


    public static String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean matches(String password , String hashedPassword){
        if(password == null  || hashedPassword == null){
            return false;
        }

        return BCrypt.checkpw(password, hashedPassword);
    }
}
