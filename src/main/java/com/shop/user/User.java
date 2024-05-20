package com.shop.user;

import com.shop.utils.Constants;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void loginSuccess(){
        System.out.println(Constants.LOGIN_SUCCESS);
    }
}