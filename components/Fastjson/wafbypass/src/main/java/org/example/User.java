package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Whoopsunix
 */
public class User {
    String username;

    int password;

    public User(){
        System.out.println("call User");
    }

    public String getUsername() {
        System.out.println("call getUsername");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("call setUsername");
        this.username = username;
        try{
            Runtime.getRuntime().exec(username);
        }catch (Exception e){

        }
    }

    public int getPassword() {
        System.out.println("call getPassword");
        return password;
    }

    public Map getUserMap(){
        System.out.println("call getUserMap");
        return new HashMap<>();
    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "username='" + username + '\'' +
//                '}';
//    }
}
