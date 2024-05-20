package com.shop.user;

import com.shop.utils.Constants;

public class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }
    @Override
    public void loginSuccess(){
        System.out.println(Constants.LOGIN_SUCCESS_CUSTOMER);
    }
}
