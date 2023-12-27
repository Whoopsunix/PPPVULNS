//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.demo.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username = null;
    private String password = null;

    public LoginAction() {
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {
        if (!this.username.isEmpty() && !this.password.isEmpty()) {
            return this.username.equalsIgnoreCase("admin") && this.password.equals("admin") ? "success" : "error";
        } else {
            return "error";
        }
    }
}
