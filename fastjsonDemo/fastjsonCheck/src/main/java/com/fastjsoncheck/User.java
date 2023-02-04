package com.fastjsoncheck;

/**
 * @author Whoopsunix
 */
public class User {
    String username;
    int password;
    float id;

    public String getUsername() {
        System.out.println("call getUsername");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("call setUsername");
        this.username = username;
    }

    public int getPassword() {
        System.out.println("call getPassword");
        return password;
    }

    public void setPassword(int password) {
        System.out.println("call setPassword");
        this.password = password;
    }

    public float getId() {
        System.out.println("call getId");
        return id;
    }

    public void setId(float id) {
        System.out.println("call setId");
        this.id = id;
    }

    @Override
    public String toString() {
        System.out.println("call toString");
        return "com.example.User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", id=" + id +
                '}';
    }
}
