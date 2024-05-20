package com.shop.user;

public class Customer extends User {
    public Customer(String username, String password) {
        super(username, password);
    }
    @Override
    public void loginSuccess(){
        System.out.println("You have successfully logged in as a customer!");
    }
}
